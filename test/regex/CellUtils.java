package regex;

import java.util.EnumSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class CellUtils {

    private CellUtils() {
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

    public static void assertHasAllNeighboursInDirections(Cell cell, EnumSet<Direction> directions) {
        for (Direction direction : directions) {
            assertTrue(cell.hasNeighbour(direction));
        }
    }

    public static void assertHasNoNeighboursInDirections(Cell cell, EnumSet<Direction> directions) {
        for (Direction direction : directions) {
            assertFalse(cell.hasNeighbour(direction));
        }
    }

    public static void assertHasJustNeighboursInDirection(Cell cell, EnumSet<Direction> directions) {
        assertHasAllNeighboursInDirections(cell, directions);
        assertHasNoNeighboursInDirections(cell, EnumSet.complementOf(directions));
    }
}
