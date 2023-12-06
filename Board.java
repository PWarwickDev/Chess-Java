import javax.swing.*;
import java.awt.*;

public class Board {

    static class DrawingBoard extends JPanel {
        private static final int WIDTH = 800;
        private static final int HEIGHT = 800;


        public DrawingBoard() {
            setOpaque(true);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
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
}


