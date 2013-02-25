package regex.extern;

import org.junit.Test;
import regex.Board;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetTest {
    @Test
    public void test() {
        EnumSet<Board.Segment> enumSet = EnumSet.allOf(Board.Segment.class);
        Iterator<Board.Segment> iterator = enumSet.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
