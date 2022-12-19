package com.lhauspie.adventofcode.day17.model.move;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveFactoryTest {

    @Test
    public void testOne() {
        MoveFactory moveFactory = new MoveFactory("><");

        assertEquals(Move.RIGHT, moveFactory.nextMove());
        assertEquals(Move.LEFT, moveFactory.nextMove());
        assertEquals(Move.RIGHT, moveFactory.nextMove());
        assertEquals(Move.LEFT, moveFactory.nextMove());
    }

    @Test
    public void testTwo() {
        MoveFactory moveFactory = new MoveFactory(">><");

        assertEquals(Move.RIGHT, moveFactory.nextMove());
        assertEquals(Move.RIGHT, moveFactory.nextMove());
        assertEquals(Move.LEFT, moveFactory.nextMove());
        assertEquals(Move.RIGHT, moveFactory.nextMove());
        assertEquals(Move.RIGHT, moveFactory.nextMove());
        assertEquals(Move.LEFT, moveFactory.nextMove());
    }
}
