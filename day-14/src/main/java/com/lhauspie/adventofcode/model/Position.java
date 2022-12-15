package com.lhauspie.adventofcode.model;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    public Position down() {
        return Position.of(x, y + 1);
    }

    public Position right() {
        return Position.of(x + 1, y);
    }

    public Position left() {
        return Position.of(x - 1, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{x=" + x + ", y=" + y + "}";
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
