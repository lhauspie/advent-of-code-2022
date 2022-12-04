package com.lhauspie.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void resolveFirstPuzzle() {
        var input = """
                10-20,30-40
                30-40,10-20
                10-20,10-20
                10-20,20-30
                20-30,10-20
                10-30,20-40
                20-40,10-30
                10-50,20-30
                20-30,10-50
                """;
        var scanner = new Scanner(input);
        // 10-20,10-20 full contain
        // 10-50,20-30 full contain
        // 20-30,10-50 full contain
        assertEquals(3, Main.resolveFirstPuzzle(scanner));
    }

    @Test
    public void resolveSecondPuzzle() {
        var input = """
                10-20,30-40
                30-40,10-20
                10-20,10-20
                10-20,20-30
                20-30,10-20
                10-30,20-40
                20-40,10-30
                10-50,20-30
                20-30,10-50
                """;
        var scanner = new Scanner(input);
        // 10-20,10-20 full contain
        // 10-50,20-30 full contain
        // 20-30,10-50 full contain
        assertEquals(7, Main.resolveSecondPuzzle(scanner));
    }
}
