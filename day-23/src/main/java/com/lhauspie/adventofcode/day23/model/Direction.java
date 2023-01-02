package com.lhauspie.adventofcode.day23.model;

public enum Direction {
    EAST, SOUTH, WEST, NORTH;

    public Direction next() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> EAST;
            case EAST -> NORTH;
        };
    }
}
