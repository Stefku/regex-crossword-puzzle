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

        createHorizontalLine(head, centerLineLength);

        createLineAbove(head);

        createLineBelow();
    }

    private void createLineBelow() {
        // south from center
        Cell currentCell = head;
        Cell nextCell;
        // create south
        for (int i = 0; i < centerLineLength - 1; i++) {
            nextCell = currentCell.getEast();
            Cell newCellOnSouth = new Cell();
            connectNorthWestToSouthEast(currentCell, newCellOnSouth);
            connectSouthWestToNorthEast(newCellOnSouth, nextCell);
            currentCell = nextCell;
        }
        // connect south
        currentCell = head;
        nextCell = null;
        for (int i = 0; i < centerLineLength - 2; i++) {
            nextCell = currentCell.getEast();
            Cell firstSouth = currentCell.getSouthEast();
            Cell nextSouth = nextCell.getSouthEast();
            connectWestToEast(firstSouth, nextSouth);
            currentCell = nextCell;
        }
    }

    private void createLineAbove(Cell startCell) {
        // north from center
        Cell currentCell = startCell;
        Cell nextCell;
        // create north
        for (int i = 0; i < centerLineLength - 1; i++) {
            nextCell = currentCell.getEast();
            Cell newCellOnNorth = new Cell();
            connectSouthWestToNorthEast(currentCell, newCellOnNorth);
            connectNorthWestToSouthEast(newCellOnNorth, nextCell);
            currentCell = nextCell;
        }
        // connect north
        currentCell = head;
        nextCell = null;
        for (int i = 0; i < centerLineLength - 2; i++) {
            nextCell = currentCell.getEast();
            Cell firstNorth = currentCell.getNorthEast();
            Cell nextNorth = nextCell.getNorthEast();
            connectWestToEast(firstNorth, nextNorth);
            currentCell = nextCell;
        }
    }

    private void createHorizontalLine(Cell startCell, int lineLength) {
        // center line
        Cell currentCell = startCell;
        for (int i = 1; i < lineLength; i++) {
            Cell newCellOnEast = new Cell();
            connectWestToEast(currentCell, newCellOnEast);
            currentCell = newCellOnEast;
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
