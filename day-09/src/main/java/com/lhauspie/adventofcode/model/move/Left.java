package com.lhauspie.adventofcode.model.move;

import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Rope;

public class Left implements Move {
    @Override
    public Position moveHeadAndGetTailPosition(Rope rope) {
        rope.getHead().moveLeft();
        return rope.getTail().getPosition();
    }
}

