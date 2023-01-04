package com.lhauspie.adventofcode.day25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        assertEquals("20==1==12=0111=2--20", Main.resolveFirstPuzzle());
    }
}