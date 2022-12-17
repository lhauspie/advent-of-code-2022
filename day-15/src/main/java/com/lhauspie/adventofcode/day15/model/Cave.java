package com.lhauspie.adventofcode.day15.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cave {
    private List<Sensor> sensors = new ArrayList<>();
    private final Position topLeftCorner;
    private final Position bottomRightCorner;

    public Cave(Position topLeftCorner, Position bottomRightCorner) {
        this.topLeftCorner = topLeftCorner;
        this.bottomRightCorner = bottomRightCorner;
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public long getNumberOfPositionsWhereABeaconCannotBePresent(int y) {
        Set<Integer> xPositions = new HashSet<>();
        getSensorsForWhichYIsInManhattanDistance(y).forEach(sensor -> xPositions.addAll(getXPositionsWhereThereIsNoBeacon(y, sensor)));
        return xPositions.size();
    }

    public Position getTheOnlyPositionNotCoveredByAtLeastOneSensor() {
        return sensors.stream()
                .flatMap(this::getPositionsJustOutsideTheSensorPerimeterInsideTheCaveLimitAndNotCoveredByOtherSensors)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No uncovered position found"));
    }

    private Stream<Position> getPositionsJustOutsideTheSensorPerimeterInsideTheCaveLimitAndNotCoveredByOtherSensors(Sensor sensor) {
        return Stream.of(
                getPositionsOfDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(sensor.getFirstUpUncoveredPosition(), sensor.getFirstRightUncoveredPosition()),
                getPositionsOfDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(sensor.getFirstRightUncoveredPosition(), sensor.getFirstDownUncoveredPosition()),
                getPositionsOfDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(sensor.getFirstDownUncoveredPosition(), sensor.getFirstLeftUncoveredPosition()),
                getPositionsOfDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(sensor.getFirstLeftUncoveredPosition(), sensor.getFirstUpUncoveredPosition())
        ).flatMap(i -> i);
    }

    private Stream<Position> getPositionsOfDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(Position from, Position to) {
        List<Position> positionsOfDiagonal = new ArrayList<>();
        if (diagonalIsFromTopLeftToBottomRightDirection(from, to)) {
            positionsOfDiagonal.addAll(getPositionsOfTopLeftToBottomRightDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(from, to));
        } else {
            positionsOfDiagonal.addAll(getPositionsOfTopRightToBottomLeftDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(from, to));
        }
        return positionsOfDiagonal.stream();
    }

    private List<Position> getPositionsOfTopLeftToBottomRightDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(Position from, Position to) {
        List<Position> positionsOfDiagonal = new ArrayList<>();
        int startY = Math.min(from.getY(), to.getY())    ;
        int endY =   Math.max(from.getY(), to.getY()) + 1;
        int startX = Math.min(from.getX(), to.getX())    ;
        int endX =   Math.max(from.getX(), to.getX()) + 1;

        int y = startY;
        int x = startX;
        while (x < endX && y < endY) {
            if (positionIsInsideTheCave(x, y) && noSensorCoversThisPosition(x, y)) {
                positionsOfDiagonal.add(Position.of(x, y));
            }
            x++; y++;
        }
        return positionsOfDiagonal;
    }

    private List<Position> getPositionsOfTopRightToBottomLeftDiagonalInsideTheCaveLimitAndNotCoveredByOtherSensors(Position from, Position to) {
        List<Position> positionsOfDiagonal = new ArrayList<>();
        int startY = Math.min(from.getY(), to.getY())    ;
        int endY =   Math.max(from.getY(), to.getY()) + 1;
        int startX = Math.max(from.getX(), to.getX())    ;
        int endX =   Math.min(from.getX(), to.getX()) + 1;

        int y = startY;
        int x = startX;
        while (x > endX && y < endY) {
            if (positionIsInsideTheCave(x, y) && noSensorCoversThisPosition(x, y)) {
                positionsOfDiagonal.add(Position.of(x, y));
            }
            x--; y++;
        }
        return positionsOfDiagonal;
    }

    private boolean positionIsInsideTheCave(int x, int y) {
        return topLeftCorner.getX() <= x && x <= bottomRightCorner.getX() && topLeftCorner.getY() <= y && y <= bottomRightCorner.getY();
    }

    private boolean diagonalIsFromTopLeftToBottomRightDirection(Position from, Position to) {
        return from.getX() > to.getX() && from.getY() > to.getY()
            || from.getX() < to.getX() && from.getY() < to.getY();
    }

    private boolean noSensorCoversThisPosition(int finalX, int finalY) {
        return sensors.stream().noneMatch(s -> s.coverThePosition(finalX, finalY));
    }

    private Set<Integer> getXPositionsWhereThereIsNoBeacon(int y, Sensor sensor) {
        Set<Integer> xPositions = new HashSet<>();

        int manhattanDistance = sensor.getManhattanDistanceToBeacon();
        int yDistance = getYDistanceExcludingBothPoints(sensor, y);
        if (manhattanDistance < yDistance) {
            return xPositions;
        }

        int width = manhattanDistance - yDistance;
        for (int x = sensor.getPosition().getX() - width; x <= sensor.getPosition().getX() + width; x++) {
            xPositions.add(x);
        }
        if (sensor.getBeaconPosition().getY() == y) {
            xPositions.remove(sensor.getBeaconPosition().getX());
        }
        return xPositions;
    }

    private Set<Sensor> getSensorsForWhichYIsInManhattanDistance(int y) {
        return sensors.stream()
                .filter(sensor -> sensor.getManhattanDistanceToBeacon() >= getYDistanceExcludingBothPoints(sensor, y))
                .collect(Collectors.toSet());
    }

    private int getYDistanceExcludingBothPoints(Sensor sensor, int y) {
        return Math.abs(sensor.getPosition().getY() - y);
    }
}
