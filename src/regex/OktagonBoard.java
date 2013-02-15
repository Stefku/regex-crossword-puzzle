package regex;

import java.util.List;

/**
 * This class ... TODO
 */
public class OktagonBoard {
    private final int sideWidth;
    private final int centerLineLength;

    private Cell head;

    public OktagonBoard(int sideWidth) {
        this.sideWidth = sideWidth;
        centerLineLength = sideWidth + sideWidth - 1;
    }

    public Cell createNet() {
        Cell head = new Cell();

        {
            Cell currentCell = head;
            for (int i = 1; i < centerLineLength; i++) {
                Cell newCellOnEast = new Cell();
                currentCell.setEast(newCellOnEast);
                currentCell = newCellOnEast;
            }
        }

        {
            Cell currentCell = head;
            Cell nextCell;
            for (int i = 0; i < centerLineLength - 1; i++) {
                nextCell = currentCell.getEast();
                Cell newCellOnNorth = new Cell();
                currentCell.setNorthEast(newCellOnNorth);
                nextCell.setNorthWest(newCellOnNorth);
            }
        }

        {
            Cell currentCell = head;
            Cell nextCell;
            for (int i = 0; i < centerLineLength - 1; i++) {
                nextCell = currentCell.getEast();
                Cell newCellOnSouth = new Cell();
                currentCell.setSouthEast(newCellOnSouth);
                nextCell.setSouthWest(newCellOnSouth);
            }
        }

        return head;
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
}
