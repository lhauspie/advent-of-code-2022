package com.lhauspie.adventofcode.day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    String input = """
            """;

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        Assertions.assertEquals(0, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        Assertions.assertEquals(0, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }
}