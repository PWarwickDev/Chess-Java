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


    char getType() {
        return type;
    } //will be overridden by children piece types

    char getColor() {return color;}

    void setPos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    boolean canMove(int x, int y, int newX, int newY) throws IOException {
        return false;
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
    @Override
    public boolean canMove(int x, int y, int newX, int newY) {
        int distX = Math.abs(newX - x);
        int distY = Math.abs(newY - y);
        return distX + distY <= 2 && distX - distY != 2 && distY - distX != 2;
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

    @Override
    public boolean canMove(int x, int y, int newX, int newY) throws IOException {
        Piece tmpB = new Bishop(this.getColor());
        Piece tmpR = new Rook(this.getColor()); //Used to evaluate queen movement as they can move as rooks or bishops do
        //Since these are mutually exclusive, a simple or produces valid cases.
        return tmpB.canMove(x, y, newX, newY) || tmpR.canMove(x, y, newX, newY);
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

    @Override
    public boolean canMove(int x, int y, int newX, int newY) {
        if (newX - x > -8 && newX - x != 0 && Math.abs(newY - y) == 0) {
            if (newX - x >= 1) {
                for (int i = x + 1; i <= newX - 1; i++) { //Right
                    if (Board.pb.getPiece(i, y) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = x - 1; i >= newX + 1; i--) { //Left
                    if (Board.pb.getPiece(i, y) != null) {
                        return false;
                    }
                }
            }
            return true;
        } else if (newY - y > -8 && newY - y != 0 && Math.abs(newX - x) == 0) {
            if (newY - y >= 1) {
                for (int i = y + 1; i <= newY - 1; i++) { //Down
                    if (Board.pb.getPiece(x, i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = y - 1; i >= newY + 1; i--) { //Up
                    if (Board.pb.getPiece(x, i) != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
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

    @Override
    public boolean canMove(int x, int y, int newX, int newY) {
        int diagCheckVal = Math.abs(newX-x) - Math.abs(newY-y); // Should be zero for diagonal moves
        if ((newX - x >= 1) && (newY - y >= 1) && diagCheckVal == 0) { // Down and Right
            for (int i = x + 1, j = y + 1 ; i <= newX - 1; i++, j++) {
                if (Board.pb.getPiece(i, j) != null) {
                    return false;
                }
            }
            return true;
        } else if ((newX - x >= 1) && (newY - y <= -1) && diagCheckVal == 0) { // Up and right
            for (int i = x + 1, j = y - 1 ; i <= newX - 1; i++, j--) {
                if (Board.pb.getPiece(i, j) != null) {
                    return false;
                }
            }
            return true;
        } else if ((newX - x <= -1) && (newY - y <= 1) && diagCheckVal == 0) { // Up and Left
            for (int i = x - 1, j = y - 1 ; i >= newX + 1; i--, j--) {
                if (Board.pb.getPiece(i, j) != null) {
                    return false;
                }
            }
            return true;
        } else if ((newX - x <= -1) && (newY - y >= 1) && diagCheckVal == 0) { // Down and Left
            for (int i = x - 1, j = y + 1 ; i >= newX + 1; i--, j++) {
                if (Board.pb.getPiece(i, j) != null) {
                    return false;
                }
            }
            return true;
        }
        return false;  //Blocked or no move case
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

    @Override
    public boolean canMove(int x, int y, int newX, int newY) {
        return true;
    }

}
