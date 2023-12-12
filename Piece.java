import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Piece {
    char color; // piece color, either W or B
    char type; // piece type
    int xPos; //x-coordinate of piece
    int yPos; //y-coordinate of piece
    BufferedImage img; //File for image to display(pieces)

    public Piece() {
        color = 'W';
        type = 'N';
        xPos = 0;
        yPos = 0;
    }


    char getType() {
        return type;
    } //will be overridden by children piece types

    char getColor() {
        return color;
    }

    void setPosition(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}

class King extends Piece  {

    public King(char c) throws IOException {
        color = c;
        type = 'K';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\white_king_80x80.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\black_king_80x80.png"));
        }
    }

}

class Queen extends Piece {
    public Queen(char c) throws IOException {
        color = c;
        type = 'Q';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\white_queen_80x80.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\black_queen_80x80.png"));
        }
    }

}

class Rook extends Piece {
    public Rook(char c) throws IOException {
        color = c;
        type = 'R';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\white_rook_100x100.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\black_rook_80x80.png"));
        }
    }

}

class Bishop extends Piece {
    public Bishop(char c) throws IOException {
        color = c;
        type = 'B';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\white_bishop_80x80.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\black_bishop_80x80.png"));
        }
    }

}

class Knight extends Piece {
    public Knight(char c) throws IOException {
        color = c;
        type = 'H';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\white_knight_80x80.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\black_knight_80x80.png"));
        }

    }

}

class Pawn extends Piece {
    public Pawn(char c) throws IOException {
        color = c;
        type = 'P';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\white_pawn_80x80.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\black_pawn_80x80.png"));
        }
    }

}
