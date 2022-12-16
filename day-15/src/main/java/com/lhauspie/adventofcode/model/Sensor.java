package com.lhauspie.adventofcode.model;

public class Sensor {
    private Position position;
    private Position beaconPosition;

    public Sensor(Position position, Position beaconPosition) {
        this.position = position;
        this.beaconPosition = beaconPosition;
    }

    public Position getPosition() {
        return position;
    }

    public Position getBeaconPosition() {
        return beaconPosition;
    }
}
