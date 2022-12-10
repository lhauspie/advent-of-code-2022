package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.RopeNode;
import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Rope;
import com.lhauspie.adventofcode.model.move.Down;
import com.lhauspie.adventofcode.model.move.Left;
import com.lhauspie.adventofcode.model.move.Right;
import com.lhauspie.adventofcode.model.move.Up;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PuzzleResolver {

    public static int resolveFirstPuzzle(Scanner scanner) {
        Rope rope = new Rope(
                newNodeAtStartPosition(),
                newNodeAtStartPosition()
        );
        return followTailWhileMovingRope(scanner, rope).size();
    }

    public static int resolveSecondPuzzle(Scanner scanner) {
        Rope rope = newRopeAtStartPosition();
        return followTailWhileMovingRope(scanner, rope).size();
    }

    private static Set<Position> followTailWhileMovingRope(Scanner scanner, Rope rope) {
        Set<Position> tailPositions = new HashSet<>();
        while (scanner.hasNextLine()) {
            Motion motion = toMotion(scanner.nextLine());
            tailPositions.addAll(motion.executeAndGetTailPositions(rope));
        }
        return tailPositions;
    }

    private static Rope newRopeAtStartPosition() {
        return new Rope(
                newNodeAtStartPosition(),
                newNodeAtStartPosition(),
                newNodeAtStartPosition(),
                newNodeAtStartPosition(),
                newNodeAtStartPosition(),
                newNodeAtStartPosition(),
                newNodeAtStartPosition(),
                newNodeAtStartPosition(),
                newNodeAtStartPosition(),
                newNodeAtStartPosition()
        );
    }

    private static RopeNode newNodeAtStartPosition() {
        return new RopeNode(Position.of(0, 0));
    }

    private static Motion toMotion(String puzzleLine) {
        int quantity = Integer.parseInt(puzzleLine.split(" ")[1]);
        if (puzzleLine.startsWith("L")) return new Motion(new Left(), quantity);
        if (puzzleLine.startsWith("R")) return new Motion(new Right(), quantity);
        if (puzzleLine.startsWith("D")) return new Motion(new Down(), quantity);
        if (puzzleLine.startsWith("U")) return new Motion(new Up(), quantity);
        throw new RuntimeException("Unsupported puzzleLine " + puzzleLine);
    }
}
