package com.lhauspie.adventofcode.day24.model;

public enum Direction {
    STAY(Position.of(0, 0)),
    NORTH(Position.of(0, -1)),
    SOUTH(Position.of(0, +1)),
    WEST(Position.of(-1, 0)),
    EAST(Position.of(+1, 0));

    private final Position move;

    Direction(Position move) {
        this.move = move;
    }

    public Position getMove() {
        return move;
    }
}
