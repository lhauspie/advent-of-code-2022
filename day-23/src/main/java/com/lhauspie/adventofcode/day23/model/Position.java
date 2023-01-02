package com.lhauspie.adventofcode.day23.model;

import java.util.Objects;

public record Position(long x, long y) {

    public static Position of(long x, long y) {
        return new Position(x, y);
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
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public long getY() {
        return y;
    }

    public long getX() {
        return x;
    }
}
