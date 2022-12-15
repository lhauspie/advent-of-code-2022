package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaveTest {

    @Test
    public void newCaveHaveSizeOfSource() {
        Cave cave = new Cave(new SandSource(Position.of(500,0)));

        assertEquals(Position.of(500, 0), cave.getMinPosition());
        assertEquals(Position.of(500, 0), cave.getMaxPosition());
    }

    @Test
    public void caveWithOneRockHaveSizeIncludingSandSourceAndAddedRock() {
        Cave cave = new Cave(new SandSource(Position.of(500,0)));
        cave.addRock(new Position(400, 0));

        assertEquals(Position.of(400, 0), cave.getMinPosition());
        assertEquals(Position.of(500, 0), cave.getMaxPosition());
    }

    @Test
    public void caveWithOneRockAt500X10YHaveSizeIncludingSandSourceAndAddedRock() {
        Cave cave = new Cave(new SandSource(Position.of(500,0)));
        cave.addRock(new Position(500, 10));

        assertEquals(Position.of(500, 0), cave.getMinPosition());
        assertEquals(Position.of(500, 10), cave.getMaxPosition());
    }
}
