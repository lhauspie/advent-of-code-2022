package com.lhauspie.adventofcode.model.v2.subroutine;

import com.lhauspie.adventofcode.model.v2.marker.InvalidMarkerException;
import com.lhauspie.adventofcode.model.v2.marker.MarkerFactory;

public class GenericSubRoutine implements SubRoutine {

    private Buffer buffer;
    private boolean markerFound = false;
    private int nbAnalysedChars = 0;

    public GenericSubRoutine(int bufferSize) {
        this.buffer = new Buffer(bufferSize);
    }

    public void analyseNextChar(char nextChar) {
        if (!markerFound) {
            nbAnalysedChars++;
            String bufferContent = buffer.fulfill(nextChar).toString();
            try {
                MarkerFactory.buildMarkerFrom(bufferContent);
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
