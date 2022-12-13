package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Explorer;
import com.lhauspie.adventofcode.model.Position;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class PuzzleResolver {

    public record ParsingResult (
            Map<Position, Integer> heightmap,
            Position startPosition,
            Position endPosition) {}

    @FunctionalInterface
    public interface HeightParser {
        void parseHeightAtPosition(Position position, char c);
    }

    public static long resolveFirstPuzzle(Scanner scanner) {
        PuzzleResolver.ParsingResult parsingResult = parseInput(scanner);
        return new Explorer(parsingResult.heightmap)
                .findTheShortestPath(parsingResult.startPosition, parsingResult.endPosition);
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        PuzzleResolver.ParsingResult parsingResult = parseInput(scanner);
        return new Explorer(parsingResult.heightmap)
                .findTheShortestPathFromAnyZeroAltitudePosition(parsingResult.endPosition);
    }

    private static ParsingResult parseInput(Scanner scanner) {
        final Map<Position, Integer> heightmap = new HashMap<>();
        final AtomicReference<Position> startPosition = new AtomicReference<>(null);
        final AtomicReference<Position> endPosition = new AtomicReference<>(null);

        parseInputPositionPerPosition(scanner, (currentPosition, c) -> {
            if (c == 'S') {
                startPosition.set(currentPosition);
            } else if (c == 'E') {
                endPosition.set(currentPosition);
            }
            heightmap.put(currentPosition, getHeightAssociatedToChar(c));
        });

        return new ParsingResult(heightmap, startPosition.get(), endPosition.get());
    }

    private static Integer getHeightAssociatedToChar(char c) {
        char height = c;
        if (c == 'S') {
            height = 'a';
        } else if (c == 'E') {
            height = 'z';
        }
        return height - 'a';
    }

    private static void parseInputPositionPerPosition(Scanner scanner, HeightParser parser) {
        int nbLines = 0;
        while (scanner.hasNextLine()) {
            char[] nextLine = scanner.nextLine().toCharArray();
            for (int i = 0; i < nextLine.length; i++) {
                Position currentPosition = Position.of(i, nbLines);
                parser.parseHeightAtPosition(currentPosition, nextLine[i]);
            }
            nbLines++;
        }
    }
}
