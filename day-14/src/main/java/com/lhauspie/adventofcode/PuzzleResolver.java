package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Cave;
import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.SandSource;
import com.lhauspie.adventofcode.model.SandUnit;

import java.util.Scanner;

public class PuzzleResolver {

    public static int resolveFirstPuzzle(Scanner scanner) {
        Cave cave = CaveParser.parseCave(scanner, new SandSource(Position.of(500, 0)));
        simulateSandUnitsFallDown(cave);
        return cave.getNumberOfRestingSandUnits();
    }

    public static int resolveSecondPuzzle(Scanner scanner) {
        Cave cave = CaveParser.parseCave(scanner, new SandSource(Position.of(500, 0)));
        cave.addFloor();
        simulateSandUnitsFallDown(cave);
        return cave.getNumberOfRestingSandUnits();
    }

    private static void simulateSandUnitsFallDown(Cave cave) {
        SandUnit sandUnit;
        do {
            sandUnit = cave.getSandSource().produceSandUnit();
            fallSandUnitDownUntilItCantContinueToMove(sandUnit, cave);
        } while (!simulationIsDone(sandUnit, cave));
        cave.render(sandUnit);
    }


    private static void fallSandUnitDownUntilItCantContinueToMove(SandUnit sandUnit, Cave cave) {
        do {
            fallSandUnitOneStepDownOnInCave(sandUnit, cave);
        } while (sandUnitCanContinueToFallDownInTheCave(sandUnit, cave));
        if (sandUnit.isResting()) {
            cave.addRestingSandUnit(sandUnit);
        }
    }

    private static boolean sandUnitCanContinueToFallDownInTheCave(SandUnit sandUnit, Cave cave) {
        return !cave.sandUnitIsFallingIntoAbyss(sandUnit) && !sandUnit.isResting() && !cave.sandSourceIsBlockedBy(sandUnit);
    }

    private static void fallSandUnitOneStepDownOnInCave(SandUnit sandUnit, Cave cave) {
        Position down = sandUnit.getPosition().down();
        Position downLeft = down.left();
        Position downRight = down.right();
        if (cave.isFree(down)) {
            sandUnit.setPosition(down);
        } else if (cave.isFree(downLeft)) {
            sandUnit.setPosition(downLeft);
        } else if (cave.isFree(downRight)) {
            sandUnit.setPosition(downRight);
        } else {
            sandUnit.rest();
        }
    }

    private static boolean simulationIsDone(SandUnit sandUnit, Cave cave) {
        return cave.sandUnitIsFallingIntoAbyss(sandUnit) || cave.sandSourceIsBlockedBy(sandUnit);
    }
}
