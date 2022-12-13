package com.lhauspie.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        assertEquals(504, Main.resolveFirstPuzzle());
    }

    @Test
    public void resolveSecondPuzzle() {
        assertEquals(500, Main.resolveSecondPuzzle());
    }
}