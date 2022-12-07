package com.lhauspie.adventofcode.model.v2.subroutine;

public interface SubRoutine {
    void analyseNextChar(char nextChar);
    int getNbAnalysedChars() throws NoValidMarkerFoundException;
}
