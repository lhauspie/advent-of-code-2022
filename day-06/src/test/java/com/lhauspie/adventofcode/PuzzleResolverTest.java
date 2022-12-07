package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.v2.subroutine.NoValidMarkerFoundException;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleResolverTest {

    @Test
    public void puzzleResolverCanResolveFirstPuzzleWithInputExample() throws NoValidMarkerFoundException {
        String input = "fdhsgfvqihdfqdshlvdsvkdskjdgcdskjfhldqskfg";
        assertEquals(4, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void firstInputExampleShouldReturnSeven() throws NoValidMarkerFoundException {
        var input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
        assertEquals(7, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void secondInputExampleShouldReturnFive() throws NoValidMarkerFoundException {
        var input = "bvwbjplbgvbhsrlpgdmjqwftvncz";
        assertEquals(5, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void thirdInputExampleShouldReturnSix() throws NoValidMarkerFoundException {
        var input = "nppdvjthqldpwncqszvftbrmjlhg";
        assertEquals(6, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void fourthInputExampleShouldReturnTen() throws NoValidMarkerFoundException {
        var input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
        assertEquals(10, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void fifthInputExampleShouldReturnEleven() throws NoValidMarkerFoundException {
        var input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";
        assertEquals(11, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }
}
