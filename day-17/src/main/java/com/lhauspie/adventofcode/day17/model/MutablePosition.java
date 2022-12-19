package com.lhauspie.adventofcode.day17.model;

import java.util.Objects;

public class MutablePosition {
    private long x;
    private long y;

    public MutablePosition(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static MutablePosition of(long x, long y) {
        return new MutablePosition(x, y);
    }

    public void down() {
        y--;
    }

    public void right() {
        x++;
    }

    public void left() {
        x--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutablePosition position = (MutablePosition) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + "}";
    }

    public long getY() {
        return y;
    }

    public long getX() {
        return x;
    }
}
