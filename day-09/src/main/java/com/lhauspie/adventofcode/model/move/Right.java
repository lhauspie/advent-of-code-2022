package com.lhauspie.adventofcode.model.move;

import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Rope;

public class Right implements Move {
    @Override
    public Position moveHeadAndGetTailPosition(Rope rope) {
        rope.getHead().moveRight();
        return rope.getTail().getPosition();
    }
}
