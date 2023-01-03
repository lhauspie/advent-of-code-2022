package com.lhauspie.adventofcode.day16;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("First puzzle result : " + resolveFirstPuzzle());
        System.out.println("Second puzzle result : " + resolveSecondPuzzle());
    }

    public static int resolveFirstPuzzle() {
        InputStream puzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        return PuzzleResolver.resolveFirstPuzzle(new Scanner(puzzleInput));
    }

    public static int resolveSecondPuzzle() {
        InputStream puzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        return PuzzleResolver.resolveSecondPuzzle(new Scanner(puzzleInput));
    }
}
