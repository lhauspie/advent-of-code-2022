package com.lhauspie.adventofcode.day21.model;

import java.util.Objects;

public class MonkeyId {
    private String value;

    public MonkeyId(String value) {
        this.value = value;
    }

    public static MonkeyId of(String value) {
        return new MonkeyId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonkeyId monkeyId = (MonkeyId) o;
        return Objects.equals(value, monkeyId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
