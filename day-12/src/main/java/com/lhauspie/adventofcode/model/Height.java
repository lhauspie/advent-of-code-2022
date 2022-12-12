package com.lhauspie.adventofcode.model;

public class Height {
    private int value;

    private Height(int value) {
        this.value = value;
    }

    public static Height of(int value) {
        return new Height(value);
    }

    public boolean isLowerThan(Height height) {
        return this.value < height.value;
    }
}
