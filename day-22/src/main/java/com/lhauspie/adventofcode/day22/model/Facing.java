package com.lhauspie.adventofcode.day22.model;

public enum Facing {
    EAST(0), SOUTH(1), WEST(2), NORTH(3);

    private final int value;

    Facing(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


    public Facing getCounterclockwiseNextFacing() {
        return switch (this) {
            case EAST -> NORTH;
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
        };
    }

    public Facing getClockwiseNextFacing() {
        return switch (this) {
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case NORTH -> EAST;
        };
    }

    public Tile getNextTile(Tile currentTile) {
        return switch (this) {
            case EAST -> currentTile.getEast();
            case SOUTH -> currentTile.getSouth();
            case WEST -> currentTile.getWest();
            case NORTH -> currentTile.getNorth();
        };
    }
}
