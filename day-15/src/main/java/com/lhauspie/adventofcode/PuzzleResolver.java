package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Cave;
import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Sensor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner, int y) {
        Pattern sensorPattern = Pattern.compile("Sensor at x=([\\-0-9]+), y=([\\-0-9]+): closest beacon is at x=([\\-0-9]+), y=([\\-0-9]+)");
        Cave cave = new Cave();

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
        return cave.getNumberOfPositionsWhereABeaconCannotBePresent(y);
    }

    public static int resolveSecondPuzzle(Scanner scanner) {
        return 0;
    }
}
