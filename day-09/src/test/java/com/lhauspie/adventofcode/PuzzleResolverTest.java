package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.RopeNode;
import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Rope;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleResolverTest {

    @Test
    public void movingRopeLeftOnceResultsInOnePositionVisited() {
        String input = """
                L 1
                """;

        assertEquals(1, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void movingRopeLeftTwiceResultsInTwoPositionVisited() {
        String input = """
                L 2
                """;

        assertEquals(2, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void movingRopeLeftTwiceThenUpTwiceResultsInTwoPositionVisited() {
        String input = """
                L 2
                U 2
                """;

        assertEquals(3, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void movingRopeLeftTwiceThenRightTwiceResultsInTwoPositionVisited() {
        String input = """
                L 2
                R 2
                """;

        assertEquals(2, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveFirstPuzzleWithInputExample() {
        String input = """
                R 4
                U 4
                L 3
                D 1
                R 4
                D 1
                L 5
                R 2
                """;

        assertEquals(13, PuzzleResolver.resolveFirstPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleWithFirstInputExample() {
        String input = """
                R 4
                U 4
                L 3
                D 1
                R 4
                D 1
                L 5
                R 2
                """;

        assertEquals(1, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }

    @Test
    public void tryToResolveSecondPuzzleWithInputExample() {
        String input = """
                R 5
                U 8
                L 8
                D 3
                R 17
                D 10
                L 25
                U 20
                """;

        assertEquals(36, PuzzleResolver.resolveSecondPuzzle(new Scanner(input)));
    }

    @Test
    public void problematicSituationToResolve() {
        //   012345
        // 4 ......
        // 3 ....H.
        // 2 ....1.
        // 1 .432..
        // 0 5.....
        var rope = new Rope(
                new RopeNode(Position.of(4, 3)), // H
                new RopeNode(Position.of(4, 2)), // 1
                new RopeNode(Position.of(3, 1)), // 2
                new RopeNode(Position.of(2, 1)), // 3
                new RopeNode(Position.of(1, 1)), // 4
                new RopeNode(Position.of(0, 0))  // 5
        );

        // Moving Up the head give this Rope:
        //   01234
        // 4 ....H
        // 3 ....1
        // 2 .5432
        // 1 .6...
        // 0 7....
        // Instead of this one:
        //   01234
        // 4 ....H
        // 3 ....1
        // 2 ..432
        // 1 .5...
        // 0 6....
        // The problem is the Node 5 is going from 0,0 to 2,1 what is a forgiven operation

        rope.getHead().moveUp();
        // Step by step operations
        //   01234     01234     01234     01234     01234     01234     01234
        // 4 .....   4 ....H   4 ....H   4 ....H   4 ....H   4 ....H   4 ....H
        // 3 ....H   3 .....   3 ....1   3 ....1   3 ....1   3 ....1   3 ....1
        // 2 ....1   2 ....1   2 .....   2 ....2   2 ...32   2 ..432   2 ..432
        // 1 .432.   1 .432.   1 .432.   1 .43..   1 .4...   1 .....   1 .5...
        // 0 5....   0 5....   0 5....   0 5....   0 5....   0 5....   0 6....
        assertEquals(Position.of(1, 1), rope.getTail().getPosition());
    }
}