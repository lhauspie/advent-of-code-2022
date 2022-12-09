package com.lhauspie.adventofcode.model;

import java.util.Arrays;
import java.util.Objects;

public class ScenicScore {
    private int value;

    private ScenicScore(int value) {
        this.value = value;
    }

    public static ScenicScore of(int value) {
        return new ScenicScore(value);
    }

    public static ScenicScore of(ViewingDistance... viewingDistances) {
        return Arrays.stream(viewingDistances)
                .map(viewingDistance -> viewingDistance.getValue())
                .reduce((integer, integer2) -> integer * integer2)
                .map(ScenicScore::new)
                .orElse(new ScenicScore(0));
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScenicScore that = (ScenicScore) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ScenicScore{" +
                "value=" + value +
                '}';
    }
}
