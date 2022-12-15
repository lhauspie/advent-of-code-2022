package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SandSourceTest {

    @Test
    public void sandSourceProducesSandUnitAtSandSourcePosition() {
        SandSource sandSource = new SandSource(Position.of(0, 0));
        assertEquals(Position.of(0,0), sandSource.produceSandUnit().getPosition());
    }

    @Test
    public void anotherSandSourceProducesSandUnitAtSandSourcePosition() {
        SandSource sandSource = new SandSource(Position.of(50, 50));
        assertEquals(Position.of(50,50), sandSource.produceSandUnit().getPosition());
    }

    @Test
    public void sandSourceIsBlockedByProducedSandUnit() {
        SandSource sandSource = new SandSource(Position.of(0, 0));
        assertTrue(sandSource.isBlockedBy(sandSource.produceSandUnit()));
    }

    @Test
    public void sandSourceIsNotBlockedByProducedSandUnitThatFallsDone() {
        SandSource sandSource = new SandSource(Position.of(0, 0));
        SandUnit sandUnit = sandSource.produceSandUnit();
        sandUnit.setPosition(sandUnit.getPosition().down());
        assertFalse(sandSource.isBlockedBy(sandUnit));
    }
}
