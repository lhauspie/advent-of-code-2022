package com.lhauspie.adventofcode.day13;

import com.lhauspie.adventofcode.day13.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        assertEquals(5390, Main.resolveFirstPuzzle());
    }

    @Test
    public void resolveSecondPuzzle() {
        assertEquals(19261, Main.resolveSecondPuzzle());
    }
}