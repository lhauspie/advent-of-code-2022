package com.lhauspie.adventofcode;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream firstPuzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("First puzzle result : " + PuzzleResolver.resolveFirstPuzzle(new Scanner(firstPuzzleInput)));

        InputStream secondPuzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("Second puzzle result : \n" + PuzzleResolver.resolveSecondPuzzle(new Scanner(secondPuzzleInput)));
    }
}
