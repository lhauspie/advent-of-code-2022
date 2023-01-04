package com.lhauspie.adventofcode.day25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    String input = """
            1=-0-2
            12111
            2=0=
            21
            2=01
            111
            20012
            112
            1=-1=
            1-12
            12
            1=
            122
            """;

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        Assertions.assertEquals("2=-1=0", PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }
}