package com.lhauspie.adventofcode.model.v2.marker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MarkerFactoryTest {

    @Test
    public void buildingMarkerFromInputContainingOneCharShouldFail() {
        assertThrows(InvalidMarkerException.class, () -> MarkerFactory.buildMarkerFrom("a"));
    }

    @Test
    public void buildingMarkerFromInputContainingThreeCharsShouldFail() {
        assertThrows(InvalidMarkerException.class, () -> MarkerFactory.buildMarkerFrom("abc"));
    }

    @Test
    public void buildingMarkerFromInputContainingTenCharsShouldFail() {
        assertThrows(InvalidMarkerException.class, () -> MarkerFactory.buildMarkerFrom("a"));
    }

    @Test
    public void buildingMarkerFromInputContainingTwentyCharsShouldFail() {
        assertThrows(InvalidMarkerException.class, () -> MarkerFactory.buildMarkerFrom("abcdefghijklmnopqrst"));
    }

    @Test
    public void buildingMarkerFromInputContainingFourCharsShouldSuccessWithStartOfPacketMarker() throws InvalidMarkerException {
        assertInstanceOf(StartOfPacketMarker.class, MarkerFactory.buildMarkerFrom("abcd"));
    }

    @Test
    public void buildingMarkerFromInputContainingFourteenCharsShouldSuccessWithStartOfMessageMarker() throws InvalidMarkerException {
        assertInstanceOf(StartOfMessageMarker.class, MarkerFactory.buildMarkerFrom("abcdefghijklmn"));
    }
}
