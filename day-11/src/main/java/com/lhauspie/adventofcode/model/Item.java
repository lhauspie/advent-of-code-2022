package com.lhauspie.adventofcode.model;

public class Item {
    private long worryLevel;

    public Item(long worryLevel) {
        this.worryLevel = worryLevel;
    }

    public void inspect() {
        worryLevel = worryLevel / 3L;
    }

    public void setWorryLevel(long worryLevel) {
        this.worryLevel = worryLevel;
    }

    public long getWorryLevel() {
        return worryLevel;
    }
}
