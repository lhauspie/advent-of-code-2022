package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipTest {

    @Test
    public void checkCrateMovesCorrectly() {
        // GIVEN
        var ship = new Ship();

        ship.store(MarkedCrate.of("Z"), Position.of(1));
        ship.store(MarkedCrate.of("N"), Position.of(1));
        ship.store(MarkedCrate.of("M"), Position.of(1));
        ship.store(MarkedCrate.of("C"), Position.of(2));
        ship.store(MarkedCrate.of("D"), Position.of(2));
        ship.store(MarkedCrate.of("P"), Position.of(3));

        // THEN
        assertEquals("M", ship.take(Position.of(1)).getMark());
        assertEquals("N", ship.take(Position.of(1)).getMark());
        assertEquals("Z", ship.take(Position.of(1)).getMark());
    }

    @Test
    public void crateOnTopOfEachStack() {
        // GIVEN
        var ship = new Ship();

        ship.store(MarkedCrate.of("Z"), Position.of(1));
        ship.store(MarkedCrate.of("N"), Position.of(1));
        ship.store(MarkedCrate.of("M"), Position.of(2));
        ship.store(MarkedCrate.of("C"), Position.of(2));
        ship.store(MarkedCrate.of("D"), Position.of(2));
        ship.store(MarkedCrate.of("P"), Position.of(3));

        // THEN
        List<MarkedCrate> cratesOnTopOfEachStack = ship.getCratesOnTopOfEachStack();
        assertEquals("N", cratesOnTopOfEachStack.get(0).getMark());
        assertEquals("D", cratesOnTopOfEachStack.get(1).getMark());
        assertEquals("P", cratesOnTopOfEachStack.get(2).getMark());
    }
}
