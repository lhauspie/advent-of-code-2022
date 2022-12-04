package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.adapter.InputReader;

import java.util.Scanner;

public class PuzzleResolver {

    private static final int NUMBER_OF_ELVES_IN_A_GROUP = 3;

    public static int resolveFirstPuzzle(Scanner scanner) {
        var prioritySum = 0;

        while (scanner.hasNextLine()) {
            var rucksack = InputReader.inputRucksackContentToRucksack(scanner.nextLine());
            prioritySum += rucksack.getItemPresentInBothCompartments().getType().getPriority().getValue();
        }

        return prioritySum;
    }

    public static int resolveSecondPuzzle(Scanner scanner) {
        var prioritySum = 0;

        while (scanner.hasNextLine()) {
            var firstElfRucksack = InputReader.inputRucksackContentToRucksack(scanner.nextLine());
            var secondElfRucksack = InputReader.inputRucksackContentToRucksack(scanner.nextLine());
            var thirdElfRucksack = InputReader.inputRucksackContentToRucksack(scanner.nextLine());
            prioritySum += firstElfRucksack.getItemPresentInThreeRucksacks(secondElfRucksack, thirdElfRucksack).getType().getPriority().getValue();
        }

        return prioritySum;
    }
}
