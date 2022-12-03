package com.lhauspie.adventofcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

    @Test
    public void scannerShouldBeAbleToReadInputFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/test/resources/input_test.txt"));
        Assertions.assertEquals(scanner.nextInt(), 7569);
    }
}
