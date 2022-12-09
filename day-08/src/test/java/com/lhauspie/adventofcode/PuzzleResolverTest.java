package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.ScenicScore;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleResolverTest {

    @Test
    public void tryToResolveFirstPuzzleWithInputExample() {
        String input = """
                30373
                25512
                65332
                33549
                35390
                """;
        assertEquals(21, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleWithInputExample() {
        String input = """
                30373
                25512
                65332
                33549
                35390
                """;
        assertEquals(ScenicScore.of(8), PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }
}