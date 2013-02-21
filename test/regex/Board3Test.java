package regex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * board for sideLength=2 looks like
 * <PRE>
 * _ 0 1 2 3 4
 * 0 a b c
 * 1 d e f g
 * 2 h i j k l
 * 3   m n o p
 * 4     q r s
 * </PRE>
 */
@SuppressWarnings("ALL")
public class Board3Test {

    private Board board;

    @Before
    public void prepareBoard() throws Exception {
        board = new Board(3);
        board.setCharacter(0, 0, 'a');
        board.setCharacter(1, 0, 'b');
        board.setCharacter(2, 0, 'c');

        board.setCharacter(0, 1, 'd');
        board.setCharacter(1, 1, 'e');
        board.setCharacter(2, 1, 'f');
        board.setCharacter(3, 1, 'g');

        board.setCharacter(0, 2, 'h');
        board.setCharacter(1, 2, 'i');
        board.setCharacter(2, 2, 'j');
        board.setCharacter(3, 2, 'k');
        board.setCharacter(4, 2, 'l');

        board.setCharacter(1, 3, 'm');
        board.setCharacter(2, 3, 'n');
        board.setCharacter(3, 3, 'o');
        board.setCharacter(4, 3, 'p');

        board.setCharacter(2, 4, 'q');
        board.setCharacter(3, 4, 'r');
        board.setCharacter(4, 4, 's');
    }

    @Test
    public void getStringForExpressionA0() {
        // when
        String string = board.getString(Board.Segment.A, 0);

        // then
        Assert.assertEquals("abc", string);
    }

    @Test
    public void getStringForExpressionA1() {
        // when
        String string = board.getString(Board.Segment.A, 1);

        // then
        Assert.assertEquals("defg", string);
    }

    @Test
    public void getStringForExpressionA2() {
        // when
        String string = board.getString(Board.Segment.A, 2);

        // then
        Assert.assertEquals("hijkl", string);
    }

    @Test
    public void getStringForExpressionB0() {
        // when
        String string = board.getString(Board.Segment.B, 0);

        // then
        Assert.assertEquals("mnop", string);
    }

    @Test
    public void getStringForExpressionB1() {
        // when
        String string = board.getString(Board.Segment.B, 1);

        // then
        Assert.assertEquals("qrs", string);
    }

    @Test
    public void getStringForExpressionC0() {
        // when
        String string = board.getString(Board.Segment.C, 0);

        // then
        Assert.assertEquals("qmh", string);
    }

    @Test
    public void getStringForExpressionC1() {
        // when
        String string = board.getString(Board.Segment.C, 1);

        // then
        Assert.assertEquals("rnid", string);
    }

    @Test
    public void getStringForExpressionC2() {
        // when
        String string = board.getString(Board.Segment.C, 2);

        // then
        Assert.assertEquals("sojea", string);
    }

    @Test
    public void getStringForExpressionD0() {
        // when
        String string = board.getString(Board.Segment.D, 0);

        // then
        Assert.assertEquals("pkfb", string);
    }

    @Test
    public void getStringForExpressionD1() {
        // when
        String string = board.getString(Board.Segment.D, 1);

        // then
        Assert.assertEquals("lgc", string);
    }

    @Test
    public void getStringForExpressionE0() {
        // when
        String string = board.getString(Board.Segment.E, 0);

        // then
        Assert.assertEquals("lps", string);
    }

    @Test
    public void getStringForExpressionE1() {
        // when
        String string = board.getString(Board.Segment.E, 1);

        // then
        Assert.assertEquals("gkor", string);
    }

    @Test
    public void getStringForExpressionE2() {
        // when
        String string = board.getString(Board.Segment.E, 2);

        // then
        Assert.assertEquals("cfjnq", string);
    }

    @Test
    public void getStringForExpressionF0() {
        // when
        String string = board.getString(Board.Segment.F, 0);

        // then
        Assert.assertEquals("beim", string);
    }

    @Test
    public void getStringForExpressionF1() {
        // when
        String string = board.getString(Board.Segment.F, 1);

        // then
        Assert.assertEquals("adh", string);
    }
}