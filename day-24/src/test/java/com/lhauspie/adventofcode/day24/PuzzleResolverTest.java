package com.lhauspie.adventofcode.day24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    String input = """
            #.######
            #>>.<^<#
            #.<..<<#
            #>v.><>#
            #<^v^^>#
            ######.#
            """;

    @Test
    public void tryToResolveFirstPuzzleAccordingToSmallExample() {
        String input = """
                #.###
                #>.<#
                #.^.#
                ###.#
                """;
        // #E###      #.###      #.###      #.###      #.###      #.###
        // #>.<# ===> #E3.# ===> #<.># ===> #>^<# ===> #.2.# ===> #.2.#
        // #.^.#      #...#      #E^.#      #.E.#      #.^E#      #.^.#
        // ###.#      ###.#      ###.#      ###.#      ###.#      ###E#
        //  M0         M1         M2         M3         M4         M5
        Assertions.assertEquals(5, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)).toMinutes());
    }

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        Assertions.assertEquals(18, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)).toMinutes());
    }


    @Test
    public void tryToResolveSecondPuzzleAccordingToSmallExample() {
        String input = """
                #.###
                #>.<#
                #.^.#
                ###.#
                """;
        //      #E###      #.###      #.###      #.###      #.###      #.###
        //      #>.<# ===> #E3.# ===> #<.># ===> #>^<# ===> #.2.# ===> #<.>#
        //      #.^.#      #...#      #E^.#      #.E.#      #.^E#      #.^.#
        //      ###.#      ###.#      ###.#      ###.#      ###.#      ###E#
        //       M0         M1         M2         M3         M4         M5

        //      #.###      #.###      #.###      #.###      #.###      #E###
        // ===> #>^<# ===> #.2.# ===> #<^># ===> #>.<# ===> #E3.# ===> #<.>#
        //      #..E#      #.^E#      #.E.#      #E^.#      #...#      #.^.#
        //      ###.#      ###.#      ###.#      ###.#      ###.#      ###.#
        //       M6         M7         M8         M9         M10        M11

        //      #E###      #.###      #.###      #.###      #.###      #.###
        // ===> #>^<# ===> #E2.# ===> #<.># ===> #>^<# ===> #.2.# ===> #<^>#
        //      #...#      #.^.#      #E^.#      #.E.#      #.^E#      #...#
        //      ###.#      ###.#      ###E#      ###.#      ###.#      ###E#
        //       M12        M13        M14        M15        M16        M17
        Assertions.assertEquals(17, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)).toMinutes());
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        Assertions.assertEquals(54, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)).toMinutes());
    }
}