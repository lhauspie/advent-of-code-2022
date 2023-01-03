package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.adapter.InputReader;
import com.lhauspie.adventofcode.model.Pair;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        InputStream puzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("First puzzle result : " + resolveFirstPuzzle(new Scanner(puzzleInput)));

        InputStream puzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("Second puzzle result : " + resolveSecondPuzzle(new Scanner(puzzleInput)));
    }

    public static int resolveFirstPuzzle(Scanner scanner) {
        int numberOfOverlappingRanges = 0;

        while (scanner.hasNextLine()) {
            Pair pair = InputReader.inputPairContentToPair(scanner.nextLine());
            if (pair.isFullyContain()) {
                numberOfOverlappingRanges++;
            }
        }

        return numberOfOverlappingRanges;
    }

    public static int resolveSecondPuzzle(Scanner scanner) {
        int numberOfOverlappingRanges = 0;

        while (scanner.hasNextLine()) {
            Pair pair = InputReader.inputPairContentToPair(scanner.nextLine());
            if (pair.isOverlap()) {
                numberOfOverlappingRanges++;
            }
        }

        return numberOfOverlappingRanges;
    }
}
