package com.lhauspie.adventofcode.day17.model.rock;

import com.lhauspie.adventofcode.day17.model.MutablePosition;

public class RockFactory {

    private int pieces = 0;

    public Rock createRock(long x, long y) {
        Rock rock = null;
        if (pieces % 5 == 0) {
            rock = new HorizontalLineRock(MutablePosition.of(x, y));
        } else if (pieces % 5 == 1) {
            rock = new CrossRock(MutablePosition.of(x, y));
        } else if (pieces % 5 == 2) {
            rock = new RightAngle(MutablePosition.of(x, y));
        } else if (pieces % 5 == 3) {
            rock = new VerticalLineRock(MutablePosition.of(x, y));
        } else if (pieces % 5 == 4) {
            rock = new SquareRock(MutablePosition.of(x, y));
        }
        pieces++;
        return rock;
    }
}
