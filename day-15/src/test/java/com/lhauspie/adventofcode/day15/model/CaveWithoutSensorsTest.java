package com.lhauspie.adventofcode.day15.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaveWithoutSensorsTest {

    @Test
    public void emptyCaveShouldIdentifyNoPositionsWhereABeaconCannotBePresent() {
        Cave cave = new Cave(Position.of(0, 0), Position.of(20, 20));
        assertEquals(0, cave.getNumberOfPositionsWhereABeaconCannotBePresent(10));
    }
}
