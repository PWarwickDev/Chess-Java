import static org.junit.Assert.*;
import org.junit.Test;

public class PieceTest {

    @Test
    public void baseTest() {
        Piece p = new Piece();
        assertEquals("Error in piece type", 'N', p.getType());
        assertEquals("Error in piece color", 'W', p.getColor());
    }
    @Test
    public void kingTest() {
        Piece p = new King('R');
        assertEquals("Error in piece type", 'K', p.getType());
        assertEquals("Error in piece color", 'R', p.getColor());
    }
    @Test
    public void queenTest() {
        Piece p = new Queen('W');
        assertEquals("Error in piece type", 'Q', p.getType());
        assertEquals("Error in piece color", 'W', p.getColor());
    }

    @Test
    public void rookTest() {
        Piece p = new Rook('W');
        assertEquals("Error in piece type", 'R', p.getType());
        assertEquals("Error in piece color", 'W', p.getColor());
    }

    @Test
    public void bishopTest() {
        Piece p = new Bishop('R');
        assertEquals("Error in piece type", 'B', p.getType());
        assertEquals("Error in piece color", 'R', p.getColor());
    }

    @Test
    public void knightTest() {
        Piece p = new Knight('W');
        assertEquals("Error in piece type", 'H', p.getType());
        assertEquals("Error in piece color", 'W', p.getColor());
    }

    @Test
    public void pawnTest() {
        Piece p = new Pawn('R');
        assertEquals("Error in piece type", 'P', p.getType());
        assertEquals("Error in piece color", 'R', p.getColor());
    }
}
