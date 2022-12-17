package com.lhauspie.adventofcode.day15;

import com.lhauspie.adventofcode.day15.PuzzleResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleResolverTest {

    private String input = """
            Sensor at x=2, y=18: closest beacon is at x=-2, y=15
            Sensor at x=9, y=16: closest beacon is at x=10, y=16
            Sensor at x=13, y=2: closest beacon is at x=15, y=3
            Sensor at x=12, y=14: closest beacon is at x=10, y=16
            Sensor at x=10, y=20: closest beacon is at x=10, y=16
            Sensor at x=14, y=17: closest beacon is at x=10, y=16
            Sensor at x=8, y=7: closest beacon is at x=2, y=10
            Sensor at x=2, y=0: closest beacon is at x=2, y=10
            Sensor at x=0, y=11: closest beacon is at x=2, y=10
            Sensor at x=20, y=14: closest beacon is at x=25, y=17
            Sensor at x=17, y=20: closest beacon is at x=21, y=22
            Sensor at x=16, y=7: closest beacon is at x=15, y=3
            Sensor at x=14, y=3: closest beacon is at x=15, y=3
            Sensor at x=20, y=1: closest beacon is at x=15, y=3
            """;

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        long millis = System.currentTimeMillis();
        Assertions.assertEquals(26, PuzzleResolver.resolveFirstPuzzle(new Scanner(input), 10));
        System.out.println("took " + (System.currentTimeMillis() - millis)+ " ms");
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        long millis = System.currentTimeMillis();
        Assertions.assertEquals(56000011, PuzzleResolver.resolveSecondPuzzle(new Scanner(input), 20, 20));
        System.out.println("took " + (System.currentTimeMillis() - millis)+ " ms");
    }
}