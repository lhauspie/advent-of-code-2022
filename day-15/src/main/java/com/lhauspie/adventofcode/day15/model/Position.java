package com.lhauspie.adventofcode.day15.model;

import java.awt.geom.Point2D;
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

    public Position up() {
        return Position.of(x, y - 1);
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

    public int getManhattanDistanceTo(Position position) {
        return Math.abs(this.getX() - position.getX()) + Math.abs(this.getY() - position.getY());
    }

    public int getManhattanDistanceTo(int x, int y) {
        return Math.abs(this.getX() - x) + Math.abs(this.getY() - y);
    }
}
