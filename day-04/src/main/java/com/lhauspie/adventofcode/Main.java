package com.lhauspie.adventofcode;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public record Range(int start, int stop) {};

    public static void main (String... args) {
        InputStream firstPuzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("First puzzle result : " + resolveFirstPuzzle(new Scanner(firstPuzzleInput)));

        InputStream secondPuzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("Second puzzle result : " + resolveSecondPuzzle(new Scanner(secondPuzzleInput)));
    }

    private static int resolveFirstPuzzle(Scanner scanner) {
        int count = 0;

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] nextSplitedLine = nextLine.split(",");
            String[] firstIntStr = nextSplitedLine[0].split("-");
            String[] secondIntStr = nextSplitedLine[1].split("-");
            Range firstRange = new Range(Integer.parseInt(firstIntStr[0]), Integer.parseInt(firstIntStr[1]));
            Range secondRange = new Range(Integer.parseInt(secondIntStr[0]), Integer.parseInt(secondIntStr[1]));

            if (firstRange.start <= secondRange.start && firstRange.stop >= secondRange.stop) {
                count++;
            } else if (secondRange.start <= firstRange.start && secondRange.stop >= firstRange.stop) {
                count++;
            }
        }

        return count;
    }

    private static int resolveSecondPuzzle(Scanner scanner) {
        int count = 0;

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] nextSplitedLine = nextLine.split(",");
            String[] firstIntStr = nextSplitedLine[0].split("-");
            String[] secondIntStr = nextSplitedLine[1].split("-");
            Range firstRange = new Range(Integer.parseInt(firstIntStr[0]), Integer.parseInt(firstIntStr[1]));
            Range secondRange = new Range(Integer.parseInt(secondIntStr[0]), Integer.parseInt(secondIntStr[1]));

            if (firstRange.start <= secondRange.start && secondRange.start <= firstRange.stop
                    || firstRange.start <= secondRange.stop && secondRange.stop <= firstRange.stop
                    || secondRange.start <= firstRange.start && firstRange.start <= secondRange.stop
                    || secondRange.start <= firstRange.stop && firstRange.stop <= secondRange.stop
            ) {
                count++;
            }
        }

        return count;
    }
}
