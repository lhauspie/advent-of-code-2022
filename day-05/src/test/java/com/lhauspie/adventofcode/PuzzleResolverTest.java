package com.lhauspie.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleResolverTest {

    @Test
    public void puzzleResolverCanResolveFirstPuzzleWithInputExample() {
        String input = """
                    [D]    
                [N] [C]    
                [Z] [M] [P]
                 1   2   3
                
                move 1 from 2 to 1
                move 3 from 1 to 3
                move 2 from 2 to 1
                move 1 from 1 to 2
                """;

        String str = PuzzleResolver.resolveFirstPuzzle(new Scanner(input));

        assertEquals("CMZ", str);
    }

    @Test
    public void puzzleResolverCanResolveSecondPuzzleWithInputExample() {
        String input = """
                    [D]    
                [N] [C]    
                [Z] [M] [P]
                 1   2   3
                
                move 1 from 2 to 1
                move 3 from 1 to 3
                move 2 from 2 to 1
                move 1 from 1 to 2
                """;

        String str = PuzzleResolver.resolveSecondPuzzle(new Scanner(input));

        assertEquals("MCD", str);
    }
}
