package com.lhauspie.adventofcode.model.v2.subroutine;

import com.lhauspie.adventofcode.model.v2.marker.InvalidMarkerException;

public class GenericSubRoutine implements SubRoutine {

    private MarkerBuilder markerBuilder;
    private Buffer buffer;
    private boolean markerFound = false;
    private int nbAnalysedChars = 0;

    public GenericSubRoutine(int bufferSize, MarkerBuilder markerBuilder) {
        this.buffer = new Buffer(bufferSize);
        this.markerBuilder = markerBuilder;
    }

    public void analyseNextChar(char nextChar) {
        if (!markerFound) {
            nbAnalysedChars++;
            String bufferContent = buffer.fulfill(nextChar).toString();
            try {
                markerBuilder.build(bufferContent);
                markerFound = true;
            } catch (InvalidMarkerException e) {
                // Nothing to do because it's an expected validation failure we want to ignore
            }
        }
    }

    public int getNbAnalysedChars() throws NoValidMarkerFoundException {
        if (markerFound) {
            return nbAnalysedChars;
        } else {
            throw new NoValidMarkerFoundException("End of signal but no marker found");
        }
    }
}
