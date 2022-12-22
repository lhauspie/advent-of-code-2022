package com.lhauspie.adventofcode.day20;


import com.lhauspie.adventofcode.day20.model.Number;
import com.lhauspie.adventofcode.day20.model.Sequence;

import java.util.Scanner;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner) {
        Sequence sequence = new Sequence();
        while (scanner.hasNextInt()) {
            sequence.add(scanner.nextInt());
        }
        Number zero = sequence.decryptAndGetZeroNumber();

        Number firstNumber = get(zero, 1000);
        Number secondNumber = get(firstNumber, 1000);
        Number thirdNumber = get(secondNumber, 1000);

        return firstNumber.getValue() + secondNumber.getValue() + thirdNumber.getValue();
    }

    private static Number get(Number zero, int i) {
        Number number = zero;
        for (int j = 0; j < i; j++) {
            number = number.getNextNumber();
        }
        return number;
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        Sequence sequence = new Sequence();
        while (scanner.hasNextInt()) {
            sequence.add(scanner.nextInt());
        }
        Number zero = sequence.decryptAndGetZeroNumber(811589153L);

        Number firstNumber = get(zero, 1000);
        Number secondNumber = get(firstNumber, 1000);
        Number thirdNumber = get(secondNumber, 1000);

        return firstNumber.getValue() + secondNumber.getValue() + thirdNumber.getValue();
    }
}
