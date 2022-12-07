package com.lhauspie.adventofcode.model.v2.marker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StartOfPacketMarkerTest {

    @Test
    public void tooShortInputShouldThrowInvalidMarkerException() {
        assertThrows(InvalidMarkerException.class, () -> new StartOfPacketMarker("a"));
    }

    @Test
    public void tooLongInputShouldThrowInvalidMarkerException() {
        assertThrows(InvalidMarkerException.class, () -> new StartOfPacketMarker("aszertyuio"));
    }

    @Test
    public void goodSizeButDuplicateCharsShouldThrowInvalidMarkerException() {
        assertThrows(InvalidMarkerException.class, () -> new StartOfPacketMarker("aapo"));
    }

    @Test
    public void goodSizeWithoutDuplicateCharsShouldNotThrowAnyException() {
        assertDoesNotThrow(() -> new StartOfPacketMarker("abpo"));
    }
}
