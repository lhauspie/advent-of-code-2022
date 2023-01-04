package com.lhauspie.adventofcode.day25;

import com.lhauspie.adventofcode.day25.model.DecimalToSnafuConverter;
import com.lhauspie.adventofcode.day25.model.SnafuToDecimalConverter;

import java.util.Scanner;

public class PuzzleResolver {

    public static String resolveFirstPuzzle(Scanner scanner) {
        long sum = 0;
        while (scanner.hasNextLine()) {
            sum += SnafuToDecimalConverter.convert(scanner.nextLine());
        }
        return DecimalToSnafuConverter.convert(sum);
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        return 0;
    }
}
