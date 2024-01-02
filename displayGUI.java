import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class displayGUI extends JFrame {
    public static Piece selectedPiece = null;
    private static final int GAP = 5;
    static int fromX = 0;
    static int fromY = 0;
    static char currPlayer = 'W'; // Current player color
    static int turnCount = 0;
    displayGUI() {
        JFrame frame = new JFrame("Chess");
        JPanel contentPane = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new BorderLayout(GAP, GAP));
        JPanel drawingBoard = new Board.DrawingBoard();
        contentPane.add(drawingBoard);
        frame.add(contentPane);

        drawingBoard.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {selectedPiece = selectPiece(e.getX(), e.getY());}

            @Override
            public void mouseReleased(MouseEvent e) {
                if (selectedPiece != null) {
                    if(e.getX() <= 960 && e.getY() <= 960) {
                        //Checking move validity before updating piece board
                        try {
                            if (Board.pb.isValidMove(Board.pb.pieceLayout, fromX, fromY,
                                    e.getX() / 120, e.getY() / 120)) {
                                Board.pb.updateBoard(Board.pb.pieceLayout, fromX, fromY,
                                        e.getX() / 120, e.getY() / 120);
                                selectedPiece.setPos(e.getX() - (e.getX() % 120), e.getY() - (e.getY() % 120)); //Updates piece to align within tiles
                                drawingBoard.repaint();
                                currPlayer = currPlayer == 'W' ? 'B' : 'W'; // Swapping current player
                                turnCount++;
                            } else {
                                selectedPiece.setPos(fromX * 120, fromY * 120); // Resetting piece if move is invalid
                                drawingBoard.repaint();
                            }
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    selectedPiece = null;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selectedPiece != null) {
                    resetPiece(selectedPiece); // Reset piece to avoid moving off the panel
                    selectedPiece = null;
                    drawingBoard.repaint();
                }
            }
        });

        drawingBoard.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedPiece != null) {
                    if(e.getX() <= 960 && e.getY() <= 960) {
                        selectedPiece.setPos(e.getX() - 60, e.getY() - 60); // Updates piece to be centered on mouse while dragging
                        drawingBoard.repaint();
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }


    public static Piece selectPiece(int x, int y) {
        if (Board.pb.pieceLayout[y / 120][x / 120] != null && currPlayer == Board.pb.pieceLayout[y / 120][x / 120].getColor()) { // If piece is not null and has the current player color
            fromX = x/120;
            fromY = y/120;
            return Board.pb.getPiece(x / 120, y / 120);
        }
        return null;
    }
    public static void resetPiece(Piece p) {
        selectedPiece.setPos(fromX * 120, fromY * 120); // Reset piece to original place
    }

}
