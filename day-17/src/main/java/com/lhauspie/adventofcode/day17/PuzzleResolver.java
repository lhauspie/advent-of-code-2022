package com.lhauspie.adventofcode.day17;

import com.lhauspie.adventofcode.day17.model.MutablePosition;
import com.lhauspie.adventofcode.day17.model.VerticalChamber;
import com.lhauspie.adventofcode.day17.model.move.Move;
import com.lhauspie.adventofcode.day17.model.move.MoveFactory;
import com.lhauspie.adventofcode.day17.model.rock.Rock;
import com.lhauspie.adventofcode.day17.model.rock.RockFactory;

import java.util.*;
import java.util.stream.Collectors;

public class PuzzleResolver {

    public record Counts(long fallenRocksCount, long towerTall) {}

    public static long resolveFirstPuzzle(Scanner scanner) {
        VerticalChamber verticalChamber = new VerticalChamber(7);
        MoveFactory moveFactory = new MoveFactory(scanner.nextLine());
        RockFactory rockFactory = new RockFactory();

        long numberOfRocksToBeFallen = 2022;
        long fallenRocksCount = 0;
        while (fallenRocksCount < numberOfRocksToBeFallen) {
            fallDownNewRockUntilRest(verticalChamber, rockFactory, moveFactory);
            fallenRocksCount++;
        }
        return verticalChamber.getTowerTall();
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        VerticalChamber verticalChamber = new VerticalChamber(7);
        MoveFactory moveFactory = new MoveFactory(scanner.nextLine());
        RockFactory rockFactory = new RockFactory();

        boolean loopDetected = false;
        long towerTallDifferenceForAllLoops = 0;
        Map<String, Counts> previousTowerTopographies = new HashMap<>();
        long numberOfRocksToBeFallen = 1000000000000L;
        long fallenRocksCount = 0;
        while (fallenRocksCount < numberOfRocksToBeFallen) {
            fallDownNewRockUntilRest(verticalChamber, rockFactory, moveFactory);
            fallenRocksCount++;

            // If the loop has already been found, stop trying to find the loop
            if (!loopDetected) {
                String currentTowerTopography = getTowerTopographyFromTopAsString(verticalChamber, 30);
                Counts currentCounts = new Counts(fallenRocksCount, verticalChamber.getTowerTall());
                if (previousTowerTopographies.containsKey(currentTowerTopography)) {
                    loopDetected = true;
                    Counts previousCounts = previousTowerTopographies.get(currentTowerTopography);
                    long towerTallDifferenceForOneLoop = currentCounts.towerTall - previousCounts.towerTall;
                    long numberOfFallenRocksForOneLoop = currentCounts.fallenRocksCount - previousCounts.fallenRocksCount;
                    long numberOfRocksToBeFallenToReachTheEnd = numberOfRocksToBeFallen - fallenRocksCount;
                    long numberOfLoopsToBeSimulated = numberOfRocksToBeFallenToReachTheEnd / numberOfFallenRocksForOneLoop;

                    towerTallDifferenceForAllLoops = numberOfLoopsToBeSimulated * towerTallDifferenceForOneLoop;

                    // Jump to last loop
                    fallenRocksCount = fallenRocksCount + numberOfLoopsToBeSimulated * numberOfFallenRocksForOneLoop;
                }
                previousTowerTopographies.put(currentTowerTopography, currentCounts);
            }
        }

        return verticalChamber.getTowerTall() + towerTallDifferenceForAllLoops;
    }

    // This method allows to get the N higher lines of the tower as a String
    // |.#....|  Cross           at 0,0
    // |###...|  Horizontal Line at 2,0
    // |.#####|
    // |______|
    // Will return "|.#....||###...||.#####|" this is a kind of signature of the topography of the tower
    private static String getTowerTopographyFromTopAsString(VerticalChamber verticalChamber, int numberHighestLinesOfTowerToWatch) {
        Set<MutablePosition> towerTopography = verticalChamber.getRestingRocksPositions().stream()
                .filter(p -> p.getY() > verticalChamber.getTowerTall() - numberHighestLinesOfTowerToWatch)
                .map(p -> MutablePosition.of(p.getX(), p.getY() - verticalChamber.getTowerTall() + numberHighestLinesOfTowerToWatch))
                .collect(Collectors.toSet());

        StringBuilder stringBuilder = new StringBuilder();
        for (int y = numberHighestLinesOfTowerToWatch - 1; y > 0; y--) {
            stringBuilder.append('|');
            for (int x = 0; x < verticalChamber.getWidth(); x++) {
                stringBuilder.append(towerTopography.contains(MutablePosition.of(x, y)) ? '#' : '.');
            }
            stringBuilder.append('|');
        }

        return stringBuilder.toString();
    }

    private static void fallDownNewRockUntilRest(VerticalChamber verticalChamber, RockFactory rockFactory, MoveFactory moveFactory) {
        Rock rock = rockFactory.createRock(2, verticalChamber.getHighestPosition().getY() + 4);
        boolean rockIsResting = false;
        while (!rockIsResting) {
            Move move = moveFactory.nextMove();
            if (move.equals(Move.RIGHT)) {
                verticalChamber.moveRightIfPossible(rock);
            }
            if (move.equals(Move.LEFT)) {
                verticalChamber.moveLeftIfPossible(rock);
            }
            rockIsResting = !verticalChamber.moveDownIfPossible(rock);
        }
    }
}