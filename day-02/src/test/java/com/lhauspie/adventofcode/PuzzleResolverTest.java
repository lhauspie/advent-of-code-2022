package com.lhauspie.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleResolverTest {

    @Test
    public void puzzleResolverCanResolveTheFirstPuzzleWithInputExample() {
        var input = """
                A Y
                B X
                C Z
                """;
        var scanner = new Scanner(input);
        assertEquals(15, PuzzleResolver.resolveFirstPuzzle(scanner).getValue());
    }

    @Test
    public void puzzleResolverCanResolveTheSecondPuzzleWithInputExample() {
        var input = """
                A Y
                B X
                C Z
                """;
        var scanner = new Scanner(input);
        assertEquals(12, PuzzleResolver.resolveSecondPuzzle(scanner).getValue());
    }
}
