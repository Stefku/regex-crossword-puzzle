package regex;

import java.util.List;

/**
 * This class ... TODO
 */
public class OktagonBoard {
    private final int sideWidth;
    private final NetBuilder netBuilder = new NetBuilder();

    private Cell head;

    public OktagonBoard(int sideWidth) {
        this.sideWidth = sideWidth;
        head = netBuilder.createNet(sideWidth);
    }

    public int getCellCount() {
        return 2 * (sideWidth * sideWidth + func(sideWidth - 1)) - (sideWidth + sideWidth - 1);
    }

    public static int func(int i) {
        int res = 0;
        for (int j = 1; j <= i; j++) {
            res += j;
        }
        return res;
    }

    public List<List<Cell>> horizontalContent() {
        return null;
    }

    public Cell getHead() {
        return head;
    }
}
