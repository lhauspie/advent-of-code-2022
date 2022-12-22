package com.lhauspie.adventofcode.day21.model;

public class ValueMonkey implements Monkey {
    private String id;
    private long value;

    public ValueMonkey(String id, Long value) {
        this.id = id;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public String getId() {
        return id;
    }
}
