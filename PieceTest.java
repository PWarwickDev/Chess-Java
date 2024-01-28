import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;

public class PieceTest {


    @Test
    public void kingTest() throws IOException {
        Piece p = new King('B');
        assertEquals("Error in piece type", 'K', p.getType());
        assertEquals("Error in piece color", 'B', p.getColor());
    }
    @Test
    public void queenTest() throws IOException {
        Piece p = new Queen('W');
        assertEquals("Error in piece type", 'Q', p.getType());
        assertEquals("Error in piece color", 'W', p.getColor());
    }

    @Test
    public void rookTest() throws IOException {
        Piece p = new Rook('W');
        assertEquals("Error in piece type", 'R', p.getType());
        assertEquals("Error in piece color", 'W', p.getColor());
    }

    @Test
    public void bishopTest() throws IOException {
        Piece p = new Bishop('B');
        assertEquals("Error in piece type", 'B', p.getType());
        assertEquals("Error in piece color", 'B', p.getColor());
    }

    @Test
    public void knightTest() throws IOException {
        Piece p = new Knight('W');
        assertEquals("Error in piece type", 'H', p.getType());
        assertEquals("Error in piece color", 'W', p.getColor());
    }

    @Test
    public void pawnTest() throws IOException {
        Piece p = new Pawn('B');
        assertEquals("Error in piece type", 'P', p.getType());
        assertEquals("Error in piece color", 'B', p.getColor());
    }
}
