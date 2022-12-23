package com.lhauspie.adventofcode.day22.model;

public class Tile {
    private final Position position;
    private final boolean empty;

    private Tile north;
    private Tile east;
    private Tile south;
    private Tile west;

    public Tile(Position position, boolean empty) {
        this.position = position;
        this.empty = empty;
//        this.north = this;
//        this.east = this;
//        this.south = this;
//        this.west = this;
    }

    public Position getPosition() {
        return position;
    }

    public Tile getNorth() {
        return north;
    }

    public void setNorth(Tile north) {
        this.north = north;
    }

    public Tile getEast() {
        return east;
    }

    public void setEast(Tile east) {
        this.east = east;
    }

    public Tile getSouth() {
        return south;
    }

    public void setSouth(Tile south) {
        this.south = south;
    }

    public Tile getWest() {
        return west;
    }

    public void setWest(Tile west) {
        this.west = west;
    }

    public boolean isEmpty() {
        return empty;
    }
}
