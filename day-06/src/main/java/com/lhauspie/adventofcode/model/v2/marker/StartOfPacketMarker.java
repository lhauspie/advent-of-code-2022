package com.lhauspie.adventofcode.model.v2.marker;

public class StartOfPacketMarker extends Marker {

    public static final int MARKER_SIZE = 4;

    public StartOfPacketMarker(String value) throws InvalidMarkerException {
        super(value);
    }

    @Override
    public int getMarkerSize() {
        return MARKER_SIZE;
    }
}
