package com.lhauspie.adventofcode.day17.model.rock;

import com.lhauspie.adventofcode.day17.model.MutablePosition;

public class VerticalLineRock extends Rock {

    public VerticalLineRock(MutablePosition position) {
        super(position, 4, 1);
        // #
        // #
        // #
        // #
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX(), getBottomLeftCornerPosition().getY()));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX(), getBottomLeftCornerPosition().getY() + 1));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX(), getBottomLeftCornerPosition().getY() + 2));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX(), getBottomLeftCornerPosition().getY() + 3));
    }
}
