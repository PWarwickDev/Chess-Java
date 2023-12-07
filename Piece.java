import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Piece {
    char color;
    char type;
    ImageIcon ii = null;

    public Piece() {
        color = 'W';
        type = 'N';
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
            ii = new ImageIcon("chessPieceFiles/Chess_W_king");
        } else {
            ii = new ImageIcon("chessPieceFiles/Chess_B_king");
        }
    }

}

class Queen extends Piece {
    public Queen(char c) {
        color = c;
        type = 'Q';
        if(color == 'W') {
            ii = new ImageIcon("chessPieceFiles/Chess_W_queen");
        } else {
            ii = new ImageIcon("chessPieceFiles/Chess_B_queen");
        }
    }

}

class Rook extends Piece {
    public Rook(char c) {
        color = c;
        type = 'R';
        if(color == 'W') {
            ii = new ImageIcon("chessPieceFiles/Chess_W_rook");
        } else {
            ii = new ImageIcon("chessPieceFiles/Chess_B_rook");
        }
    }

}

class Bishop extends Piece {
    public Bishop(char c) {
        color = c;
        type = 'B';
        if(color == 'W') {
            ii = new ImageIcon("chessPieceFiles/Chess_W_bishop");
        } else {
            ii = new ImageIcon("chessPieceFiles/Chess_B_bishop");
        }
    }

}

class Knight extends Piece {
    public Knight(char c) {
        color = c;
        type = 'H';
        if(color == 'W') {
            ii = new ImageIcon("chessPieceFiles/Chess_W_knight");
        } else {
            ii = new ImageIcon("chessPieceFiles/Chess_B_knight");
        }

    }

}

class Pawn extends Piece {
    public Pawn(char c) {
        color = c;
        type = 'P';
        if(color == 'W') {
            ii = new ImageIcon("chessPieceFiles/Chess_W_pawn");
        } else {
            ii = new ImageIcon("chessPieceFiles/Chess_B_pawn");
        }
    }

}
