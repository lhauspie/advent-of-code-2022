package com.lhauspie.adventofcode.day11;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream firstPuzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("First puzzle result : " + PuzzleResolver.resolveFirstPuzzle(new Scanner(firstPuzzleInput)));

        InputStream secondPuzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("Second puzzle result : " + PuzzleResolver.resolveSecondPuzzle(new Scanner(secondPuzzleInput)));
    }
}
