package com.lhauspie.adventofcode.day24;

import com.lhauspie.adventofcode.day24.model.Blizzard;
import com.lhauspie.adventofcode.day24.model.Direction;
import com.lhauspie.adventofcode.day24.model.Position;
import com.lhauspie.adventofcode.day24.model.Valley;

import java.time.Duration;
import java.util.Scanner;

import static com.lhauspie.adventofcode.day24.model.Direction.*;

public class PuzzleResolver {

    public static Duration resolveFirstPuzzle(Scanner scanner) {
        Valley valley = parseValley(scanner);

        Position startPosition = Position.of(valley.getWallsMinPosition().getX() + 1, valley.getWallsMinPosition().getY());
        Position endPosition = Position.of(valley.getWallsMaxPosition().getX() - 1, valley.getWallsMaxPosition().getY());

        return valley.reachPositionFromStartPositionAndGetTravelDuration(startPosition, endPosition);
    }

    public static Duration resolveSecondPuzzle(Scanner scanner) {
        Valley valley = parseValley(scanner);

        Position startPosition = Position.of(valley.getWallsMinPosition().getX() + 1, valley.getWallsMinPosition().getY());
        Position endPosition = Position.of(valley.getWallsMaxPosition().getX() - 1, valley.getWallsMaxPosition().getY());

        return Duration.ofMinutes(0)
                .plus(valley.reachPositionFromStartPositionAndGetTravelDuration(startPosition, endPosition))
                .plus(valley.reachPositionFromStartPositionAndGetTravelDuration(endPosition, startPosition))
                .plus(valley.reachPositionFromStartPositionAndGetTravelDuration(startPosition, endPosition));
    }

    private static Valley parseValley(Scanner scanner) {
        Valley valley = new Valley();
        int row = 0;
        while (scanner.hasNextLine()) {
            int col = 0;
            for (Character c : scanner.nextLine().toCharArray()) {
                Position currentPosition = Position.of(col, row);
                if (c == '#') {
                    valley.addWall(currentPosition);
                } else if (c != '.') {
                    valley.addBlizzard(new Blizzard(currentPosition, parseDirection(c)));
                }
                col++;
            }
            row++;
        }
        return valley;
    }

    private static Direction parseDirection(Character c) {
        return switch (c) {
            case '^' -> NORTH;
            case 'v' -> SOUTH;
            case '>' -> EAST;
            case '<' -> WEST;
            default -> STAY;
        };
    }
}
