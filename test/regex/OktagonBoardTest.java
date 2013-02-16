package regex;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    /**
     * cells
     * - 4  5
     * 1  2   3
     * - 6  7
     *
     * @throws Exception
     */
    @Test
    public void checkCellNetWithSideLength2() throws Exception {
        // given
        OktagonBoard board = new OktagonBoard(2);

        // when
        Cell head = board.getHead();

        // then
        Cell cell1 = head;
        assertNotNull(cell1);
        assertEquals(3, cell1.getNeighbourCount());

        Cell cell2 = cell1.getEast();
        assertNotNull(cell2);
        assertEquals(6, cell2.getNeighbourCount());

        Cell cell3 = cell2.getEast();
        assertNotNull(cell3);
        assertEquals(3, cell3.getNeighbourCount());

        Cell cell4 = cell1.getNorthEast();
        assertNotNull(cell4);
        assertEquals(3, cell4.getNeighbourCount());

        Cell cell5 = cell4.getEast();
        assertNotNull(cell5);
        assertEquals(3, cell5.getNeighbourCount());

        Cell cell6 = cell1.getSouthEast();
        assertNotNull(cell6);
        assertEquals(3, cell6.getNeighbourCount());

        Cell cell7 = cell6.getEast();
        assertNotNull(cell7);
        assertEquals(3, cell7.getNeighbourCount());

        /**
         * cells
         * - 4  5
         * 1  2   3
         * - 6  7
         */

        assertNeightboursWestEast(cell1, cell2);
        assertNeightboursWestEast(cell2, cell3);
        assertNeightboursWestEast(cell4, cell5);
        assertNeightboursWestEast(cell6, cell7);

        assertNeightboursSouthWestNorthEast(cell1, cell4);
        assertNeightboursSouthWestNorthEast(cell2, cell5);
        assertNeightboursSouthWestNorthEast(cell6, cell2);
        assertNeightboursSouthWestNorthEast(cell7, cell3);

        assertNeightboursNorthWestSouthEast(cell4, cell2);
        assertNeightboursNorthWestSouthEast(cell5, cell3);
        assertNeightboursNorthWestSouthEast(cell1, cell6);
        assertNeightboursNorthWestSouthEast(cell2, cell7);
    }

    public static void assertNeightboursWestEast(Cell west, Cell east) {
        assertEquals(west.getEast(), east);
        assertEquals(west, east.getWest());
    }

    public static void assertNeightboursNorthWestSouthEast(Cell northWest, Cell southEast) {
        assertEquals(northWest.getSouthEast(), southEast);
        assertEquals(northWest, southEast.getNorthWest());
    }

    public static void assertNeightboursSouthWestNorthEast(Cell southWest, Cell nordEast) {
            assertEquals(southWest.getNorthEast(), nordEast);
            assertEquals(southWest, nordEast.getSouthWest());
        }
}
