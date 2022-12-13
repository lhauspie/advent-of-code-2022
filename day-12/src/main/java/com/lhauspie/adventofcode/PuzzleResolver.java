package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Explorer;
import com.lhauspie.adventofcode.model.Position;

import java.util.*;

public class PuzzleResolver {

    public record ParsingResult (
            Map<Position, Integer> heightmap,
            Position startPosition,
            Position endPosition) {}

    public static long resolveFirstPuzzle(Scanner scanner) {
        PuzzleResolver.ParsingResult parsingResult = parseInput(scanner);
        return new Explorer(parsingResult.heightmap).findTheShortestPath(parsingResult.startPosition, parsingResult.endPosition);
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        PuzzleResolver.ParsingResult parsingResult = parseInput(scanner);
        return new Explorer(parsingResult.heightmap).findTheShortestPathFromAnyZeroAltitudePosition(parsingResult.endPosition);
    }

    private static ParsingResult parseInput(Scanner scanner) {
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

        ParsingResult parsingResult = new ParsingResult(heightmap, startPosition, endPosition);
        return parsingResult;
    }
}
