import org.junit.Test;
import regex.Board;

import java.util.regex.Pattern;

public class MITRegexGame {

    @Test
    public void playTheGame() {
        Board board = new Board(7);

        board.setExpression(Board.Segment.A, 0, Pattern.compile(".*H.*H.*"));
        board.setExpression(Board.Segment.A, 1, Pattern.compile("(DI|NS|TH|OM)*"));
        board.setExpression(Board.Segment.B, 0, Pattern.compile("F.*[AO].*[AO.*]"));
        board.setExpression(Board.Segment.C, 0, Pattern.compile(".*(.)(.)(.)(.)\4\3\2\1.*"));
        board.setExpression(Board.Segment.C, 1, Pattern.compile(".*(IN|SE|HI)"));
        board.setExpression(Board.Segment.D, 0, Pattern.compile("[^C]*MMM[^C]*"));
        board.setExpression(Board.Segment.E, 0, Pattern.compile("P+(..)\1.*"));
        board.setExpression(Board.Segment.E, 1, Pattern.compile("[CHMNOR]*I[CHMNOR]*"));
        board.setExpression(Board.Segment.F, 0, Pattern.compile("(ND|ET|IN)[^X]*"));
    }
}
