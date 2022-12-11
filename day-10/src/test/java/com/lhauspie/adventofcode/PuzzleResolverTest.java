package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.CrtScreen;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PuzzleResolverTest {

    @Test
    public void executeProgramAndGetSignalStrength() {
        assertEquals(13140, PuzzleResolver.resolveFirstPuzzle(new Scanner(inputExample())));
    }

    @Test
    public void executeProgramAndGetScreen1() {
        String input = """
                addx 15
                """;
        CrtScreen crtScreen = PuzzleResolver.resolveSecondPuzzle(new Scanner(input));
        assertEquals('#', crtScreen.getScreenContentAt(0,0));
        assertEquals('#', crtScreen.getScreenContentAt(1,0));
    }

    @Test
    public void executeProgramAndGetScreen2() {
        String input = """
                addx 15
                addx -11
                """;
        CrtScreen crtScreen = PuzzleResolver.resolveSecondPuzzle(new Scanner(input));
        assertEquals('#', crtScreen.getScreenContentAt(0, 0));
        assertEquals('#', crtScreen.getScreenContentAt(1, 0));
        assertEquals('.', crtScreen.getScreenContentAt(2, 0));
        assertEquals('.', crtScreen.getScreenContentAt(3, 0));
    }

    @Test
    public void executeProgramAndGetScreen4() {
        String expectedResult = """
                ##..##..##..##..##..##..##..##..##..##..
                ###...###...###...###...###...###...###.
                ####....####....####....####....####....
                #####.....#####.....#####.....#####.....
                ######......######......######......####
                #######.......#######.......#######.....
                """;
        CrtScreen crtScreen = PuzzleResolver.resolveSecondPuzzle(new Scanner(inputExample()));
        assertEquals(expectedResult, crtScreen.toString());
    }

    private String inputExample() {
        return """
                addx 15
                addx -11
                addx 6
                addx -3
                addx 5
                addx -1
                addx -8
                addx 13
                addx 4
                noop
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx -35
                addx 1
                addx 24
                addx -19
                addx 1
                addx 16
                addx -11
                noop
                noop
                addx 21
                addx -15
                noop
                noop
                addx -3
                addx 9
                addx 1
                addx -3
                addx 8
                addx 1
                addx 5
                noop
                noop
                noop
                noop
                noop
                addx -36
                noop
                addx 1
                addx 7
                noop
                noop
                noop
                addx 2
                addx 6
                noop
                noop
                noop
                noop
                noop
                addx 1
                noop
                noop
                addx 7
                addx 1
                noop
                addx -13
                addx 13
                addx 7
                noop
                addx 1
                addx -33
                noop
                noop
                noop
                addx 2
                noop
                noop
                noop
                addx 8
                noop
                addx -1
                addx 2
                addx 1
                noop
                addx 17
                addx -9
                addx 1
                addx 1
                addx -3
                addx 11
                noop
                noop
                addx 1
                noop
                addx 1
                noop
                noop
                addx -13
                addx -19
                addx 1
                addx 3
                addx 26
                addx -30
                addx 12
                addx -1
                addx 3
                addx 1
                noop
                noop
                noop
                addx -9
                addx 18
                addx 1
                addx 2
                noop
                noop
                addx 9
                noop
                noop
                noop
                addx -1
                addx 2
                addx -37
                addx 1
                addx 3
                noop
                addx 15
                addx -21
                addx 22
                addx -6
                addx 1
                noop
                addx 2
                addx 1
                noop
                addx -10
                noop
                noop
                addx 20
                addx 1
                addx 2
                addx 2
                addx -6
                addx -11
                noop
                noop
                noop
                """;
    }
}