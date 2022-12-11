package com.lhauspie.adventofcode.model;

public abstract class Item {
    private long worryLevel;

    public Item(long worryLevel) {
        this.worryLevel = worryLevel;
    }

    abstract public void inspect();

    public void setWorryLevel(long worryLevel) {
        this.worryLevel = worryLevel;
    }

    public long getWorryLevel() {
        return worryLevel;
    }
}
