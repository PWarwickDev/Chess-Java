import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.function.BiPredicate;

public abstract class Piece {
    char color; // piece color, either W or B
    char type; // piece type
    int xPos; //x-coordinate of piece
    int yPos; //y-coordinate of piece
    boolean enPassantPossible;
    BufferedImage img; //File for image to display(pieces)

    public Piece() {
        color = 'W';
        type = 'N';
        xPos = 0;
        yPos = 0;
        enPassantPossible = false;
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

    boolean isChecked;
    public King(char c) throws IOException {
        color = c;
        type = 'K';
        isChecked = false;
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
        int dist = 0;
        System.out.println(x + " " + y);
        if (this.canCastle(x, y, newX, newY)) {
            dist = newX - x;
            switch(y) {

                case 0 -> { //Black side case
                    switch (dist) {
                        case -2 -> { // King castle check left side
                            if (Board.pb.getPiece(0, 0).getColor() == Board.pb.getPiece(4, 0).getColor()) {
                                Board.pb.getPiece(0, 0).setPos(3 * 120, 0);
                                Board.pb.updateBoard(Board.pb.pieceLayout, 0, 0, 3, 0);
                                return true;
                            }
                            return false;
                        }
                        case 2 -> { // King castle check right side
                            if (Board.pb.getPiece(4, 0).getColor() == Board.pb.getPiece(7, 0).getColor()) {
                                Board.pb.getPiece(7, 0).setPos(5 * 120, 0);
                                Board.pb.updateBoard(Board.pb.pieceLayout, 7, 0, 5, 0);
                                return true;
                            }
                            return false;
                        }
                        default -> {
                            return false;
                        }
                    }
                }
                case 7 -> { // White side case
                    switch (dist) {
                        case -2 -> { // King castle check left side
                            if (Board.pb.getPiece(0, 7).getColor() == Board.pb.getPiece(4, 7).getColor()) {
                                Board.pb.getPiece(0, 7).setPos(3 * 120, 7 * 120);
                                Board.pb.updateBoard(Board.pb.pieceLayout, 0, 7, 3, 7);
                                return true;
                            }
                            return false;
                        }
                        case 2 -> { // King castle check right side
                            if (Board.pb.getPiece(4, 7).getColor() == Board.pb.getPiece(7, 7).getColor()) {
                                Board.pb.getPiece(7, 7).setPos(5 * 120, 7 * 120);
                                Board.pb.updateBoard(Board.pb.pieceLayout, 7, 7, 5, 7);
                                System.out.println("h");
                                return true;
                            }
                            return false;
                        }
                        default -> {
                            return false;
                        }
                    }
                }

            }
        }
        return distX + distY <= 2 && distX - distY != 2 && distY - distX != 2;
    }
    public boolean canCastle(int x, int y, int newX, int newY) {
        int dist = 0;
        if (Math.abs(newX - x) == 2 && Math.abs(newY - y) == 0) {
            dist = newX - x;
            switch (y) {
                case 0 ->  {
                    switch (dist) {
                        case -2 -> { // King castle check left side
                            if (Board.pb.getPiece(3, 0) != null) {
                                return false;
                            } else if (Board.pb.getPiece(2, 0) != null) {
                                return false;
                            } else // is not castling with a rook
                                if (Board.pb.getPiece(1, 0) != null) {
                                    return false;
                                } else return Board.pb.getPiece(0, 0).getType() == 'R';
                        }
                        case 2 -> { // King castle check right side
                            if (Board.pb.getPiece(5, 0) != null) {
                                return false;
                            } else if (Board.pb.getPiece(6, 0) != null) {
                                return false;
                            } else return Board.pb.getPiece(7, 0).getType() == 'R';
                        }
                        default -> {
                            return false;
                        }
                    }
                }

                case 7 ->  {
                    switch (dist) {
                        case -2 -> { // King castle check left side
                            if (Board.pb.getPiece(3, 7) != null) {
                                return false;
                            } else if (Board.pb.getPiece(2, 7) != null) {
                                return false;
                            } else // is not castling with a rook
                                if (Board.pb.getPiece(1, 7) != null) {
                                    return false;
                                } else return Board.pb.getPiece(0, 7).getType() == 'R';
                        }
                        case 2 -> { // King castle check right side
                            if (Board.pb.getPiece(5, 7) != null) {
                                return false;
                            } else if (Board.pb.getPiece(6, 7) != null) {
                                return false;
                            } else return Board.pb.getPiece(7, 7).getType() == 'R';
                        }
                        default -> {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void castlingSwap(int x, int y, int newX) {
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

    @Override
    public boolean canMove(int x, int y, int newX, int newY) {
        if (Math.abs(newX - x) == 2 && Math.abs(newY - y) == 1) {
            return true;
        } else return Math.abs(newX - x) == 1 && Math.abs(newY - y) == 2;
    }

}

class Pawn extends Piece {
    boolean enPassantPossible = false;
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
        if (this.color == 'W') {
            if (y - newY == 1 && newX == x && Board.pb.getPiece(newX, newY) == null) { // 1 square forward case
                Board.pb.pieceLayout[y][x].enPassantPossible = false;
                return true;
            } else if (y - newY == 1 && Math.abs(newX - x) == 1 && Board.pb.getPiece(newX, newY) != null &&
                    Board.pb.getPiece(newX, newY).type != 'K') { // Taking a piece case
                Board.pb.pieceLayout[y][x].enPassantPossible = false;
                return true;
            } else if (y - newY == 1 && Math.abs(newX - x) == 1 && Board.pb.getPiece(newX, newY) == null && Board.pb.getPiece(newX, y) != null &&
                    Board.pb.getPiece(newX, y).type == 'P' && y == 3) { // En passant
                if (Board.pb.getPiece(newX, y).enPassantPossible) {
                    Board.pb.kill(newX, y);
                    Board.pb.pieceLayout[y][x].enPassantPossible = false;
                    return true;
                }

            } else if (y - newY == 2 && Math.abs(newX - x) == 0 && y == 6 && Board.pb.getPiece(newX, newY) == null) { // 2 square move off front line case
                Board.pb.pieceLayout[y][x].enPassantPossible = true;
                return true;
            }
        } else if (this.color == 'B') {
            if (newY - y == 1 && newX == x && Board.pb.getPiece(newX, newY) == null) {
                Board.pb.pieceLayout[y][x].enPassantPossible = false;
                return true;
            } else if (newY - y == 1 && Math.abs(newX - x) == 1 && Board.pb.getPiece(newX, newY) != null &&
                    Board.pb.getPiece(newX, newY).type != 'K') {
                Board.pb.pieceLayout[y][x].enPassantPossible = false;
                return true;
            }  else if (newY - y == 1 && Math.abs(newX - x) == 1 && Board.pb.getPiece(newX, newY) == null && Board.pb.getPiece(newX, y) != null &&
                    Board.pb.getPiece(newX, y).type == 'P' && y == 4) { // En passant
                if (Board.pb.getPiece(newX, y).enPassantPossible) {
                    Board.pb.kill(newX, y);
                    Board.pb.pieceLayout[y][x].enPassantPossible = false;
                    return true;
                }
            } else if (newY - y == 2 && Math.abs(newX - x) == 0 && y == 1 && Board.pb.getPiece(newX, newY) == null) { // 2 square move off front line case
                Board.pb.pieceLayout[y][x].enPassantPossible = true;
                return true;
            }
        }
        return false;
    }

}
