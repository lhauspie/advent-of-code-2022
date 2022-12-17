package com.lhauspie.adventofcode.day14.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SandUnitTest {

    @Test
    public void newSandUnitIsNotResting() {
        SandUnit sandUnit = new SandUnit(Position.of(0, 0));
        assertFalse(sandUnit.isResting());
    }

    @Test
    public void newSandUnitIsRestingIfSandUnitRests() {
        SandUnit sandUnit = new SandUnit(Position.of(0, 0));
        sandUnit.rest();
        assertTrue(sandUnit.isResting());
    }

}
