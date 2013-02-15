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
        createNet();
    }

    protected void createNet() {
        head = new Cell();

        {
            Cell currentCell = head;
            for (int i = 1; i < centerLineLength; i++) {
                Cell newCellOnEast = new Cell();
                connectWestToEast(currentCell, newCellOnEast);
                currentCell = newCellOnEast;
            }
        }

        {
            Cell currentCell = head;
            Cell nextCell;
            for (int i = 0; i < centerLineLength - 1; i++) {
                nextCell = currentCell.getEast();
                Cell newCellOnNorth = new Cell();

                connectSouthWestToNorthEast(currentCell, newCellOnNorth);

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
    }

    private void connectSouthWestToNorthEast(Cell southWest, Cell northEast) {
        southWest.setNorthEast(northEast);
        northEast.setSouthWest(southWest);
    }

    private void connectNorthWestToSouthEast(Cell northWest, Cell southEast) {
        northWest.setSouthEast(southEast);
        southEast.setNorthWest(northWest);
    }

    private void connectWestToEast(Cell west, Cell east) {
        west.setEast(east);
        east.setWest(west);
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
