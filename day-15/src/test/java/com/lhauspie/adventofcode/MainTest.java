package com.lhauspie.adventofcode;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        long millis = System.currentTimeMillis();
        assertEquals(5838453, Main.resolveFirstPuzzle());
        System.out.println("took " + (System.currentTimeMillis() - millis)+ " ms");
    }

    @Test
    public void resolveSecondPuzzle() {
        assertEquals(0, Main.resolveSecondPuzzle());
    }
}