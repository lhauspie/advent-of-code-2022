package com.lhauspie.adventofcode.model;

import java.util.Objects;

public class Size {
    private int value;

    private Size(int value) {
        this.value = value;
    }

    public static Size of(int value) {
        return new Size(value);
    }

    public Size sum(Size size) {
        return new Size(this.getValue() + size.getValue());
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size position = (Size) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean lessOrEqualsThan(Size maxSize) {
        return getValue() <= maxSize.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public Size sub(Size size) {
        return Size.of(this.getValue() - size.getValue());
    }
}
