package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.EmptyBoatException;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws EmptyBoatException {
        InputStream puzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("First puzzle result : " + PuzzleResolver.resolveFirstPuzzle(new Scanner(puzzleInput)).getValue());

        InputStream puzzleInput = ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
        System.out.println("Second puzzle result : " + PuzzleResolver.resolveSecondPuzzle(new Scanner(puzzleInput)).getValue());
    }
}
