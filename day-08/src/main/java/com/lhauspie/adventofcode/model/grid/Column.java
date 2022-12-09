package com.lhauspie.adventofcode.model.grid;

import java.util.Objects;

public class Column {
    private int value;

    private Column(int value) {
        this.value = value;
    }

    public static Column of(int value) {
        return new Column(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return value == column.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }

    public Column right() {
        return Column.of(getValue() + 1);
    }

    public Column left() {
        return Column.of(getValue() - 1);
    }


    @Override
    public String toString() {
        return "Column{" + value + '}';
    }
}
