package com.lhauspie.adventofcode;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    InputStream firstPuzzleInput =
        ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
    System.out.println(
        "First puzzle result : "
            + PuzzleResolver.resolveFirstPuzzle(new Scanner(firstPuzzleInput)).getValue());

    InputStream secondPuzzleInput =
        ClassLoader.getSystemClassLoader().getResourceAsStream("input.txt");
    System.out.println(
        "Second puzzle result : "
            + PuzzleResolver.resolveSecondPuzzle(new Scanner(secondPuzzleInput)).getValue());
  }
}
