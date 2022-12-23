package com.lhauspie.adventofcode.day22;

import com.lhauspie.adventofcode.day22.model.*;

import java.util.Scanner;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner) {
        Board board = parseBoard(scanner);
        BoardExplorer explorer = new BoardExplorer(board);

        String movementInstructions = scanner.nextLine();
        executeMovementInstructions(explorer, movementInstructions);

        return 1000 * explorer.getCurrentTile().getPosition().getY()
                + 4 * explorer.getCurrentTile().getPosition().getX()
                + explorer.getFacing().getValue();
    }

    private static void executeMovementInstructions(Explorer explorer, String movementInstructions) {
        String[] turnInstructions = movementInstructions.split("[0-9]+");
        String[] moveInstructions = movementInstructions.split("[LR]");

        for (int i = 0; i < turnInstructions.length; i++) {
            turn(explorer, turnInstructions[i]);
            move(explorer, Integer.parseInt(moveInstructions[i]));
        }
    }

    private static void move(Explorer explorer, int times) {
        explorer.move(times);
    }

    private static void turn(Explorer explorer, String turnInstruction) {
        if (turnInstruction.equals("L")) {
            explorer.turnCounterclockwise();
        }
        if (turnInstruction.equals("R")) {
            explorer.turnClockwise();
        }
    }

    public static long resolveSecondPuzzle(Scanner scanner, int cubeSize) {
        Cube cube = parseCube(scanner, cubeSize);
        Explorer explorer = new CubeExplorer(cube);

        String movementInstructions = scanner.nextLine();
        executeMovementInstructions(explorer, movementInstructions);

        return 1000 * explorer.getCurrentTile().getPosition().getY()
                + 4 * explorer.getCurrentTile().getPosition().getX()
                + explorer.getFacing().getValue();
    }

    private static Board parseBoard(Scanner scanner) {
        var board = new Board();
        var nextLine = scanner.nextLine();

        int row = 1;
        while (!nextLine.isEmpty()) {
            int col = 1;
            char[] nextCharSequence = nextLine.toCharArray();
            for (int i = 0; i < nextCharSequence.length; i++) {
                if (nextCharSequence[i] != ' ') {
                    board.addTile(new Tile(Position.of(col, row), nextCharSequence[i] == '.'));
                }
                col++;
            }
            nextLine = scanner.nextLine();
            row++;
        }

        return board;
    }

    private static Cube parseCube(Scanner scanner, int cubeSize) {
        var cube = new Cube(cubeSize);
        var nextLine = scanner.nextLine();

        int row = 1;
        while (!nextLine.isEmpty()) {
            int col = 1;
            char[] nextCharSequence = nextLine.toCharArray();
            for (int i = 0; i < nextCharSequence.length; i++) {
                if (nextCharSequence[i] != ' ') {
                    cube.addTile(new Tile(Position.of(col, row), nextCharSequence[i] == '.'));
                }
                col++;
            }
            nextLine = scanner.nextLine();
            row++;
        }

        cube.consolidate();
        return cube;
    }

}
