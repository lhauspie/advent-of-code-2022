package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Rope;
import com.lhauspie.adventofcode.model.move.*;

import java.util.HashSet;
import java.util.Set;

public class Motion {
    private Move move;
    private int quantity;

    public Motion(Move move, int quantity) {
        this.move = move;
        this.quantity = quantity;
    }

    public Set<Position> executeAndGetTailPositions(Rope rope) {
        Set<Position> tailPositions = new HashSet<>();
        for (int i = 0; i < quantity; i++) {
            tailPositions.add(move.moveHeadAndGetTailPosition(rope));
        }
        return tailPositions;
    }
}
