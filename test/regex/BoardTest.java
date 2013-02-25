package regex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ALL")
public class BoardTest {


    @Test
    public void expressionIsTrue() throws Exception {
        Expression expression = new Expression("(DI|NS|TH|OM)*");

        assertTrue(expression.check("DITH"));
    }

    @Test
    public void expressionIsFalse() throws Exception {
        Expression expression = new Expression("(DI|NS|TH|OM)*");

        assertFalse(expression.check("DIT"));
    }

    @Test
    public void diameterOfSideLength2Is3() {
        Board board = new Board(2);

        assertEquals(3, board.getDiameter());
    }

    @Test
    public void diameterOfSideLength7Is13() {
        Board board = new Board(7);

        assertEquals(13, board.getDiameter());
    }

    @Test
    public void testSameContent() {
        Board board1 = new Board(2);
        board1.setCharacter(0, 0, 'a');
        board1.setCharacter(0, 1, 'b');
        board1.setCharacter(0, 2, 'c');
        board1.setCharacter(1, 0, 'd');
        board1.setCharacter(1, 1, 'e');
        board1.setCharacter(1, 2, 'f');
        board1.setCharacter(2, 0, 'g');
        board1.setCharacter(2, 1, 'h');
        board1.setCharacter(2, 2, 'i');

        Board board2 = new Board(2);
        board2.setCharacter(0, 0, 'a');
        board2.setCharacter(0, 1, 'b');
        board2.setCharacter(0, 2, 'c');
        board2.setCharacter(1, 0, 'd');
        board2.setCharacter(1, 1, 'e');
        board2.setCharacter(1, 2, 'f');
        board2.setCharacter(2, 0, 'g');
        board2.setCharacter(2, 1, 'h');
        board2.setCharacter(2, 2, 'i');

        assertTrue(board1.hasSameContent(board2));
    }

    @Test
    public void testNotSameContent() {
        Board board1 = new Board(2);
        board1.setCharacter(0, 0, 'a');
        board1.setCharacter(0, 1, 'b');
        board1.setCharacter(0, 2, 'c');
        board1.setCharacter(1, 0, 'd');
        board1.setCharacter(1, 1, 'e');
        board1.setCharacter(1, 2, 'f');
        board1.setCharacter(2, 0, 'g');
        board1.setCharacter(2, 1, 'h');
        board1.setCharacter(2, 2, 'i');

        Board board2 = new Board(2);
        board2.setCharacter(0, 0, 'a');
        board2.setCharacter(0, 1, 'b');
        board2.setCharacter(0, 2, 'c');
        board2.setCharacter(1, 0, 'd');
        board2.setCharacter(1, 1, 'e');
        board2.setCharacter(1, 2, 'X');
        board2.setCharacter(2, 0, 'g');
        board2.setCharacter(2, 1, 'h');
        board2.setCharacter(2, 2, 'i');

        assertFalse(board1.hasSameContent(board2));
    }

}
