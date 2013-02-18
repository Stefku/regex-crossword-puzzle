package regex;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OktagonBoardTest {
    @Test
    public void oktagonBoardWithSideWidth2() throws Exception {
        OktagonBoard board = new OktagonBoard(2);

        assertEquals(7, board.getCellCount());
    }

    @Test
    public void oktagonBoardWithSideWidth7() throws Exception {
        OktagonBoard board = new OktagonBoard(7);

        int sideWith = 2 * (7 * 7 + 6 + 5 + 4 + 3 + 2 + 1) - (7 + 6);
        assertEquals(sideWith, board.getCellCount());
    }

    @Test
    public void funcOf1() throws Exception {
        assertEquals(1, OktagonBoard.func(1));
    }

    @Test
    public void funcOf2() throws Exception {
        assertEquals(3, OktagonBoard.func(2));
    }

    @Test
    public void funcOf3() throws Exception {
        assertEquals(6, OktagonBoard.func(3));
    }

    private int countCells(List<List<Cell>> lines) {
        int result = 0;
        for (List<Cell> line : lines) {
            for (Cell cells : line) {
                result += 1;
            }
        }
        return result;
    }

}
