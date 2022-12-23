package com.lhauspie.adventofcode.day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PuzzleResolverTest {

    @Test
    public void tryToResolveFirstPuzzleAccordingToInputExample() {
        String input = """
                    ...#
                    .#..
                    #...
                    ....
            ...#.......#
            ........#...
            ..#....#....
            ..........#.
                    ...#....
                    .....#..
                    .#......
                    ......#.
            
            10R5L5R10L4R5L5
            """;

        Assertions.assertEquals(6032, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleAccordingToInputExample() {
        String input = """
                ...#.#..                           
                .#......                           
                #.....#.                       
                ........                       
                ...#                       
                #...                       
                ....                       
                ..#.                       
            .......#                       
            ..#.....                       
            .....#..                       
            ........                       
            #...                           
            ..#.                           
            ....                           
            ....                           
            
            10R5L5R10L4R5L5
            """;

        Assertions.assertEquals(10006, PuzzleResolver.resolveSecondPuzzle(new Scanner(input), 4));
    }
}