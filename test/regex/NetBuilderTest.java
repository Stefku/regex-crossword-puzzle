package regex;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static regex.CellUtils.*;

public class NetBuilderTest {
    @Test
    public void createHorizontalLine() {
        // given
        NetBuilder builder = new NetBuilder();

        // when
        Cell head = builder.createHorizontalLine(3);

        // then

        // check existence of cells
        assertNotNull(head);
        assertTrue(head.hasEast());
        Cell east1 = head.getEast();
        assertTrue(east1.hasEast());
        Cell east2 = east1.getEast();
        assertFalse(east2.hasEast());

        // check bidirectional connection
        assertNeightboursWestEast(head, east1);
        assertNeightboursWestEast(east1, east2);
    }

    @Test
    public void createLineAboveCenterLine() {
        // given
        NetBuilder builder = new NetBuilder();
        Cell c1 = builder.createHorizontalLine(3);
        Cell c2 = c1.getEast();
        Cell c3 = c2.getEast();

        // when
        builder.createLineAbove(c1);

        // then
        //    a    b
        // c1   c2   c3

        // existence of cells a and b
        assertTrue(c1.hasNorthEast());
        Cell a = c1.getNorthEast();
        assertTrue(a.hasEast());
        Cell b = a.getEast();

        // bidirectional connection of cells
        assertNeightboursSouthWestNorthEast(c1, a);
        assertNeightboursSouthWestNorthEast(c2, b);

        assertNeightboursNorthWestSouthEast(a, c2);
        assertNeightboursNorthWestSouthEast(b, c3);

        assertNeightboursWestEast(a, b);
    }

    @Test
    public void createSecondLineAboveCenterLine() {
        // given
        NetBuilder builder = new NetBuilder();
        Cell c1 = builder.createHorizontalLine(3);
        Cell c2 = c1.getEast();
        Cell c3 = c2.getEast();

        builder.createLineAbove(c1);
        assertTrue(c1.hasNorthEast());
        Cell a = c1.getNorthEast();
        assertTrue(a.hasEast());
        Cell b = a.getEast();

        // when
        builder.createLineAbove(a);

        // then
        //       x
        //    a    b
        // c1   c2   c3
        assertTrue(a.hasNorthEast());
        Cell x = a.getNorthEast();

        assertNeightboursSouthWestNorthEast(a, x);
        assertNeightboursNorthWestSouthEast(x, b);
    }
}
