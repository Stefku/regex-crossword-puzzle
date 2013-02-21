package regex;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("ALL")
public class Board2Test {

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
        // with
        Board board = new Board(2);
        board.setCharacter(0, 0, 'a');
        board.setCharacter(1, 0, 'b');

        // when
        String string = board.getString(Board.Segment.A, 0);

        // then
        Assert.assertEquals("ab", string);
    }

    @Test
    public void getStringForExpressionA1() {
        // with
        Board board = new Board(2);
        board.setCharacter(0, 1, 'c');
        board.setCharacter(1, 1, 'd');
        board.setCharacter(2, 1, 'e');

        // when
        String string = board.getString(Board.Segment.A, 1);

        // then
        Assert.assertEquals("cde", string);
    }

    @Test
    public void getStringForExpressionB0() {
        // with
        Board board = new Board(2);
        board.setCharacter(1, 2, 'f');
        board.setCharacter(2, 2, 'g');

        // when
        String string = board.getString(Board.Segment.B, 0);

        // then
        Assert.assertEquals("fg", string);
    }

    @Test
    public void getStringForExpressionC0() {
        // with
        Board board = new Board(2);
        board.setCharacter(1, 2, 'h');
        board.setCharacter(0, 1, 'i');

        // when
        String string = board.getString(Board.Segment.C, 0);

        // then
        Assert.assertEquals("hi", string);
    }

    @Test
    public void getStringForExpressionC1() {
        // with
        Board board = new Board(2);
        board.setCharacter(2, 2, 'j');
        board.setCharacter(1, 1, 'k');
        board.setCharacter(0, 0, 'l');

        // when
        String string = board.getString(Board.Segment.C, 1);

        // then
        Assert.assertEquals("jkl", string);
    }

    @Test
    public void getStringForExpressionD0() {
        // with
        Board board = new Board(2);
        board.setCharacter(2, 1, 'm');
        board.setCharacter(1, 0, 'n');

        // when
        String string = board.getString(Board.Segment.D, 0);

        // then
        Assert.assertEquals("mn", string);
    }

    @Test
    public void getStringForExpressionE0() {
        // with
        Board board = new Board(2);
        board.setCharacter(2, 1, 'o');
        board.setCharacter(2, 2, 'p');

        // when
        String string = board.getString(Board.Segment.E, 0);

        // then
        Assert.assertEquals("op", string);
    }

    @Test
    public void getStringForExpressionE1() {
        // with
        Board board = new Board(2);
        board.setCharacter(1, 0, 'q');
        board.setCharacter(1, 1, 'r');
        board.setCharacter(1, 2, 's');

        // when
        String string = board.getString(Board.Segment.E, 1);

        // then
        Assert.assertEquals("qrs", string);
    }

    @Test
    public void getStringForExpressionF0() {
        // with
        Board board = new Board(2);
        board.setCharacter(0, 0, 't');
        board.setCharacter(0, 1, 'u');

        // when
        String string = board.getString(Board.Segment.F, 0);

        // then
        Assert.assertEquals("tu", string);
    }
}