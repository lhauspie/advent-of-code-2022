package com.lhauspie.adventofcode.day18;

import com.lhauspie.adventofcode.day18.model.LavaDroplet;
import com.lhauspie.adventofcode.day18.model.Point3D;

import java.util.Scanner;

public class PuzzleResolver {
    public static long resolveFirstPuzzle(Scanner scanner) {
        LavaDroplet lavaDroplet = parseLavaDropletFromInput(scanner);
        return lavaDroplet.getTotalSurfaceAreaIncludingAirPockets();
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        LavaDroplet lavaDroplet = parseLavaDropletFromInput(scanner);
        return lavaDroplet.getTotalSurfaceAreaIgnoringAirPockets();
    }

    private static LavaDroplet parseLavaDropletFromInput(Scanner scanner) {
        LavaDroplet lavaDroplet = new LavaDroplet();
        while (scanner.hasNextLine()) {
            lavaDroplet.add(parsePointFromInputLine(scanner.nextLine()));
        }
        return lavaDroplet;
    }

    private static Point3D parsePointFromInputLine(String inputLine) {
        String[] nextSplitLine = inputLine.split(",");
        return Point3D.of(Long.parseLong(nextSplitLine[0]), Long.parseLong(nextSplitLine[1]), Long.parseLong(nextSplitLine[2]));
    }
}
