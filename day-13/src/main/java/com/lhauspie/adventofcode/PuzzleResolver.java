package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.SignalAnalyzer;

import java.util.Scanner;

public class PuzzleResolver {

    public static int resolveFirstPuzzle(Scanner scanner) {
        int nb = 0;
        int index = 1;
        while (scanner.hasNextLine()) {
            if (!SignalAnalyzer.pairIsInTheRightOrder(scanner.nextLine(), scanner.nextLine())) {
                nb += index;
            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            index++;
        }
        return nb;
    }


    public static int resolveSecondPuzzle(Scanner scanner) {
        return 0;
    }

}
