package com.lhauspie.adventofcode.model.v2.subroutine;

import com.lhauspie.adventofcode.model.v2.marker.InvalidMarkerException;
import com.lhauspie.adventofcode.model.v2.marker.Marker;

@FunctionalInterface
public interface MarkerBuilder {
    Marker build(String input) throws InvalidMarkerException;
}
