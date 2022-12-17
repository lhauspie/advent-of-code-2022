package com.lhauspie.adventofcode.day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    @Test
    public void tryToResolveFirstPuzzleOnSimpleCase() {
        //   4  5
        //   9  0
        //   7  0
        // 0 ...+..
        // 1 ...~..
        // 2 ..~o..
        // 3 .~#o#.
        // 4 .~###.
        String input = """
                499,3 -> 499,4 -> 501,4 -> 501,3
                """;
        Assertions.assertEquals(2, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveFirstPuzzleOnSimpleCase2() {
        //   4  5
        //   9  0
        //   7  0
        // 0 ...+..
        // 1 ...~..
        // 2 ..oo~.
        // 3 .#oo#~
        // 4 .####~
        String input = """
                498,3 -> 498,4 -> 501,4 -> 501,3
                """;
        Assertions.assertEquals(4, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        String input = """
                498,4 -> 498,6 -> 496,6
                503,4 -> 502,4 -> 502,9 -> 494,9
                """;
        Assertions.assertEquals(24, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        String input = """
                498,4 -> 498,6 -> 496,6
                503,4 -> 502,4 -> 502,9 -> 494,9
                """;
        Assertions.assertEquals(93, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }
}