package com.lhauspie.adventofcode.model;

import java.util.Objects;

public class Quantity implements Comparable<Quantity> {
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

    public Quantity add(Quantity quantity) {
        return Quantity.of(this.getValue() + quantity.getValue());
    }

    public boolean moreThan(Quantity quantity) {
        return this.getValue() > quantity.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return value == quantity.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Quantity o) {
        return Integer.compare(this.getValue(), o.getValue());
    }
}
