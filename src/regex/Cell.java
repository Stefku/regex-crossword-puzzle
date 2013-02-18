package regex;

class Cell {
    private Cell west;
    private Cell east;
    private Cell northWest;
    private Cell northEast;
    private Cell southWest;
    private Cell southEast;

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

    public String toDetailString() {
        return "Cell{" +
                "east=" + east +
                ", west=" + west +
                ", northWest=" + northWest +
                ", northEast=" + northEast +
                ", southWest=" + southWest +
                ", southEast=" + southEast +
                '}';
    }

    @Override
    public String toString() {
        return "Cell{" +
                "neighbours=" + getNeighbourCount()+
                '}';
    }

    public int getNeighbourCount() {
        int res = 0;
        if (east != null) res += 1;
        if (west != null) res += 1;
        if (northWest != null) res += 1;
        if (northEast != null) res += 1;
        if (southWest != null) res += 1;
        if (southEast != null) res += 1;
        return res;
    }

    public boolean hasEast() {
        return east != null;
    }

    public boolean hasNorthEast() {
        return northEast != null;
    }
}
