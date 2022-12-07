package com.lhauspie.adventofcode.model.v2.marker;

public class MarkerFactory {

    public static Marker buildMarkerFrom(String input) throws InvalidMarkerException {
        if (input.length() == StartOfPacketMarker.MARKER_SIZE) {
            return new StartOfPacketMarker(input);
        }
        if (input.length() == StartOfMessageMarker.MARKER_SIZE) {
            return new StartOfMessageMarker(input);
        }
        throw new InvalidMarkerException("length is not correct");
    }
}
