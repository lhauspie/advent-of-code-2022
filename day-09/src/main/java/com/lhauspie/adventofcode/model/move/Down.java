package com.lhauspie.adventofcode.model.move;

import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Rope;

public class Down implements Move {
    @Override
    public Position moveHeadAndGetTailPosition(Rope rope) {
        rope.getHead().moveDown();
        return rope.getTail().getPosition();
    }
}
