package regex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ALL")
public class BoardTest {


    @Test
    public void expressionIsTrue() throws Exception {
        Expression expression = new Expression("(DI|NS|TH|OM)*", "DITH");

        assertTrue(expression.check());
    }

    @Test
    public void expressionIsFalse() throws Exception {
        Expression expression = new Expression("(DI|NS|TH|OM)*", "DIT");

        assertFalse(expression.check());
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


}
