package com.lhauspie.adventofcode.model.v2.subroutine;

import com.lhauspie.adventofcode.model.v2.marker.StartOfPacketMarker;

public class StartOfPacketMarkerSubRoutine extends GenericSubRoutine {

    public StartOfPacketMarkerSubRoutine() {
        super(StartOfPacketMarker.MARKER_SIZE);
    }
}
