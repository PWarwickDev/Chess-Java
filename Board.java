import javax.swing.*;
import java.awt.*;

public class Board {
    public static PieceBoard pb = new PieceBoard();
    static class DrawingBoard extends JPanel {
        private static final int WIDTH = 960;
        private static final int HEIGHT = 960;
        private static final int OFFSET = 120;

        boolean afterStart = false;


        public DrawingBoard() { setOpaque(true);}

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }

        @Override
        protected void paintComponent(Graphics g) {
            System.out.println("method called to paint");
            super.paintComponent(g);
            boolean colorToggle = false;
            for (int row = 0; row < HEIGHT; row += OFFSET) {
                for (int col = 0; col < WIDTH; col += OFFSET) {
                    if (!colorToggle) {
                        g.setColor(Color.white);
                    } else {
                        g.setColor(Color.gray);
                    }
                    g.fillRect(col, row, OFFSET, OFFSET);
                    colorToggle = !colorToggle;
                }
                colorToggle = !colorToggle;
            }

            if (!afterStart) { // Game beginning painting loop
                for (int row = 0; row < HEIGHT / 120; row++) {
                    for (int col = 0; col < WIDTH / 120; col++) {
                        if (pb.pieceLayout[row][col] != null) {
                            g.drawImage(pb.pieceLayout[row][col].img,
                                    col * 120,
                                    row * 120, null);
                            pb.pieceLayout[row][col].setPos(col * 120, row * 120);
                        }
                    }

                }
                afterStart = true;
            } else { //After game has begun
                for (int row = 0; row < HEIGHT / 120; row++) {
                    for (int col = 0; col < WIDTH / 120; col++) {
                        if (pb.pieceLayout[row][col] != null) {
                            g.drawImage(pb.pieceLayout[row][col].img,
                                    pb.pieceLayout[row][col].xPos,
                                    pb.pieceLayout[row][col].yPos, null);
                        }
                    }

                }
            }

        }



    }
}


