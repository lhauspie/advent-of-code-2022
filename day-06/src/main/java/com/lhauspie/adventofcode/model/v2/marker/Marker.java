package com.lhauspie.adventofcode.model.v2.marker;

import java.util.HashSet;
import java.util.Set;

public abstract class Marker {
    private String value;

    public abstract int getMarkerSize();

    protected Marker(String value) throws InvalidMarkerException {
        if (value.length() != getMarkerSize()) {
            throw new InvalidMarkerException("length is not correct");
        }
        if (!isOnlyComposedOfDistinctChars(value)) {
            throw new InvalidMarkerException("there are duplicates characters");
        }
        this.value = value;
    }

    public boolean isOnlyComposedOfDistinctChars(String value) {
        Set<Character> metChars = new HashSet<>(26);
        for (int i = 0; i < getMarkerSize(); i++) {
            char c = value.charAt(i);
            if (metChars.contains(c)) {
                return false;
            }
            metChars.add(c);
        }
        return true;
    }
}
