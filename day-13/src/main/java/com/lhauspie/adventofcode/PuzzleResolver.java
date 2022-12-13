package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.SignalAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuzzleResolver {

    public static int resolveFirstPuzzle(Scanner scanner) {
        int nb = 0;
        int index = 1;
        while (scanner.hasNextLine()) {
            if (SignalAnalyzer.pairIsInTheRightOrder(scanner.nextLine(), scanner.nextLine())) {
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
        List<String> signals = new ArrayList<>();
        signals.add("[[2]]");
        signals.add("[[6]]");
        while (scanner.hasNextLine()) {
            signals.add(scanner.nextLine());
            signals.add(scanner.nextLine());
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        signals.sort((o1, o2) -> SignalAnalyzer.compareSignals(o1, o2));

        return (signals.indexOf("[[2]]") + 1) * (signals.indexOf("[[6]]") + 1);
    }
}
