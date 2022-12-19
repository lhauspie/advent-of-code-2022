package com.lhauspie.adventofcode.day17.model.rock;

import com.lhauspie.adventofcode.day17.model.MutablePosition;

public class HorizontalLineRock extends Rock {

    public HorizontalLineRock(MutablePosition position) {
        super(position, 1, 4);
        // ####
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX(), getBottomLeftCornerPosition().getY()));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 1, getBottomLeftCornerPosition().getY()));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 2, getBottomLeftCornerPosition().getY()));
        addRockPosition(MutablePosition.of(getBottomLeftCornerPosition().getX() + 3, getBottomLeftCornerPosition().getY()));
    }
}
