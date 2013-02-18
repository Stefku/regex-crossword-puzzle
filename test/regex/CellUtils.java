package regex;

import static org.junit.Assert.assertEquals;

public abstract class CellUtils {

    private CellUtils() {}

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

    public static void assertJustNeighboursInDirections(Cell cell, Direction... directions) {
        for (Direction direction : directions) {
//            assert
        }
    }
}
