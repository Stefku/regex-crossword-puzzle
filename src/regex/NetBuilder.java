package regex;

public class NetBuilder {
    public NetBuilder() {
    }

    protected Cell createNet(int sideWidth) {
        int centerLineLength = sideWidth + sideWidth - 1;
        Cell start = createHorizontalLine(centerLineLength);

        createLineAboveRecursive(start, sideWidth-1);
        createLineBelow(start);
        return start;
    }

    private void createLineAboveRecursive(Cell start, int level) {
        if (level < 1) {
            return;
        }
        createLineAbove(start);
        createLineAboveRecursive(start.getNorthEast(), level - 1);
    }

    void createLineAbove(final Cell startCell) {
        // north from center
        Cell currentCell = startCell;
        Cell nextCell;
        Cell lastCreatedAbove = null;
        // create north
        while (currentCell.hasEast()) {
            nextCell = currentCell.getEast();
            Cell newCellOnNorth = new Cell();
            if (lastCreatedAbove != null) {
                connectWestToEast(lastCreatedAbove, newCellOnNorth);
            } else {
                lastCreatedAbove = newCellOnNorth;
            }
            connectSouthWestToNorthEast(currentCell, newCellOnNorth);
            connectNorthWestToSouthEast(newCellOnNorth, nextCell);
            currentCell = nextCell;
        }
    }

    void createLineBelow(final Cell startCell) {
        // south from center
        Cell currentCell = startCell;
        Cell nextCell;
        Cell lastCreatedBelow = null;
        // create south
        while (currentCell.hasEast()) {
            nextCell = currentCell.getEast();
            Cell newCellOnSouth = new Cell();
            if (lastCreatedBelow != null) {
                connectWestToEast(lastCreatedBelow, newCellOnSouth);
            } else {
                lastCreatedBelow = newCellOnSouth;
            }
            connectNorthWestToSouthEast(currentCell, newCellOnSouth);
            connectSouthWestToNorthEast(newCellOnSouth, nextCell);
            currentCell = nextCell;
        }
    }

    public Cell createHorizontalLine(int lineLength) {
        Cell head = new Cell();
        Cell currentCell = head;
        for (int i = 1; i < lineLength; i++) {
            Cell newCellOnEast = new Cell();
            connectWestToEast(currentCell, newCellOnEast);
            currentCell = newCellOnEast;
        }
        return head;
    }

    void connectSouthWestToNorthEast(Cell southWest, Cell northEast) {
        southWest.setNorthEast(northEast);
        northEast.setSouthWest(southWest);
    }

    void connectNorthWestToSouthEast(Cell northWest, Cell southEast) {
        northWest.setSouthEast(southEast);
        southEast.setNorthWest(northWest);
    }

    void connectWestToEast(Cell west, Cell east) {
        west.setEast(east);
        east.setWest(west);
    }
}