package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.EmptyBoatException;
import com.lhauspie.adventofcode.model.Quantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
                10000
                """;
        var scanner = new Scanner(puzzleContent);
        Assertions.assertEquals(Quantity.of(20000), PuzzleResolver.resolve(scanner));
    }
}
