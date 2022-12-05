package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.adapter.InputReader;
import com.lhauspie.adventofcode.model.CrateMover;
import com.lhauspie.adventofcode.model.CrateMover9000;
import com.lhauspie.adventofcode.model.CrateMover9001;
import com.lhauspie.adventofcode.model.Ship;

import java.util.Scanner;

public class PuzzleResolver {

    public static String resolveFirstPuzzle(Scanner scanner) {
        Ship ship = getShip(scanner);
        executeMoves(new CrateMover9000(ship), scanner);
        return getCratesOnTopOfEachStackAsString(ship);
    }

    public static String resolveSecondPuzzle(Scanner scanner) {
        Ship ship = getShip(scanner);
        executeMoves(new CrateMover9001(ship), scanner);
        return getCratesOnTopOfEachStackAsString(ship);
    }

    private static void executeMoves(CrateMover mover, Scanner scanner) {
        while (scanner.hasNextLine()) {
            mover.execute(InputReader.inputMoveContentToMove(scanner.nextLine()));
        }
    }

    private static String getCratesOnTopOfEachStackAsString(Ship ship) {
        return ship.getCratesOnTopOfEachStack().stream()
                .map(crate -> crate.getMark())
                .reduce((s, s2) -> s + s2)
                .orElseThrow(() -> new IllegalStateException("No crates detected on top of any stack"));
    }

    private static Ship getShip(Scanner scanner) {
        String shipDescription = "";
        String nextLine = scanner.nextLine();
        while (!nextLine.isEmpty()) {
            shipDescription += nextLine;
            nextLine = scanner.nextLine();
            if (!nextLine.isEmpty()) {
                shipDescription += "\n";
            }
        }
        return InputReader.inputShipContentToShip(shipDescription);
    }
}
