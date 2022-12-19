package com.lhauspie.adventofcode.day17.model.rock;

import com.lhauspie.adventofcode.day17.model.MutablePosition;

public class SquareRock extends Rock {

    public SquareRock(MutablePosition position) {
        super(position, 2, 2);
        // ##
        // ##
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX(), getBottomLeftCornerPosition().getY()));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX(), getBottomLeftCornerPosition().getY() + 1));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 1, getBottomLeftCornerPosition().getY() + 1));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 1, getBottomLeftCornerPosition().getY()));
    }
}
