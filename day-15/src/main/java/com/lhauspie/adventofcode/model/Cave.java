package com.lhauspie.adventofcode.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cave {
    Set<Sensor> sensors = new HashSet<>();
    Set<Position> exploredPositions = new HashSet<>();

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public void explore() {
        sensors.forEach(sensor -> {
            exploredPositions.addAll(exploreAndGetExploredPositions(sensor));
        });
    }

    private Set<Position> exploreAndGetExploredPositions(Sensor sensor) {
        Set<Position> exploredPositionsForThisExploration = new HashSet<>();
        if (!sensor.getPosition().equals(sensor.getBeaconPosition())) {
            exploredPositionsForThisExploration.add(sensor.getPosition());
        }
        while (!beaconFound(sensor, exploredPositionsForThisExploration)) {
            exploreInDiamond(exploredPositionsForThisExploration);
        }
        exploredPositionsForThisExploration.remove(sensor.getBeaconPosition());

        return exploredPositionsForThisExploration;
    }

    private void exploreInDiamond(Set<Position> exploredPositionsForThisExploration) {
        for (Position exploredPosition : exploredPositionsForThisExploration.stream().toList()) {
            exploredPositionsForThisExploration.add(exploredPosition.down());
            exploredPositionsForThisExploration.add(exploredPosition.left());
            exploredPositionsForThisExploration.add(exploredPosition.right());
            exploredPositionsForThisExploration.add(exploredPosition.up());
        }
    }

    private boolean beaconFound(Sensor sensor, Set<Position> exploredPositionsForThisExploration) {
        return exploredPositionsForThisExploration.contains(sensor.getBeaconPosition());
    }

    public long getNumberOfPositionsWhereABeaconCannotBePresent(int y) {
        return exploredPositions.stream().filter(position -> position.getY() == y).count();
    }

    public void render() {
        Set<Position> sensorsPositions = sensors.stream().map(Sensor::getPosition).collect(Collectors.toSet());
        Set<Position> beaconsPositions = sensors.stream().map(Sensor::getBeaconPosition).collect(Collectors.toSet());
        for (int y = -100; y <= 100; y++) {
            for (int x = -100; x <= 100; x++) {
                Position position = Position.of(x, y);
                if (sensorsPositions.contains(position)) {
                    System.out.print('S');
                } else if (beaconsPositions.contains(position)) {
                    System.out.print('B');
                } else if (exploredPositions.contains(position)) {
                    System.out.print('#');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
        System.out.println("================================");
    }
}
