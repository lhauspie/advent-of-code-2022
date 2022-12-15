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
        Cave cave = parseCave(scanner);
        while (fallDownAndContinueIfSandUnitIsFallingIntoAbyssOrIsBlockingTheSandSource(cave.getSandSource().produceSandUnit(), cave)) {
            // nothing to do, just let falling down the sand
        };
        return cave.getNumberOfRestingSandUnits();
    }

    public static int resolveSecondPuzzle(Scanner scanner) {
        Cave cave = parseCave(scanner);
        addFloorToCave(cave);
        while (fallDownAndContinueIfSandUnitIsFallingIntoAbyssOrIsBlockingTheSandSource(cave.getSandSource().produceSandUnit(), cave)) {
            // nothing to do, just let falling down the sand
        };
        return cave.getNumberOfRestingSandUnits();
    }

    private static Cave parseCave(Scanner scanner) {
        SandSource sandSource = new SandSource(Position.of(500, 0));
        Cave cave = new Cave(sandSource);

        while (scanner.hasNextLine()) {
            parseInput(scanner.nextLine()).stream().forEach(position -> cave.addRock(position));
        }
        return cave;
    }

    private static void addFloorToCave(Cave cave) {
        int lastLineMaxY = cave.getMaxPosition().getY() + 1;
        String floor = cave.getMinXToAvoidSandUnitsFlowingIntoTheAbyss() + "," + lastLineMaxY + " -> " + cave.getMaxXToAvoidSandUnitsFlowingIntoTheAbyss() + "," + lastLineMaxY;
        parseInput(floor).stream().forEach(position -> cave.addRock(position));
    }

    private static boolean fallDownAndContinueIfSandUnitIsFallingIntoAbyssOrIsBlockingTheSandSource(SandUnit sandUnit, Cave cave) {
        while (fallOneStepDownAndContinueIfSandUnitReallyFeltDown(sandUnit, cave)) {
            // Stop falling when reaching the outside of the cave
            if (cave.isFallingIntoAbyss(sandUnit)) {
                return false;
            }
        }
        cave.addRestingSandUnit(sandUnit);
        // Stop falling down when sandUnit is blocking the sand source
        if (cave.isBlockingTheSandSource(sandUnit)) {
            return false;
        }
        return true;
    }

    private static boolean fallOneStepDownAndContinueIfSandUnitReallyFeltDown(SandUnit sandUnit, Cave cave) {
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
