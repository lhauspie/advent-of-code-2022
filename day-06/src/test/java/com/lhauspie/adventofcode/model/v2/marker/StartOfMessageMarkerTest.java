package com.lhauspie.adventofcode.model.v2.marker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StartOfMessageMarkerTest {

    @Test
    public void tooShortInputShouldThrowInvalidMarkerException() {
        assertThrows(InvalidMarkerException.class, () -> new StartOfMessageMarker("a"));
    }

    @Test
    public void tooLongInputShouldThrowInvalidMarkerException() {
        assertThrows(InvalidMarkerException.class, () -> new StartOfMessageMarker("aszertyuiopmlknbvnbv"));
    }

    @Test
    public void goodSizeButDuplicateCharsShouldThrowInvalidMarkerException() {
        assertThrows(InvalidMarkerException.class, () -> new StartOfMessageMarker("aapoiuytrezsdf"));
    }

    @Test
    public void goodSizeWithoutDuplicateCharsShouldNotThrowAnyException() {
        assertDoesNotThrow(() -> new StartOfMessageMarker("abpoiuytrezsdf"));
    }
}
