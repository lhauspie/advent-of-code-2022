package com.lhauspie.adventofcode.model;

import java.util.Stack;

public class CrateMover9001 implements CrateMover {

    private Ship ship;
    private Stack<MarkedCrate> bufferZone = new Stack<>();

    public CrateMover9001(Ship ship) {
        this.ship = ship;
    }

    public void execute(Move move) {
        for (int crateNumber = 0; crateNumber < move.getQuantity().getValue(); crateNumber++) {
            bufferZone.push(ship.take(move.getSource()));
        }
        for (int crateNumber = 0; crateNumber < move.getQuantity().getValue(); crateNumber++) {
            ship.store(bufferZone.pop(), move.getTarget());
        }
    }
}
