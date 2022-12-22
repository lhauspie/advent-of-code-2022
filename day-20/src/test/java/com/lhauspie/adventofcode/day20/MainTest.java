package com.lhauspie.adventofcode.day20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        assertEquals(4426, Main.resolveFirstPuzzle());
    }

    @Test
    public void resolveSecondPuzzle() {
        assertEquals(8119137886612L, Main.resolveSecondPuzzle());
    }
}