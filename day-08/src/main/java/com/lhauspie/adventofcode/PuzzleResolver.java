package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.*;
import com.lhauspie.adventofcode.model.grid.Column;
import com.lhauspie.adventofcode.model.grid.Coordinate;
import com.lhauspie.adventofcode.model.grid.Row;

import java.util.Comparator;
import java.util.Scanner;

public class PuzzleResolver {

    public static int resolveFirstPuzzle(Scanner scanner) {
        Forest forest = parseForest(scanner);

        Quadcopter quadCopter = new Quadcopter(forest);
        return quadCopter.getCoordinatesVisibleFromOutside().size();
    }

    public static ScenicScore resolveSecondPuzzle(Scanner scanner) {
        Forest forest = parseForest(scanner);

        Quadcopter quadCopter = new Quadcopter(forest);
        return quadCopter.getScenicScores().values().stream()
                .max(Comparator.comparingInt(ScenicScore::getValue))
                .orElse(ScenicScore.of(0));
    }

    private static Forest parseForest(Scanner scanner) {
        var forest = new Forest();
        var row = Row.of(1);
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();

            var column = Column.of(1);
            for (char c : nextLine.toCharArray()) {
                forest.put(new Tree(Height.of(Integer.parseInt("" + c))), new Coordinate(row, column));
                column = column.right();
            }
            row = row.bottom();
        }
        return forest;
    }

}
