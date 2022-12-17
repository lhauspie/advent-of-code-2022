package com.lhauspie.adventofcode.day15;

import com.lhauspie.adventofcode.day15.Main;
import org.junit.jupiter.api.Test;

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
        long millis = System.currentTimeMillis();
        assertEquals(12413999391794L, Main.resolveSecondPuzzle());
        System.out.println("took " + (System.currentTimeMillis() - millis)+ " ms");
    }
}