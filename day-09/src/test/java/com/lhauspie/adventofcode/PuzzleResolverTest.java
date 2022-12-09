package com.lhauspie.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleResolverTest {

    @Test
    public void movingRopeLeftOnceResultsInOnePositionVisited() {
        String input = """
                L 1
                """;

        assertEquals(1, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }
}