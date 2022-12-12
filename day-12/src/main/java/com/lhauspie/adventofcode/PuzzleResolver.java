package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Position;

import java.util.*;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner) {
        Map<Position, Integer> heightmap = new HashMap<>();

        Position startPosition = null;
        Position endPosition = null;

        int nbLines = 0;
        while (scanner.hasNextLine()) {
            char[] nextLine = scanner.nextLine().toCharArray();
            for (int i = 0; i < nextLine.length; i++) {
                Position currentPosition = Position.of(i, nbLines);
                if (nextLine[i] == 'S') {
                    heightmap.put(currentPosition, 'a' - 'a');
                    startPosition = currentPosition;
                } else if (nextLine[i] == 'E') {
                    heightmap.put(currentPosition, 'z' - 'a');
                    endPosition = currentPosition;
                } else {
                    heightmap.put(currentPosition, nextLine[i] - 'a');
                }
            }
            nbLines++;
        }

        return findTheShortestPath(heightmap, startPosition, endPosition);
    }


    public static Integer findTheShortestPath(Map<Position, Integer> heightmap, Position startPosition, Position endPosition) {
        Map<Position, Integer> numberOfStepsFromStartPositionPerPosition = new HashMap<>();
        numberOfStepsFromStartPositionPerPosition.put(startPosition, 0);

        boolean endPositionReached = false;
        while (!endPositionReached) {
//            render(heightmap, numberOfStepsFromStartPositionPerPosition);
            exploreNeighboursOfAlreadyExploredPositions(heightmap, numberOfStepsFromStartPositionPerPosition);
            endPositionReached = numberOfStepsFromStartPositionPerPosition.containsKey(endPosition);
        }

        return numberOfStepsFromStartPositionPerPosition.get(endPosition);
    }

    private static void exploreNeighboursOfAlreadyExploredPositions(Map<Position, Integer> heightmap, Map<Position, Integer> numberOfStepsFromStartPositionPerPosition) {
        // for each already explored Position, we'll calculate the Neighbours' number of steps
        Set<Position> positions = new HashSet<>(numberOfStepsFromStartPositionPerPosition.keySet());
        for (var currentPosition : positions) {
            var numberOfStepsForPosition = numberOfStepsFromStartPositionPerPosition.get(currentPosition);

            Position up = currentPosition.up();
            if (heightmap.containsKey(up)                                                   // up is not outside the map
                    && heightmap.get(up) <= heightmap.get(currentPosition) + 1              // up is not too high
                    && !numberOfStepsFromStartPositionPerPosition.containsKey(up)) {        // up is never explored
                numberOfStepsFromStartPositionPerPosition.put(up, numberOfStepsForPosition + 1);
            }

            Position down = currentPosition.down();
            if (heightmap.containsKey(down)                                                 // down is not outside the map
                    && heightmap.get(down) <= heightmap.get(currentPosition) + 1            // down is not too high
                    && !numberOfStepsFromStartPositionPerPosition.containsKey(down)) {      // down is never explored
                numberOfStepsFromStartPositionPerPosition.put(down, numberOfStepsForPosition + 1);
            }

            Position left = currentPosition.left();
            if (heightmap.containsKey(left)                                                 // left is not outside the map
                    && heightmap.get(left) <= heightmap.get(currentPosition) + 1            // left is not too high
                    && !numberOfStepsFromStartPositionPerPosition.containsKey(left)) {      // left is never explored
                numberOfStepsFromStartPositionPerPosition.put(left, numberOfStepsForPosition + 1);
            }

            Position right = currentPosition.right();
            if (heightmap.containsKey(right)                                                // right is not outside the map
                    && heightmap.get(right) <= heightmap.get(currentPosition) + 1           // right is not too high
                    && !numberOfStepsFromStartPositionPerPosition.containsKey(right)) {     // right is never explored
                numberOfStepsFromStartPositionPerPosition.put(right, numberOfStepsForPosition + 1);
            }
        }
    }

    private static void render(Map<Position, Integer> heightmap, Map<Position, Integer> shortestPathPerPosition) {
        Integer maxX = heightmap.keySet().stream().max(Comparator.comparingInt(Position::getX)).get().getX();
        Integer maxY = heightmap.keySet().stream().max(Comparator.comparingInt(Position::getY)).get().getY();
        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                Position position = Position.of(x, y);
                System.out.print("|" + (shortestPathPerPosition.containsKey(position) ? String.format(".%02d", shortestPathPerPosition.get(position)) : String.format("%03d", heightmap.get(position))));
            }
            System.out.println();
        }
        System.out.println("==================================");
    }


    public static long resolveSecondPuzzle(Scanner scanner) {
        return 0;
    }
}
