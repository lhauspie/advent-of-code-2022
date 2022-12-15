package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PuzzleResolverTest {

    @Test
    public void parseSimpleInputMovingOnY() {
        String input = "498,4 -> 498,6";
        Set<Position> rocks = PuzzleResolver.parseInput(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertFalse(rocks.contains(Position.of(498,7)));
    }

    @Test
    public void parseSimpleInputMovingOnReverseY() {
        String input = "498,6 -> 498,4";
        Set<Position> rocks = PuzzleResolver.parseInput(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertFalse(rocks.contains(Position.of(498,7)));
    }

    @Test
    public void parseSimpleInputMovingOnX() {
        String input = "498,4 -> 500,4";
        Set<Position> rocks = PuzzleResolver.parseInput(input);

        assertFalse(rocks.contains(Position.of(497,4)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(499,4)));
        assertTrue(rocks.contains(Position.of(500,4)));
        assertFalse(rocks.contains(Position.of(501,4)));
    }

    @Test
    public void parseSimpleInputMovingOnReverseX() {
        String input = "500,4 -> 498,4";
        Set<Position> rocks = PuzzleResolver.parseInput(input);

        assertFalse(rocks.contains(Position.of(497,4)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(499,4)));
        assertTrue(rocks.contains(Position.of(500,4)));
        assertFalse(rocks.contains(Position.of(501,4)));
    }

    @Test
    public void parseSimpleInputContainingTwoMovesMovingOnY() {
        String input = "498,4 -> 498,6 -> 498,10";
        Set<Position> rocks = PuzzleResolver.parseInput(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertTrue(rocks.contains(Position.of(498,7)));
        assertTrue(rocks.contains(Position.of(498,8)));
        assertTrue(rocks.contains(Position.of(498,9)));
        assertTrue(rocks.contains(Position.of(498,10)));
        assertFalse(rocks.contains(Position.of(498,11)));
    }

    @Test
    public void parseSimpleInputContainingTwoMovesMovingOnReverseY() {
        String input = "498,10 -> 498,6 -> 498,4";
        Set<Position> rocks = PuzzleResolver.parseInput(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertTrue(rocks.contains(Position.of(498,7)));
        assertTrue(rocks.contains(Position.of(498,8)));
        assertTrue(rocks.contains(Position.of(498,9)));
        assertTrue(rocks.contains(Position.of(498,10)));
        assertFalse(rocks.contains(Position.of(498,11)));
    }

    @Test
    public void parseInputContainingDirectionChanges() {
        String input = "498,10 -> 498,6 -> 498,4 -> 500,4";
        Set<Position> rocks = PuzzleResolver.parseInput(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertFalse(rocks.contains(Position.of(501,4)));
        assertTrue(rocks.contains(Position.of(500,4)));
        assertTrue(rocks.contains(Position.of(499,4)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertFalse(rocks.contains(Position.of(497,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertTrue(rocks.contains(Position.of(498,7)));
        assertTrue(rocks.contains(Position.of(498,8)));
        assertTrue(rocks.contains(Position.of(498,9)));
        assertTrue(rocks.contains(Position.of(498,10)));
        assertFalse(rocks.contains(Position.of(498,11)));
    }

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