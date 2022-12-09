package com.lhauspie.adventofcode.model.grid;

import java.util.Objects;

public class Row {
    private int value;

    private Row(int value) {
        this.value = value;
    }

    public static Row of(int value) {
        return new Row(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return value == row.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }

    public Row bottom() {
        return Row.of(getValue() + 1);
    }

    public Row top() {
        return Row.of(getValue() - 1);
    }

    @Override
    public String toString() {
        return "Row{" + value + '}';
    }
}
