package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.EmptyBoatException;
import com.lhauspie.adventofcode.model.Quantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PuzzleResolverTest {

    @Test
    public void puzzleResolverCanResolveEmptyBoat() {
        var puzzleContent = """
                """;
        var scanner = new Scanner(puzzleContent);
        Assertions.assertThrows(EmptyBoatException.class, () -> PuzzleResolver.resolveFirstPuzzle(scanner));
    }

    @Test
    public void puzzleResolverCanResolveOneElfInBoat() throws EmptyBoatException {
        var puzzleContent = """
                10000
                """;
        var scanner = new Scanner(puzzleContent);
        Assertions.assertEquals(Quantity.of(10000), PuzzleResolver.resolveFirstPuzzle(scanner));
    }

    @Test
    public void puzzleResolverCanResolveTwoElvesInBoat() throws EmptyBoatException {
        var puzzleContent = """
                1000
                                
                10000
                """;
        var scanner = new Scanner(puzzleContent);
        Assertions.assertEquals(10000, PuzzleResolver.resolveFirstPuzzle(scanner).getValue());
    }

    @Test
    public void puzzleResolverCanResolveTheFirstPuzzleWithInputExample() throws EmptyBoatException, FileNotFoundException {
        var scanner = new Scanner(new File("src/test/resources/input_example.txt"));
        Assertions.assertEquals(24000, PuzzleResolver.resolveFirstPuzzle(scanner).getValue());
    }

    @Test
    public void puzzleResolverCanResolveTheSecondPuzzleWithInputExample() throws EmptyBoatException, FileNotFoundException {
        var scanner = new Scanner(new File("src/test/resources/input_example.txt"));
        Assertions.assertEquals(45000, PuzzleResolver.resolveSecondPuzzle(scanner).getValue());
    }
}
