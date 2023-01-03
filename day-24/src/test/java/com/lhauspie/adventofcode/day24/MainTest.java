package com.lhauspie.adventofcode.day24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        assertEquals(314, Main.resolveFirstPuzzle().toMinutes());
    }

    @Test
    public void resolveSecondPuzzle() {
        assertEquals(896, Main.resolveSecondPuzzle().toMinutes());
    }
}