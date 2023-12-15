import javax.imageio.ImageIO;
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

    int getxPos() {
        return xPos;
    }

    int getyPos() {
        return yPos;
    }

    char getType() {
        return type;
    } //will be overridden by children piece types

    char getColor() {return color;}

    void setPos(int x, int y) {
        xPos = x;
        yPos = y;
    }


}

class King extends Piece  {

    public King(char c) throws IOException {
        color = c;
        type = 'K';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\w-king.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\b-king.png"));
        }
    }

}

class Queen extends Piece {
    public Queen(char c) throws IOException {
        color = c;
        type = 'Q';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\w-queen.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\b-queen.png"));
        }
    }

}

class Rook extends Piece {
    public Rook(char c) throws IOException {
        color = c;
        type = 'R';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\w-rook.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\b-rook.png"));
        }
    }

}

class Bishop extends Piece {
    public Bishop(char c) throws IOException {
        color = c;
        type = 'B';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\w-bishop.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\b-bishop.png"));
        }
    }

}

class Knight extends Piece {
    public Knight(char c) throws IOException {
        color = c;
        type = 'H';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\w-knight.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\b-knight.png"));
        }

    }

}

class Pawn extends Piece {
    public Pawn(char c) throws IOException {
        color = c;
        type = 'P';
        if(color == 'W') {
            img = ImageIO.read(new File("chessPieceFiles\\w-pawn.png"));
        } else {
            img = ImageIO.read(new File("chessPieceFiles\\b-pawn.png"));
        }
    }

}
