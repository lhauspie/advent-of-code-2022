package com.lhauspie.adventofcode.model;

import java.util.Objects;

public class Name {
    private String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name of(String value) {
        return new Name(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
