import javax.swing.*;
import java.awt.*;

public class Board {
    static class DrawingBoard extends JPanel {
        private static final int WIDTH = 960;
        private static final int HEIGHT = 960;

        static PieceBoard pb = new PieceBoard();

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
            for (int row = 0; row < HEIGHT; row += 120) {
                for (int col = 0; col < WIDTH; col += 120) {
                    if (!colorToggle) {
                        g.setColor(Color.white);
                    } else {
                        g.setColor(Color.darkGray);
                    }
                    g.fillRect(col, row, col + 120, row + 120);
                    if(pb.pieceLayout[row/120][col/120] != null) {
                        g.drawImage(pb.pieceLayout[row / 120][col / 120].img, col, row, null);
                    }
                    colorToggle = !colorToggle;
                }
                colorToggle = !colorToggle;
            }

        }
    }
}


