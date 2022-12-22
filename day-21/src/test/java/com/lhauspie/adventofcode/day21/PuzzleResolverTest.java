package com.lhauspie.adventofcode.day21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    String input = """
            root: pppw + sjmn
            dbpl: 5
            cczh: sllz + lgvd
            zczc: 2
            ptdq: humn - dvpt
            dvpt: 3
            lfqf: 4
            humn: 5
            ljgn: 2
            sjmn: drzm * dbpl
            sllz: 4
            pppw: cczh / lfqf
            lgvd: ljgn * ptdq
            drzm: hmdt - zczc
            hmdt: 32
            """;

    @Test
    public void testOne() {
    String input = """
            root: pppw + sjmn
            sjmn: 4
            pppw: 6
            """;
        Assertions.assertEquals(10, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void testTwo() {
    String input = """
            root: pppw * sjmn
            sjmn: 4
            pppw: 6
            """;
        Assertions.assertEquals(24, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void testThree() {
    String input = """
            root: pppw - sjmn
            sjmn: 6
            pppw: 4
            """;
        Assertions.assertEquals(-2, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void testFour() {
    String input = """
            root: pppw / sjmn
            sjmn: 6
            pppw: 4
            """;
        Assertions.assertEquals(0, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        Assertions.assertEquals(152, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        Assertions.assertEquals(301, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }
}