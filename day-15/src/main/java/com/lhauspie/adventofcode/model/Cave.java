package com.lhauspie.adventofcode.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cave {
    Set<Sensor> sensors = new HashSet<>();
    Set<Position> positionsWithoutBeacon = new HashSet<>();

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public long getNumberOfPositionsWhereABeaconCannotBePresent(int y) {
        Set<Sensor> enoughNearSensors = giveSensorsForWhichYIsInManhattanDistance(y);
        enoughNearSensors.stream().forEach(sensor -> positionsWithoutBeacon.addAll(getPositionsWhereABeaconCannotBePresentForOneSensor(y, sensor)));
        return positionsWithoutBeacon.size();
    }

    private Set<Position> getPositionsWhereABeaconCannotBePresentForOneSensor(int y, Sensor sensor) {
        Set<Position> exploredPositions = new HashSet<>();

        int manhattanDistance = sensor.getManhattanDistanceToBeacon();
        int yDistance = getYDistanceExcludingBothPoints(sensor, y);
        if (manhattanDistance < yDistance) {
            return exploredPositions;
        }

        int width = manhattanDistance - yDistance;

        for (int x = sensor.getPosition().getX() - width; x <= sensor.getPosition().getX() + width; x++) {
            exploredPositions.add(Position.of(x, y));
        }

        exploredPositions.remove(sensor.getBeaconPosition());
        return exploredPositions;
    }

    private int getNumberOfPositionsWhereABeaconCannotBePresentForOneSensor(int y, Sensor sensor) {
        int manhattanDistance = sensor.getManhattanDistanceToBeacon();
        int yDistance = getYDistanceExcludingBothPoints(sensor, y);
        if (manhattanDistance < yDistance) {
            return 0;
        }
        return (manhattanDistance - yDistance) * 2 + (sensor.getBeaconPosition().getY() == y ? 0 : 1);
    }

    public Set<Sensor> giveSensorsForWhichYIsInManhattanDistance(int y) {
        return sensors.stream()
                .filter(sensor -> sensor.getManhattanDistanceToBeacon() >= getYDistanceExcludingBothPoints(sensor, y))
                .collect(Collectors.toSet());
    }

    private int getYDistanceExcludingBothPoints(Sensor sensor, int y) {
        return Math.abs(sensor.getPosition().getY() - y);
    }
}
