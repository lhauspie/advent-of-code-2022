package com.lhauspie.adventofcode.model.v2.subroutine;

import com.lhauspie.adventofcode.model.v2.marker.MarkerFactory;
import com.lhauspie.adventofcode.model.v2.marker.StartOfMessageMarker;

public class StartOfMessageMarkerSubRoutine extends GenericSubRoutine {

    public StartOfMessageMarkerSubRoutine() {
        super(StartOfMessageMarker.MARKER_SIZE, input -> MarkerFactory.buildMarkerFrom(input));
    }
}
