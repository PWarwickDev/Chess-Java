import javax.swing.*;
import java.awt.*;

public class Board {

    static PieceBoard pb = new PieceBoard();

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
                    g.fillRect(col, row, col + 100, row + 100); //fillrect overhangs by 1
                    colorToggle = !colorToggle;
                }
                colorToggle = !colorToggle;
            }
            int w = pb.pieceLayout[0][0].ii.getIconWidth();
            int h = pb.pieceLayout[0][0].ii.getIconHeight();
            setPreferredSize(new Dimension(w, h));
            pb.pieceLayout[0][0].ii.paintIcon(this, g, 0, 0);
           System.out.println(pb.pieceLayout[0][0].ii.getDescription());
        }
    }
}


