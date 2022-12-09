package com.lhauspie.adventofcode.model;

public class ViewingDistance {
    private int value;

    private ViewingDistance(int value) {
        this.value = value;
    }

    public static ViewingDistance of(int value) {
        return new ViewingDistance(value);
    }

    public int getValue() {
        return value;
    }
}
