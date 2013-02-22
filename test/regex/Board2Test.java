package regex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * _ 0 1 2
 * 0 a b
 * 1 c d e
 * 2   f g
 */
@SuppressWarnings("ALL")
public class Board2Test {

    private Board board;

        @Before
        public void prepareBoard() throws Exception {
            board = new Board(2);
            board.setCharacter(0, 0, 'a');
            board.setCharacter(1, 0, 'b');

            board.setCharacter(0, 1, 'c');
            board.setCharacter(1, 1, 'd');
            board.setCharacter(2, 1, 'e');

            board.setCharacter(1, 2, 'f');
            board.setCharacter(2, 2, 'g');
        }

    @Test
    public void createBoard2AndAddExpressions() {
        Board board = new Board(2);
        board.setExpression(Board.Segment.A, 0, ".*H.*H.*");
        board.setExpression(Board.Segment.A, 1, "(DI|NS|TH|OM)*");
        board.setExpression(Board.Segment.B, 0, "F.*[AO].*[AO.*]");
        board.setExpression(Board.Segment.C, 0, ".*(.)(.)(.)(.)\4\3\2\1.*");
        board.setExpression(Board.Segment.C, 1, ".*(IN|SE|HI)");
        board.setExpression(Board.Segment.D, 0, "[^C]*MMM[^C]*");
        board.setExpression(Board.Segment.E, 0, "P+(..)\1.*");
        board.setExpression(Board.Segment.E, 1, "[CHMNOR]*I[CHMNOR]*");
        board.setExpression(Board.Segment.F, 0, "(ND|ET|IN)[^X]*");
    }

    @Test
    public void getStringForExpressionA0() {
        // when
        String string = board.getString(Board.Segment.A, 0);

        // then
        Assert.assertEquals("ab", string);
    }

    @Test
    public void getStringForExpressionA1() {
        // when
        String string = board.getString(Board.Segment.A, 1);

        // then
        Assert.assertEquals("cde", string);
    }

    @Test
    public void getStringForExpressionB0() {
        // when
        String string = board.getString(Board.Segment.B, 0);

        // then
        Assert.assertEquals("fg", string);
    }

    @Test
    public void getStringForExpressionC0() {
        // when
        String string = board.getString(Board.Segment.C, 0);

        // then
        Assert.assertEquals("fc", string);
    }

    @Test
    public void getStringForExpressionC1() {
        // when
        String string = board.getString(Board.Segment.C, 1);

        // then
        Assert.assertEquals("gda", string);
    }

    @Test
    public void getStringForExpressionD0() {
        // when
        String string = board.getString(Board.Segment.D, 0);

        // then
        Assert.assertEquals("eb", string);
    }

    @Test
    public void getStringForExpressionE0() {
        // when
        String string = board.getString(Board.Segment.E, 0);

        // then
        Assert.assertEquals("eg", string);
    }

    @Test
    public void getStringForExpressionE1() {
        // when
        String string = board.getString(Board.Segment.E, 1);

        // then
        Assert.assertEquals("bdf", string);
    }

    @Test
    public void getStringForExpressionF0() {
        // when
        String string = board.getString(Board.Segment.F, 0);

        // then
        Assert.assertEquals("ac", string);
    }



}