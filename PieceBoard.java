
import java.io.IOException;

public class PieceBoard {
    Piece[][] pieceLayout;

    {
        try {
            pieceLayout = new Piece[][]{ // Creation of object piece layout
                    {new Rook('B'), new Knight('B'), new Bishop('B'), new Queen('B'),
                            new King('B'), new Bishop('B'), new Knight('B'), new Rook('B')},
                    {new Pawn('B'), new Pawn('B'), new Pawn('B'), new Pawn('B'),
                            new Pawn('B'), new Pawn('B'), new Pawn('B'), new Pawn('B')},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {new Pawn('W'), new Pawn('W'), new Pawn('W'), new Pawn('W'),
                            new Pawn('W'), new Pawn('W'), new Pawn('W'), new Pawn('W')},
                    {new Rook('W'), new Knight('W'), new Bishop('W'), new Queen('W'),
                            new King('W'), new Bishop('W'), new Knight('W'), new Rook('W')}
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBoard(Piece[][] pb, int x1, int y1, int x2, int y2) {
        System.out.println(x1 + ", " + y1 + " to " + x2 + ", " + y2);
        Piece pTemp = null;
        pTemp = pb[y1][x1];
        pb[y1][x1] = pb[y2][x2];
        pb[y2][x2] = pTemp;
    }


}
