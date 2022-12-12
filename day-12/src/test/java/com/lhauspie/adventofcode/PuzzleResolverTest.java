package com.lhauspie.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleResolverTest {

    @Test
    public void firstTryToResolveFirstPuzzle() {
        String inputExample = """
                SbcdefghijklmnopqrstuvwxyE
                """;

        assertEquals(25, PuzzleResolver.resolveFirstPuzzle(new Scanner(inputExample)));
    }

    @Test
    public void secondTryToResolveFirstPuzzle() {
        String inputExample = """
                SbcddddefghijklmnopqrstuvwxyE
                """;

        assertEquals(28, PuzzleResolver.resolveFirstPuzzle(new Scanner(inputExample)));
    }

    @Test
    public void thirdTryToResolveFirstPuzzle() {
        String inputExample = """
                Sbcdefghijklmn
                zzEyxwvutsrqpo
                """;

        assertEquals(25, PuzzleResolver.resolveFirstPuzzle(new Scanner(inputExample)));
    }

    @Test
    public void firstTryToResolveFirstPuzzleAccordingToInputExample() {
        String inputExample = """
                Sabqponm
                abcryxxl
                accszExk
                acctuvwj
                abdefghi
                """;

        assertEquals(31, PuzzleResolver.resolveFirstPuzzle(new Scanner(inputExample)));
    }

    @Test
    public void secondTryToResolveFirstPuzzleAccordingToExtendedInputExample() {
        String inputExample = """
                Sabqponmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                abcryxxlmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                accszExkmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                acctuvwjmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                abdefghimmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                """;

        assertEquals(31, PuzzleResolver.resolveFirstPuzzle(new Scanner(inputExample)));
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        String inputExample = """
                Sabqponm
                abcryxxl
                accszExk
                acctuvwj
                abdefghi
                """;

        assertEquals(0L, PuzzleResolver.resolveSecondPuzzle(new Scanner(inputExample)));
    }
}