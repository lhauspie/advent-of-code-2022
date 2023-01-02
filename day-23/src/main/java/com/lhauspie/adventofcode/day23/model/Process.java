package com.lhauspie.adventofcode.day23.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Process {
    private static PositionFactory positionFactory = PositionFactory.getInstance();

    private Map<Position, Elf> elves = new HashMap<>();
    private Direction firstDirectionToConsider = Direction.NORTH;

    public void add(Elf elf) {
        elves.put(elf.getPosition(), elf);
    }

    public void simulate(int nbRounds) {
        for (int i = 0; i < nbRounds; i++) {
            simulateOneRoundAndGetNumberOfElvesWhoMovedDuringTheRound();
        }
    }

    public int simulateUntilNoElfMoves() {
        int roundNumber = 1;
        while (simulateOneRoundAndGetNumberOfElvesWhoMovedDuringTheRound() > 0) {
            roundNumber++;
        }
        return roundNumber;
    }

    private int simulateOneRoundAndGetNumberOfElvesWhoMovedDuringTheRound() {
        int numberOfElvesWhoMoved = 0;
        Map<Position, Elf> elves = new HashMap<>();
        for (Elf elf : this.elves.values()) {
            elf.chooseNextPosition(getNeighboursOf(elf), firstDirectionToConsider);
        }
        for (Elf elf : this.elves.values()) {
            elf.cancelMoveIfCollision(getElvesWhoCouldChooseSameNextPositionThan(elf));
        }
        for (Elf elf : this.elves.values()) {
            if (elf.move()) {
                numberOfElvesWhoMoved++;
            }
            elves.put(elf.getPosition(), elf);
        }
        this.elves = elves;
        firstDirectionToConsider = firstDirectionToConsider.next();
        return numberOfElvesWhoMoved;
    }

    private List<Elf> getElvesWhoCouldChooseSameNextPositionThan(Elf elf) {
        return Stream.of(
                positionFactory.create(elf.getPosition().getX(), elf.getPosition().getY() - 2),
                positionFactory.create(elf.getPosition().getX(), elf.getPosition().getY() + 2),
                positionFactory.create(elf.getPosition().getX() - 2, elf.getPosition().getY()),
                positionFactory.create(elf.getPosition().getX() + 2, elf.getPosition().getY())
                )
                .filter(position -> elves.containsKey(position))
                .map(position -> elves.get(position))
                .collect(Collectors.toList());
    }

    private List<Elf> getNeighboursOf(Elf elf) {
        return Stream.of(
                positionFactory.upLeft(elf.getPosition()),
                positionFactory.up(elf.getPosition()),
                positionFactory.upRight(elf.getPosition()),
                positionFactory.right(elf.getPosition()),
                positionFactory.downRight(elf.getPosition()),
                positionFactory.down(elf.getPosition()),
                positionFactory.downLeft(elf.getPosition()),
                positionFactory.left(elf.getPosition())
                )
                .filter(position -> elves.containsKey(position))
                .map(position -> elves.get(position))
                .collect(Collectors.toList());
    }

    public Position getMinPosition() {
        long minX = elves.keySet().stream().mapToLong(Position::getX).min().getAsLong();
        long minY = elves.keySet().stream().mapToLong(Position::getY).min().getAsLong();
        return positionFactory.create(minX, minY);
    }

    public Position getMaxPosition() {
        long maxX = elves.keySet().stream().mapToLong(Position::getX).max().getAsLong();
        long maxY = elves.keySet().stream().mapToLong(Position::getY).max().getAsLong();
        return positionFactory.create(maxX, maxY);
    }

    public long getNbElves() {
        return elves.size();
    }

    public void render() {
        Position minPosition = getMinPosition();
        Position maxPosition = getMaxPosition();

        for (long y = minPosition.getY(); y <= maxPosition.getY(); y++) {
            for (long x = minPosition.getX(); x <= maxPosition.getX(); x++) {
                System.out.print(elves.containsKey(positionFactory.create(x, y)) ? '#' : '.');
            }
            System.out.println();
        }
    }
}
