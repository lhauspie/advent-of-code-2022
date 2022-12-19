package com.lhauspie.adventofcode.day17.model.rock;

import com.lhauspie.adventofcode.day17.model.MutablePosition;

public class CrossRock extends Rock {
    public CrossRock(MutablePosition position) {
        super(position, 3, 3);
        // .#.
        // ###
        // .#.
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 1, getBottomLeftCornerPosition().getY()));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX(), getBottomLeftCornerPosition().getY() + 1));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 1, getBottomLeftCornerPosition().getY() + 1));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 2, getBottomLeftCornerPosition().getY() + 1));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 1, getBottomLeftCornerPosition().getY() + 2));
    }
}
