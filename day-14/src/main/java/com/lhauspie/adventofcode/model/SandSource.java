package com.lhauspie.adventofcode.model;

public class SandSource {
    Position position;

    public SandSource(Position position) {
        this.position = position;
    }

    public SandUnit newSandUnit() {
        return new SandUnit(position);
    }

    public Position getPosition() {
        return position;
    }
}
