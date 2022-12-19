package com.lhauspie.adventofcode.day17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        String input = ">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>";
        Assertions.assertEquals(3068, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        String input = ">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>";
        Assertions.assertEquals(1514285714288L, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }
}