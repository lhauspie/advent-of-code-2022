package com.lhauspie.adventofcode.day15.model;

public class Sensor {
    private Position position;
    private Position beaconPosition;
    private int manhattanDistance;

    public Sensor(Position position, Position beaconPosition) {
        this.position = position;
        this.beaconPosition = beaconPosition;
        this.manhattanDistance = position.getManhattanDistanceTo(beaconPosition);
    }

    public Position getPosition() {
        return position;
    }

    public Position getBeaconPosition() {
        return beaconPosition;
    }

    public int getManhattanDistanceToBeacon() {
        return manhattanDistance;
    }

    public boolean coverThePosition(Position position) {
        return getManhattanDistanceToBeacon() >= getPosition().getManhattanDistanceTo(position);
    }

    public boolean coverThePosition(int x, int y) {
        return getManhattanDistanceToBeacon() >= getPosition().getManhattanDistanceTo(x, y);
    }

    public Position getFirstUpUncoveredPosition() {
        return new Position(position.getX(), position.getY() - getManhattanDistanceToBeacon() - 1);
    }

    public Position getFirstDownUncoveredPosition() {
        return new Position(position.getX(), position.getY() + getManhattanDistanceToBeacon() + 1);
    }

    public Position getFirstLeftUncoveredPosition() {
        return new Position(position.getX() - getManhattanDistanceToBeacon() - 1, position.getY());
    }

    public Position getFirstRightUncoveredPosition() {
        return new Position(position.getX() + getManhattanDistanceToBeacon() + 1, position.getY());
    }
}
