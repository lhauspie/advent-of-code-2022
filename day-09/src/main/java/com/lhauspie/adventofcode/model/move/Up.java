package com.lhauspie.adventofcode.model.move;

import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Rope;

public class Up implements Move {
    @Override
    public Position moveHeadAndGetTailPosition(Rope rope) {
        rope.getHead().moveUp();
        return rope.getTail().getPosition();
    }
}
