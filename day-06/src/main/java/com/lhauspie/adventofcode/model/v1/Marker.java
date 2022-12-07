package com.lhauspie.adventofcode.model.v1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Marker {
    public static final int MARKER_SIZE = 4;
    private String value;

    public Marker(String value) {
        this.value = value;
    }

    public static Marker of(String value) {
        if (value.length() != MARKER_SIZE) {
            throw new IllegalArgumentException();
        }
        return new Marker(value);
    }

    public boolean isStartOfPacketMarker() {
        Set<Character> metChars = new HashSet<>(26);
        for (int i = 0; i < MARKER_SIZE; i++) {
            char c = value.charAt(i);
            if (metChars.contains(c)) {
                return false;
            }
            metChars.add(c);
        }
        return true;
    }

    private static boolean[] getOnlyUnmetChars() {
        boolean[] alreadyMetChars = new boolean[26];
        for (int i = 0; i < 26; i++) {
            alreadyMetChars[i] = false;
        }
        return alreadyMetChars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marker marker = (Marker) o;
        return Objects.equals(value, marker.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Marker{" +
                "value='" + value + '\'' +
                '}';
    }
}
