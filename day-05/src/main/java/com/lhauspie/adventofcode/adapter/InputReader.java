package com.lhauspie.adventofcode.adapter;

import com.lhauspie.adventofcode.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {

    public static Ship inputShipContentToShip(String input) {
        char[][] charMatrix = toCharMatrix(input);
        
        var ship = new Ship();
        char[] lastLine = charMatrix[charMatrix.length - 1];
        for (int charIndex = 0; charIndex < lastLine.length; charIndex++) {
            if (lastLine[charIndex] != ' ') {
                Position currentPosition = Position.of(Integer.parseInt("" + lastLine[charIndex]));
                // read column from bottom to top
                for (int lineIndex = charMatrix.length - 2;
                         lineIndex >= 0 && charMatrix[lineIndex][charIndex] != ' ';
                         lineIndex--
                ) {
                    ship.store(MarkedCrate.of("" + charMatrix[lineIndex][charIndex]), currentPosition);
                }
            }
        }

        return ship;
    }

    public static Move inputMoveContentToMove(String inputMoveContent) {
        Pattern movePattern = Pattern.compile("move ([0-9]+) from ([0-9]+) to ([0-9]+)");
        Matcher moveMatcher = movePattern.matcher(inputMoveContent);
        moveMatcher.find();
        return new Move(
                Quantity.of(Integer.parseInt(moveMatcher.group(1))),
                Position.of(Integer.parseInt(moveMatcher.group(2))),
                Position.of(Integer.parseInt(moveMatcher.group(3)))
        );
    }

    private static char[][] toCharMatrix(String input) {
        List<String> lines = fromStringWithCarriageReturnToListOfString(input);
        int nbLines = lines.size();
        String lastLine = lines.get(nbLines - 1);
        char[][] matrix = initBlankMatrix(nbLines, lastLine.length() + 1);
        for (int lineIndex = 0; lineIndex < nbLines; lineIndex++) {
            String currentLine = lines.get(lineIndex);
            for (int charIndex = 0; charIndex < currentLine.length(); charIndex++) {
                matrix[lineIndex][charIndex] = currentLine.charAt(charIndex);
            }
        }
        return matrix;
    }

    private static List<String> fromStringWithCarriageReturnToListOfString(String input) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new StringReader(input))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException exc) {
            // quit
        }
        return lines;
    }

    private static char[][] initBlankMatrix(int nbRows, int nbCols) {
        char[][] matrix = new char[nbRows][nbCols];
        for (int rowIndex = 0; rowIndex < nbRows; rowIndex++) {
            for (int colIndex = 0; colIndex < nbCols; colIndex++) {
                matrix[rowIndex][colIndex] = ' ';
            }
        }
        return matrix;
    }
}
