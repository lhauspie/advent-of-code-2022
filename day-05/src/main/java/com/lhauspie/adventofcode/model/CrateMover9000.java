package com.lhauspie.adventofcode.model;

public class CrateMover9000 implements CrateMover {

    private Ship ship;

    public CrateMover9000(Ship ship) {
        this.ship = ship;
    }

    public void execute(Move move) {
        for (int i = 0; i < move.getQuantity().getValue(); i++) {
            ship.store(ship.take(move.getSource()), move.getTarget());
        }
    }
}
