import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

            final BufferedImage image;
            try {
                image = ImageIO.read(new File("chessPieceFiles\\white_rook_100x100.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            super.paintComponent(g);
            boolean colorToggle = false;
            for (int row = 0; row < HEIGHT; row += 100) {
                for (int col = 0; col < WIDTH; col += 100) {
                    if (!colorToggle) {
                        g.setColor(Color.white);
                    } else {
                        g.setColor(Color.black);
                    }
                    g.fillRect(col, row, col + 100, row + 100);
                    colorToggle = !colorToggle;
                }
                colorToggle = !colorToggle;
            }
            g.drawImage(image, 100, 0, null);
        }
    }
}


