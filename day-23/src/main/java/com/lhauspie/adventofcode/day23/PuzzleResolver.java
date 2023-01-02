package com.lhauspie.adventofcode.day23;

import com.lhauspie.adventofcode.day23.model.Elf;
import com.lhauspie.adventofcode.day23.model.Position;
import com.lhauspie.adventofcode.day23.model.PositionFactory;
import com.lhauspie.adventofcode.day23.model.Process;

import java.util.Scanner;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner) {
        Process process = parseInput(scanner);

        process.simulate(10);

        Position maxPosition = process.getMaxPosition();
        Position minPosition = process.getMinPosition();
        long nbEmptyGroundTiles = (maxPosition.getX() - minPosition.getX() + 1)
                * (maxPosition.getY() - minPosition.getY() + 1)
                - process.getNbElves();

        return nbEmptyGroundTiles;
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        Process process = parseInput(scanner);
        return process.simulateUntilNoElfMoves();
    }

    private static Process parseInput(Scanner scanner) {
        Process process = new Process();
        int y = 0;
        while (scanner.hasNextLine()) {
            int x = 0;
            for (char c: scanner.nextLine().toCharArray()) {
                if (c == '#') {
                    process.add(new Elf(PositionFactory.getInstance().create(x, y)));
                }
                x++;
            }
            y++;
        }
        return process;
    }
}
