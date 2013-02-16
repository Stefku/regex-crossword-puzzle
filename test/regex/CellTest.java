package regex;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CellTest {
    @Test
    public void neighboutCount() {
        Cell cell = new Cell();
        assertEquals(0, cell.getNeighbourCount());
    }

    @Test
    public void neighbourCount6() {
        Cell cell = new Cell();
        cell.setEast(new Cell());
        cell.setWest(new Cell());
        cell.setNorthWest(new Cell());
        cell.setSouthWest(new Cell());
        cell.setNorthEast(new Cell());
        cell.setSouthEast(new Cell());

        assertEquals(6, cell.getNeighbourCount());
    }
}
