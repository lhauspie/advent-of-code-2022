package com.lhauspie.adventofcode.dayxx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        String input = """
                """;
        Assertions.assertEquals(0, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        String input = """
                """;
        Assertions.assertEquals(0, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }
}