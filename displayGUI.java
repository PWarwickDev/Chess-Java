import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class displayGUI extends JFrame{
    private static final int GAP = 5;
    displayGUI() {
        JFrame frame = new JFrame("Chess");
        JPanel contentPane = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(new BorderLayout(GAP, GAP));
        JPanel drawingBoard = new Board.DrawingBoard();
        contentPane.add(drawingBoard);

        contentPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + ", " + e.getY());
                System.out.println(getPieceType(e.getX(), e.getY()) +
                        " , " + getPieceColor(e.getX(), e.getY()));
            }

            @Override
            public void mouseReleased(MouseEvent e) {

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

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        frame.getContentPane().add(contentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }


    public static char getPieceType(int x, int y) {
        if (Board.pb.pieceLayout[y / 120][x / 120] != null) {
            return Board.pb.pieceLayout[y / 120][x / 120].type;
        }
        return '@';
    }
    public static char getPieceColor(int x, int y) {
        if (Board.pb.pieceLayout[y / 120][x / 120] != null) {
            return Board.pb.pieceLayout[y / 120][x / 120].color;
        }
        return '@';
    }
}
