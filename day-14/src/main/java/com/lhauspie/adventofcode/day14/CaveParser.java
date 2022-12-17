package com.lhauspie.adventofcode.day14;

import com.lhauspie.adventofcode.day14.model.Cave;
import com.lhauspie.adventofcode.day14.model.Position;
import com.lhauspie.adventofcode.day14.model.SandSource;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CaveParser {

    public static Cave parseCave(Scanner scanner, SandSource sandSource) {
        Cave cave = new Cave(sandSource);
        while (scanner.hasNextLine()) {
            getRockPositionsFromPathDescription(scanner.nextLine())
                    .stream().forEach(rockPosition -> cave.addRock(rockPosition));
        }
        return cave;
    }

    public static Set<Position> getRockPositionsFromPathDescription(String rockPath) {
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
