package com.lhauspie.adventofcode.day17.model.rock;

import com.lhauspie.adventofcode.day17.model.MutablePosition;

import java.util.HashSet;
import java.util.Set;

public abstract class Rock {
    private MutablePosition bottomLeftCornerPosition;
    private Set<MutablePosition> rocksPositions = new HashSet<>();

    private final int width;

    protected Rock(MutablePosition bottomLeftCornerPosition, int height, int width) {
        this.bottomLeftCornerPosition = bottomLeftCornerPosition;
        this.width = width;
    }

    public MutablePosition getBottomLeftCornerPosition() {
        return bottomLeftCornerPosition;
    }

    protected void addRockPosition(MutablePosition position) {
        rocksPositions.add(position);
    }

    public Set<MutablePosition> getRocksPositions() {
        return rocksPositions;
    }

    public void moveLeft() {
        bottomLeftCornerPosition.left();
        rocksPositions.forEach(p -> p.left());
    }

    public void moveRight() {
        bottomLeftCornerPosition.right();
        rocksPositions.forEach(p -> p.right());
    }

    public void moveDown() {
        bottomLeftCornerPosition.down();
        rocksPositions.forEach(p -> p.down());
    }

    public long getWidth() {
        return width;
    }
}
