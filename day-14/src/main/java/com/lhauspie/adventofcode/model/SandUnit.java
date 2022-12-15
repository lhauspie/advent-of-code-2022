package com.lhauspie.adventofcode.model;

public class SandUnit {
    Position position;
    private boolean resting = false;

    public SandUnit(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void rest() {
        this.resting = true;
    }

    public boolean isResting() {
        return resting;
    }
}
