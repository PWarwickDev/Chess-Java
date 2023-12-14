import javax.swing.*;
import java.awt.*;

public class Board {
    public static PieceBoard pb = new PieceBoard();
    static class DrawingBoard extends JPanel {
        private static final int WIDTH = 960;
        private static final int HEIGHT = 960;

        private static final int OFFSET = 120;


        public DrawingBoard() { setOpaque(true);}

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }

        @Override
        protected void paintComponent(Graphics g) {


            super.paintComponent(g);
            boolean colorToggle = false;
            for (int row = 0; row < HEIGHT; row += OFFSET) {
                for (int col = 0; col < WIDTH; col += OFFSET) {
                    if (!colorToggle) {
                        g.setColor(Color.white);
                    } else {
                        g.setColor(Color.darkGray);
                    }
                    g.fillRect(col, row, OFFSET, OFFSET);
                    if(pb.pieceLayout[row/OFFSET][col/OFFSET] != null) {
                        g.drawImage(pb.pieceLayout[row / OFFSET][col / OFFSET].img, col, row, null);
                        pb.pieceLayout[row / OFFSET][col / OFFSET].xPos = col;
                        pb.pieceLayout[row / OFFSET][col / OFFSET].yPos = row;
                    }
                    colorToggle = !colorToggle;
                }
                colorToggle = !colorToggle;
            }

        }

    }
}


