package regex;

/**
* This class ... TODO
*/
class Cell {
    private Cell north;
    private Cell northWest;
    private Cell northEast;
    private Cell south;
    private Cell southWest;
    private Cell southEast;
    private Cell west;
    private Cell east;

    public Cell getNorth() {
        return north;
    }

    public void setNorth(Cell north) {
        this.north = north;
    }

    public Cell getNorthWest() {
        return northWest;
    }

    public void setNorthWest(Cell northWest) {
        this.northWest = northWest;
    }

    public Cell getNorthEast() {
        return northEast;
    }

    public void setNorthEast(Cell northEast) {
        this.northEast = northEast;
    }

    public Cell getSouth() {
        return south;
    }

    public void setSouth(Cell south) {
        this.south = south;
    }

    public Cell getSouthWest() {
        return southWest;
    }

    public void setSouthWest(Cell southWest) {
        this.southWest = southWest;
    }

    public Cell getSouthEast() {
        return southEast;
    }

    public void setSouthEast(Cell southEast) {
        this.southEast = southEast;
    }

    public Cell getWest() {
        return west;
    }

    public void setWest(Cell west) {
        this.west = west;
    }

    public Cell getEast() {
        return east;
    }

    public void setEast(Cell east) {
        this.east = east;
    }
}
