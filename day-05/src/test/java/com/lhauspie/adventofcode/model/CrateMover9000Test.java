package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrateMover9000Test {
    @Test
    public void checkCratesMovesCorrectly() {
        // GIVEN
        var ship = new Ship();
        var mover = new CrateMover9000(ship);

        ship.store(MarkedCrate.of("Z"), Position.of(1));
        ship.store(MarkedCrate.of("N"), Position.of(1));
        ship.store(MarkedCrate.of("M"), Position.of(2));
        ship.store(MarkedCrate.of("C"), Position.of(2));
        ship.store(MarkedCrate.of("D"), Position.of(2));
        ship.store(MarkedCrate.of("P"), Position.of(3));

        // WHEN
        mover.execute(new Move(Quantity.of(2), Position.of(1), Position.of(3)));

        // THEN
        assertEquals("Z", ship.take(Position.of(3)).getMark());
        assertEquals("N", ship.take(Position.of(3)).getMark());
        assertEquals("P", ship.take(Position.of(3)).getMark());
    }
}
