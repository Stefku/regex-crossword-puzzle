package regex;

import java.util.HashMap;
import java.util.Map;

import static regex.Direction.*;

class Cell {

    private Map<Direction, Cell> neighbours = new HashMap<Direction, Cell>(6);

    public Cell getNorthWest() {
        return neighbours.get(NORTH_WEST);
    }

    public void setNorthWest(Cell northWest) {
        neighbours.put(NORTH_WEST, northWest);
    }

    public Cell getNorthEast() {
        return neighbours.get(NORTH_EAST);
    }

    public void setNorthEast(Cell northEast) {
        neighbours.put(NORTH_EAST, northEast);
    }

    public Cell getSouthWest() {
        return neighbours.get(SOUTH_WEST);
    }

    public void setSouthWest(Cell southWest) {
        neighbours.put(SOUTH_WEST, southWest);
    }

    public Cell getSouthEast() {
        return neighbours.get(SOUTH_EAST);
    }

    public void setSouthEast(Cell southEast) {
        neighbours.put(SOUTH_EAST, southEast);
    }

    public Cell getWest() {
        return neighbours.get(WEST);
    }

    public void setWest(Cell west) {
        neighbours.put(WEST, west);
    }

    public Cell getEast() {
        return neighbours.get(EAST);
    }

    public void setEast(Cell east) {
        neighbours.put(EAST, east);
    }

    public void setNeighbour(Cell neighbour, Direction direction) {
        neighbours.put(direction, neighbour);
    }

    public Cell getNeighbour(Direction direction) {
        return neighbours.get(direction);
    }

    public boolean hasNeighbour(Direction direction) {
        return getNeighbour(direction) != null;
    }

    public String toDetailString() {
        return "Cell{" +
                "east=" + getEast() +
                ", west=" + getWest() +
                ", northWest=" + getNorthWest() +
                ", northEast=" + getNorthEast() +
                ", southWest=" + getSouthWest() +
                ", southEast=" + getSouthEast() +
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
        if (getEast() != null) res += 1;
        if (getWest() != null) res += 1;
        if (getNorthWest() != null) res += 1;
        if (getNorthEast() != null) res += 1;
        if (getSouthWest() != null) res += 1;
        if (getSouthEast() != null) res += 1;
        return res;
    }

    public boolean hasEast() {
        return getEast() != null;
    }

    public boolean hasNorthEast() {
        return getNorthEast() != null;
    }
}
