package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.CrtScreen;

import java.util.Optional;
import java.util.Scanner;

public class PuzzleResolver {

    public static int resolveFirstPuzzle(Scanner scanner) {
        int signalStrength = 0;
        int value = 1;
        int cycle = 0;

        Optional<Integer> twentiethCycleValue = Optional.empty();
        Optional<Integer> sixtiethCycleValue = Optional.empty();
        Optional<Integer> hundredthCycleValue = Optional.empty();
        Optional<Integer> hundredAndFortiethCycleValue = Optional.empty();
        Optional<Integer> hundredAndEightiethCycleValue = Optional.empty();
        Optional<Integer> twoHundredAndTwentiethCycleValue = Optional.empty();

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("addx")) {
                cycle += 2;
                if (cycle >= 220 && twoHundredAndTwentiethCycleValue.isEmpty()) {
                    twoHundredAndTwentiethCycleValue = Optional.of(value);
                    signalStrength = signalStrength + value * 220;
                } else if (cycle >= 180 && hundredAndEightiethCycleValue.isEmpty()) {
                    hundredAndEightiethCycleValue = Optional.of(value);
                    signalStrength = signalStrength + value * 180;
                } else if (cycle >= 140 && hundredAndFortiethCycleValue.isEmpty()) {
                    hundredAndFortiethCycleValue = Optional.of(value);
                    signalStrength = signalStrength + value * 140;
                } else if (cycle >= 100 && hundredthCycleValue.isEmpty()) {
                    hundredthCycleValue = Optional.of(value);
                    signalStrength = signalStrength + value * 100;
                } else if (cycle >= 60 && sixtiethCycleValue.isEmpty()) {
                    sixtiethCycleValue = Optional.of(value);
                    signalStrength = signalStrength + value * 60;
                } else if (cycle >= 20 && twentiethCycleValue.isEmpty()) {
                    twentiethCycleValue = Optional.of(value);
                    signalStrength = signalStrength + value * 20;
                }

                value += Integer.parseInt(nextLine.split(" ")[1]);
            } else {
                cycle++;
            }
        }
        return signalStrength;
    }


    public static CrtScreen resolveSecondPuzzle(Scanner scanner) {
        CrtScreen crtScreen = new CrtScreen();

        while (scanner.hasNextLine()) {
            crtScreen.executeInstruction(scanner.nextLine());
        }

        return crtScreen;
    }
}
