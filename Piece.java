import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Piece {
    char color;
    char type;
    BufferedImage img = null;

    public Piece() {
        color = 'W';
        type = 'N';
    }
    public Piece(char c, char t) {
        color = c;
        type = t;
    }
    char getType() {
        return type;
    } //will be overridden by children piece types

    char getColor() {
        return color;
    }

}

class King extends Piece {

    public King(char c) {
        color = c;
        type = 'K';
        if(color == 'W') {
            try {
                img = ImageIO.read(new File("Chess_W_king"));
            } catch (IOException ignored) {
            }
        } else {
            try {
                img = ImageIO.read(new File("Chess_B_king"));
            } catch (IOException ignored) {
            }
        }
    }

}

class Queen extends Piece {
    public Queen(char c) {
        color = c;
        type = 'Q';
        if(color == 'W') {
            try {
                img = ImageIO.read(new File("Chess_W_queen"));
            } catch (IOException ignored) {
            }
        } else {
            try {
                img = ImageIO.read(new File("Chess_B_queen"));
            } catch (IOException ignored) {
            }
        }
    }

}

class Rook extends Piece {
    public Rook(char c) {
        color = c;
        type = 'R';
        if(color == 'W') {
            try {
                img = ImageIO.read(new File("Chess_W_rook"));
            } catch (IOException ignored) {
            }
        } else {
            try {
                img = ImageIO.read(new File("Chess_B_rook"));
            } catch (IOException ignored) {
            }
        }
    }

}

class Bishop extends Piece {
    public Bishop(char c) {
        color = c;
        type = 'B';
        if(color == 'W') {
            try {
                img = ImageIO.read(new File("Chess_W_bishop"));
            } catch (IOException ignored) {
            }
        } else {
            try {
                img = ImageIO.read(new File("Chess_B_bishop"));
            } catch (IOException ignored) {
            }
        }
    }

}

class Knight extends Piece {
    public Knight(char c) {
        color = c;
        type = 'H';
        if(color == 'W') {
            try {
                img = ImageIO.read(new File("Chess_W_knight"));
            } catch (IOException ignored) {
            }
        } else {
            try {
                img = ImageIO.read(new File("Chess_B_knight"));
            } catch (IOException ignored) {
            }
        }

    }

}

class Pawn extends Piece {
    public Pawn(char c) {
        color = c;
        type = 'P';
        if(color == 'W') {
            try {
                img = ImageIO.read(new File("Chess_W_pawn"));
            } catch (IOException ignored) {
            }
        } else {
            try {
                img = ImageIO.read(new File("Chess_B_pawn"));
            } catch (IOException ignored) {
            }
        }
    }

}
