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
        Assertions.assertThrows(EmptyBoatException.class, () -> PuzzleResolver.resolve(scanner));
    }

    @Test
    public void puzzleResolverCanResolveOneElfInBoat() throws EmptyBoatException {
        var puzzleContent = """
                10000
                """;
        var scanner = new Scanner(puzzleContent);
        Assertions.assertEquals(Quantity.of(10000), PuzzleResolver.resolve(scanner));
    }

    @Test
    public void puzzleResolverCanResolveTwoElvesInBoat() throws EmptyBoatException {
        var puzzleContent = """
                1000
                
                10000
                """;
        var scanner = new Scanner(puzzleContent);
        Assertions.assertEquals(10000, PuzzleResolver.resolve(scanner).getValue());
    }
}
