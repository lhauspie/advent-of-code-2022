package com.lhauspie.adventofcode.day21.model;

public class ValueMonkey implements Monkey {
    private MonkeyId id;
    private long value;

    public ValueMonkey(MonkeyId id, Long value) {
        this.id = id;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public MonkeyId getId() {
        return id;
    }
}
