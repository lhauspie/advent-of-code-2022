package com.lhauspie.adventofcode.model.move;

import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Rope;

public interface Move {
    Position moveHeadAndGetTailPosition(Rope rope);
}
