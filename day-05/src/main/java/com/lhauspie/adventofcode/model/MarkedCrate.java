package com.lhauspie.adventofcode.model;

public class MarkedCrate {
    private String mark;

    private MarkedCrate(String mark) {
        this.mark = mark;
    }

    public static MarkedCrate of(String value) {
        return new MarkedCrate(value);
    }

    public String getMark() {
        return mark;
    }
}
