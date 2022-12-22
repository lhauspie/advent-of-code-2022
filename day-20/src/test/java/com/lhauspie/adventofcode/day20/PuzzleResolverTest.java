package com.lhauspie.adventofcode.day20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    String input = """
            1
            2
            -3
            3
            -2
            0
            4
            """;

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        Assertions.assertEquals(3, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        Assertions.assertEquals(1623178306L, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }
}