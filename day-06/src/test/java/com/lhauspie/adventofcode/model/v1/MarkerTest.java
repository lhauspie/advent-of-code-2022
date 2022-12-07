package com.lhauspie.adventofcode.model.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarkerTest {

    @Test
    public void markerInstantiationIsNotAllowedForOneChar() {
        assertThrows(IllegalArgumentException.class, () -> Marker.of("a"));
    }

    @Test
    public void markerInstantiationIsNotAllowedForTwoChars() {
        assertThrows(IllegalArgumentException.class, () -> Marker.of("ab"));
    }

    @Test
    public void markerInstantiationIsNotAllowedForThreeChars() {
        assertThrows(IllegalArgumentException.class, () -> Marker.of("abc"));
    }

    @Test
    public void markerInstantiationIsAllowedForFourChars() {
        assertDoesNotThrow(() -> Marker.of("abcd"));
    }

    @Test
    public void markerInstantiationIsAllowedForFiveChars() {
        assertThrows(IllegalArgumentException.class, () -> Marker.of("azert"));
    }

    @Test
    public void aaaaIsNotStartMarker() {
        assertFalse(Marker.of("aaaa").isStartOfPacketMarker());
    }

    @Test
    public void bbbbIsNotStartMarker() {
        assertFalse(Marker.of("bbbb").isStartOfPacketMarker());
    }

    @Test
    public void abcdIsStartMarker() {
        assertTrue(Marker.of("abcd").isStartOfPacketMarker());
    }
}
