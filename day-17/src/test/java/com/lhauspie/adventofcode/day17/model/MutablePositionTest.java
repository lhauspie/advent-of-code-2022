package com.lhauspie.adventofcode.day17.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MutablePositionTest {

    @Test
    public void testOne() {
        Set<MutablePosition> mutablePositions = new HashSet<>();
        MutablePosition firstPosition = MutablePosition.of(0, 0);
        MutablePosition secondPosition = MutablePosition.of(0, 0);
        mutablePositions.add(firstPosition);
        mutablePositions.add(secondPosition);
        assertEquals(1, mutablePositions.size());
    }

    @Test
    public void testTwo() {
        // This shows a problem about mutability and Set behaviour
        Set<MutablePosition> mutablePositions = new HashSet<>();
        MutablePosition firstPosition = MutablePosition.of(0, 1);
        MutablePosition secondPosition = MutablePosition.of(0, 0);
        mutablePositions.add(firstPosition);
        mutablePositions.add(secondPosition);
        assertEquals(2, mutablePositions.size());

        firstPosition.down();
        assertEquals(firstPosition, secondPosition);
        assertEquals(2, mutablePositions.size());

        mutablePositions.remove(firstPosition);
        assertEquals(1, mutablePositions.size()); // oO
    }
}
