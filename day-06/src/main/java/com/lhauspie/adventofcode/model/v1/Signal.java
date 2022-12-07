package com.lhauspie.adventofcode.model.v1;

public class Signal {
    private final String value;
    private int index = 0;

    private Signal(String value) {
        this.value = value;
    }

    public static Signal of(String value) {
        return new Signal(value);
    }

    public Marker nextMarker() {
        Marker marker = Marker.of(getValue().substring(index, index + Marker.MARKER_SIZE));
        index++;
        return marker;
    }

    public String getValue() {
        return value;
    }

    public int getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartOfPacketMarker() {
        while (!nextMarker().isStartOfPacketMarker()) {
            // do nothing because we don't care about the value of the marker
        }
        return index + Marker.MARKER_SIZE - 1;
    }
}
