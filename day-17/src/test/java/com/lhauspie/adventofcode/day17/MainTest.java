package com.lhauspie.adventofcode.day17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        assertEquals(3166, Main.resolveFirstPuzzle());
    }

    @Test
    public void resolveSecondPuzzle() {
        assertEquals(1577207977186L, Main.resolveSecondPuzzle());
    }
}