public class Piece {
    char color;
    char type;

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
    }

}

class Queen extends Piece {
    public Queen(char c) {
        color = c;
        type = 'Q';
    }

}

class Rook extends Piece {
    public Rook(char c) {
        color = c;
        type = 'R';
    }

}

class Bishop extends Piece {
    public Bishop(char c) {
        color = c;
        type = 'B';
    }

}

class Knight extends Piece {
    public Knight(char c) {
        color = c;
        type = 'H';
    }

}

class Pawn extends Piece {
    public Pawn(char c) {
        color = c;
        type = 'P';
    }

}
