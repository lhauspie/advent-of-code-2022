package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Cave;
import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.SandSource;
import com.lhauspie.adventofcode.model.SandUnit;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PuzzleResolver {

    public static int resolveFirstPuzzle(Scanner scanner) {
        SandSource sandSource = new SandSource(Position.of(500, 0));
        Cave cave = new Cave(sandSource);

        while (scanner.hasNextLine()) {
            parseInput(scanner.nextLine()).stream().forEach(position -> cave.addRock(position));
        }

        while (fallDown(sandSource.newSandUnit(), cave)) {
            // nothing to do, just let falling down the sand
        };

        cave.render(sandSource.newSandUnit());
        return cave.getNumberOfRestingSandUnits();
    }

    public static int resolveSecondPuzzle(Scanner scanner) {
        SandSource sandSource = new SandSource(Position.of(500, 0));
        Cave cave = new Cave(sandSource);

        while (scanner.hasNextLine()) {
            parseInput(scanner.nextLine()).stream().forEach(position -> cave.addRock(position));
        }

        int lastLineMaxY = cave.getMaxPosition().getY() + 1;
        // bottom line
        parseInput(
                cave.getMinX() + "," + lastLineMaxY + " -> " + cave.getMaxX() + "," + lastLineMaxY
        ).stream().forEach(position -> cave.addRock(position));

        while (fallDown(sandSource.newSandUnit(), cave)) {
            // nothing to do, just let falling down the sand
        };

        cave.render(sandSource.newSandUnit());
        return cave.getNumberOfRestingSandUnits();
    }


    // return true if sandUnit succeeded to rest
    // return false if sandUnit is falling outside the cave
    private static boolean fallDown(SandUnit sandUnit, Cave cave) {
        while (fallOneStepDown(sandUnit, cave)) {
            // Stop falling when reaching the outside of the cave
            if (sandUnit.getPosition().getY() > cave.getMaxPosition().getY()) {
                return false;
            }
        }
        cave.addRestingSandUnit(sandUnit);
        // Stop falling when sandUnit is blocking the sand source
        if (cave.isBlockingTheSandSource(sandUnit)) {
            return false;
        }
        return true;
    }

    // return true if sandUnit succeed to fall one step down
    // return false if the sandUnit stay at its position
    private static boolean fallOneStepDown(SandUnit sandUnit, Cave cave) {
        Position down = sandUnit.getPosition().down();
        Position downLeft = down.left();
        Position downRight = down.right();
        if (cave.isFree(down)) {
            sandUnit.setPosition(down);
        } else if (cave.isFree(downLeft)) {
            sandUnit.setPosition(downLeft);
        } else if (cave.isFree(downRight)) {
            sandUnit.setPosition(downRight);
        } else {
            return false;
        }
        return true;
    }


    public static Set<Position> parseInput(String rockPath) {
        Set<Position> positions = new HashSet<>();
        String[] rockPositionChanges = rockPath.split(" -> ");

        Position previousPosition = null;
        for (String rockPositionChange : rockPositionChanges) {
            String[] currentPositionAsStrings = rockPositionChange.split(",");
            Position currentPosition = Position.of(Integer.parseInt(currentPositionAsStrings[0]), Integer.parseInt(currentPositionAsStrings[1]));
            positions.addAll(rockPositions(previousPosition, currentPosition));
            previousPosition = currentPosition;
        }

        return positions;
    }

    private static Set<Position> rockPositions(Position start, Position end) {
        Set<Position> positions = new HashSet<>();
        if (start == null) {
            positions.add(end);
        } else {
            if (start.getX() == end.getX()) {
                for (int y = Math.min(start.getY(), end.getY()); y <= Math.max(start.getY(), end.getY()); y++) {
                    positions.add(Position.of(start.getX(), y));
                }
            }
            if (start.getY() == end.getY()) {
                for (int x = Math.min(start.getX(), end.getX()); x <= Math.max(start.getX(), end.getX()); x++) {
                    positions.add(Position.of(x, start.getY()));
                }
            }
        }
        return positions;
    }

}
