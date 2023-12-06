import javax.swing.*;
import java.awt.*;



public class Board {

    //private JButton button;

    private static final int GAP = 5;

    private void displayGUI() {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout (new BorderLayout(GAP, GAP));
        JPanel drawingBoard = new DrawingBoard();
        contentPane.add (drawingBoard, BorderLayout.CENTER);


        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        Runnable runnable = () -> new Board().displayGUI();
        EventQueue.invokeLater( runnable );
    }
}

class DrawingBoard extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;



    public DrawingBoard() {
        setOpaque(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension (WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean colorToggle = false;
        for (int row = 0; row < HEIGHT; row += 100) {
            for (int col = 0; col < WIDTH; col += 100) {
                //fillrect overhangs by 1
                if (!colorToggle) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.black);
                }
                g.fillRect(col, row, col + 99, row + 99); //fillrect overhangs by 1
                colorToggle = !colorToggle;
            }
            colorToggle = !colorToggle;
        }
    }
}


