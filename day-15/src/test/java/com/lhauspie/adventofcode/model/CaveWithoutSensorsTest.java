package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaveWithoutSensorsTest {

    @Test
    public void emptyCaveShouldIdentifyNoPositionsWhereABeaconCannotBePresent() {
        Cave cave = new Cave();
        assertEquals(0, cave.getNumberOfPositionsWhereABeaconCannotBePresent(10));
    }
}
