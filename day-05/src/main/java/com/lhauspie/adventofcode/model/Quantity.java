package com.lhauspie.adventofcode.model;

public class Quantity {
    private int value;

    private Quantity(int value) {
        this.value = value;
    }

    public static Quantity of(int value) {
        return new Quantity(value);
    }

    public int getValue() {
        return value;
    }
}
