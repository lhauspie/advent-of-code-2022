package com.lhauspie.adventofcode.model.v2.marker;

public class StartOfMessageMarker extends Marker {

    public static final int MARKER_SIZE = 14;

    public StartOfMessageMarker(String value) throws InvalidMarkerException {
        super(value);
    }

    @Override
    public int getMarkerSize() {
        return MARKER_SIZE;
    }
}
