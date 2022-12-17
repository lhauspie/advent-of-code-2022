package com.lhauspie.adventofcode.day15;

import com.lhauspie.adventofcode.day15.model.Cave;
import com.lhauspie.adventofcode.day15.model.Position;
import com.lhauspie.adventofcode.day15.model.Sensor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner, int y) {
        Cave cave = parseInput(scanner, Position.of(0, 0), Position.of(0, 0));
        return cave.getNumberOfPositionsWhereABeaconCannotBePresent(y);
    }

    public static long resolveSecondPuzzle(Scanner scanner, int maxX, int maxY) {
        Cave cave = parseInput(scanner, Position.of(0, 0), Position.of(maxX, maxY));
        Position theOnlyPositionNotCoveredByAtLeastOneSensor = cave.getTheOnlyPositionNotCoveredByAtLeastOneSensor();
        return theOnlyPositionNotCoveredByAtLeastOneSensor.getX() * 4000000L + theOnlyPositionNotCoveredByAtLeastOneSensor.getY();
    }

    private static Cave parseInput(Scanner scanner, Position topLeftCorner, Position bottomRightCorener) {
        Cave cave = new Cave(topLeftCorner, bottomRightCorener);

        Pattern sensorPattern = Pattern.compile("Sensor at x=([\\-0-9]+), y=([\\-0-9]+): closest beacon is at x=([\\-0-9]+), y=([\\-0-9]+)");
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            Matcher sensorMatcher = sensorPattern.matcher(nextLine);
            sensorMatcher.find();
            cave.addSensor(
                    new Sensor(
                            Position.of(Integer.parseInt(sensorMatcher.group(1)), Integer.parseInt(sensorMatcher.group(2))),
                            Position.of(Integer.parseInt(sensorMatcher.group(3)), Integer.parseInt(sensorMatcher.group(4)))
                    )
            );
        }
        return cave;
    }
}
