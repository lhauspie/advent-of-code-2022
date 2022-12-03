package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.EmptyBoatException;
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
}
