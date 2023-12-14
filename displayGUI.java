import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class displayGUI extends JFrame {
    public static Piece selectedPiece = null;
    private static final int GAP = 5;
    displayGUI() {
        JFrame frame = new JFrame("Chess");
        JPanel contentPane = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new BorderLayout(GAP, GAP));
        JPanel drawingBoard = new Board.DrawingBoard();
        contentPane.add(drawingBoard);
        frame.add(contentPane);

        contentPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = getPiece(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (selectedPiece != null) {
                    selectedPiece.move(e.getX() / 120, e.getY() / 120);
                    repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        contentPane.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedPiece != null) {
                    selectedPiece.xPos = e.getX();
                    selectedPiece.yPos = e.getY();
                    repaint();
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


    public static Piece getPiece(int x, int y) {
        if (Board.pb.pieceLayout[y / 120][x / 120] != null) {
            return Board.pb.pieceLayout[y / 120][x / 120];
        }
        return null;
    }

}
