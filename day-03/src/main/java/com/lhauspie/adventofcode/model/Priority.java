package com.lhauspie.adventofcode.model;

import java.util.Objects;

public class Priority {

    private int value;

    public Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return value == priority.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
