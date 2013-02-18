package regex;

import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.fail;


public class CellUtilsTest {
    @Test
    public void testAssertNeighboursWestEast() {
        Cell a = new Cell();
        Cell b = new Cell();
        a.setEast(b);
        b.setWest(a);

        CellUtils.assertNeightboursWestEast(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testAssertNeighboursWestEastFailsForMissing1() {
        Cell a = new Cell();
        Cell b = new Cell();
        a.setEast(b);

        CellUtils.assertNeightboursWestEast(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testAssertNeighboursWestEastFailsForMissing2() {
        Cell a = new Cell();
        Cell b = new Cell();
        b.setWest(a);

        CellUtils.assertNeightboursWestEast(a, b);
    }

    @Test
    public void testAssertNeighboursNorthWestSouthEast() {
        Cell a = new Cell();
        Cell b = new Cell();
        a.setSouthEast(b);
        b.setNorthWest(a);

        CellUtils.assertNeightboursNorthWestSouthEast(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testAssertNeighboursNorthWestSouthEastFailsForMissing1() {
        Cell a = new Cell();
        Cell b = new Cell();
        b.setNorthWest(a);

        CellUtils.assertNeightboursNorthWestSouthEast(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testAssertNeighboursNorthWestSouthEastFailsForMissing2() {
        Cell a = new Cell();
        Cell b = new Cell();
        a.setSouthEast(b);

        CellUtils.assertNeightboursNorthWestSouthEast(a, b);
    }

    @Test
    public void testAssertNeighboursSouthWestNorthEast() {
        Cell a = new Cell();
        Cell b = new Cell();
        a.setNorthEast(b);
        b.setSouthWest(a);

        CellUtils.assertNeightboursSouthWestNorthEast(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testAssertNeighboursSouthWestNorthEastFailsForMissing1() {
        Cell a = new Cell();
        Cell b = new Cell();
        b.setSouthWest(a);

        CellUtils.assertNeightboursSouthWestNorthEast(a, b);
    }

    @Test(expected = AssertionError.class)
    public void testAssertNeighboursSouthWestNorthEastFailsForMissing2() {
        Cell a = new Cell();
        Cell b = new Cell();
        a.setNorthEast(b);

        CellUtils.assertNeightboursSouthWestNorthEast(a, b);
    }

    // assertHasAllNeighboursInDirections

    @Test
    public void testAssertAllNeighbours() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.EAST);
        base.setNeighbour(new Cell(), Direction.SOUTH_WEST);

        CellUtils.assertHasAllNeighboursInDirections(base, EnumSet.of(Direction.EAST, Direction.SOUTH_WEST));
    }

    @Test
    public void testAssertAllNeighboursNotFailForMoreExistingNeighboursThanExpected() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.EAST);
        base.setNeighbour(new Cell(), Direction.SOUTH_WEST);
        base.setNeighbour(new Cell(), Direction.WEST);

        CellUtils.assertHasAllNeighboursInDirections(base, EnumSet.of(Direction.EAST, Direction.SOUTH_WEST));
    }

    @Test(expected = AssertionError.class)
    public void testAssertAllNeighboursFailsForMissing() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.EAST);
        base.setNeighbour(new Cell(), Direction.SOUTH_WEST);

        CellUtils.assertHasAllNeighboursInDirections(base, EnumSet.of(Direction.EAST, Direction.SOUTH_WEST, Direction.WEST));
    }

    // assertHasNoNeighboursInDirections

    @Test
    public void testAssertHasNoNeighboursInDirections() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.WEST);
        base.setNeighbour(new Cell(), Direction.SOUTH_WEST);
        base.setNeighbour(new Cell(), Direction.NORTH_WEST);

        CellUtils.assertHasNoNeighboursInDirections(base, EnumSet.of(Direction.EAST, Direction.SOUTH_EAST, Direction.NORTH_EAST));
    }

    @Test
    public void testAssertHasNoNeighboursInDirectionsWithMoreExistingThanExpected() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.WEST);
        base.setNeighbour(new Cell(), Direction.SOUTH_WEST);
        base.setNeighbour(new Cell(), Direction.NORTH_WEST);

        CellUtils.assertHasNoNeighboursInDirections(base, EnumSet.of(Direction.EAST, Direction.SOUTH_EAST));
    }

    @Test(expected = AssertionError.class)
    public void testAssertHasNoNeighboursInDirectionsFailsForExisting() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.WEST);
        base.setNeighbour(new Cell(), Direction.SOUTH_WEST);
        base.setNeighbour(new Cell(), Direction.NORTH_WEST);

        CellUtils.assertHasNoNeighboursInDirections(base, EnumSet.of(Direction.EAST, Direction.NORTH_WEST));
    }

    @Test
    public void assertHasJustNeighboursInDirection() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.WEST);
        base.setNeighbour(new Cell(), Direction.SOUTH_WEST);

        CellUtils.assertHasJustNeighboursInDirection(base, EnumSet.of(Direction.WEST, Direction.SOUTH_WEST));
    }

    @Test(expected = AssertionError.class)
    public void assertHasJustNeighboursInDirectionFailForMissingNeighbour() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.WEST);

        CellUtils.assertHasJustNeighboursInDirection(base, EnumSet.of(Direction.WEST, Direction.SOUTH_WEST));
    }

    @Test(expected = AssertionError.class)
    public void assertHasJustNeighboursInDirectionFailsForExistingNeighbour() {
        Cell base = new Cell();
        base.setNeighbour(new Cell(), Direction.WEST);
        base.setNeighbour(new Cell(), Direction.SOUTH_WEST);

        CellUtils.assertHasJustNeighboursInDirection(base, EnumSet.of(Direction.WEST));
    }
}
