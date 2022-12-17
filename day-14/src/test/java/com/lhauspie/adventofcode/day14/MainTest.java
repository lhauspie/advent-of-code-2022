package com.lhauspie.adventofcode.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        assertEquals(828, Main.resolveFirstPuzzle());
    }

    @Test
    public void resolveSecondPuzzle() {
        assertEquals(25500, Main.resolveSecondPuzzle());
    }
}