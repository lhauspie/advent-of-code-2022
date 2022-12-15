package com.lhauspie.adventofcode.model;

public class SandSource {
    Position position;

    public SandSource(Position position) {
        this.position = position;
    }

    public SandUnit produceSandUnit() {
        return new SandUnit(position);
    }

    public Position getPosition() {
        return position;
    }

    public boolean isBlockedBy(SandUnit sandUnit) {
        return position.equals(sandUnit.getPosition());
    }
}
