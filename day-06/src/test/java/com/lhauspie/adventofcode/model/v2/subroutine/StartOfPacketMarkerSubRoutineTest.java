package com.lhauspie.adventofcode.model.v2.subroutine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartOfPacketMarkerSubRoutineTest {

    @Test
    public void analysingSequenceWithStartOfPacketMarkerSubRoutineShouldReturnSeven() throws NoValidMarkerFoundException {
        var subRoutine = new StartOfPacketMarkerSubRoutine();

        subRoutine.analyseNextChar('a');
        subRoutine.analyseNextChar('a');
        subRoutine.analyseNextChar('b');
        subRoutine.analyseNextChar('b');
        subRoutine.analyseNextChar('c');
        subRoutine.analyseNextChar('d');
        subRoutine.analyseNextChar('e');
        subRoutine.analyseNextChar('f');
        subRoutine.analyseNextChar('g');
        subRoutine.analyseNextChar('h');
        subRoutine.analyseNextChar('i');
        subRoutine.analyseNextChar('j');
        subRoutine.analyseNextChar('k');
        subRoutine.analyseNextChar('l');
        subRoutine.analyseNextChar('m');
        subRoutine.analyseNextChar('n');
        subRoutine.analyseNextChar('o');
        subRoutine.analyseNextChar('p');
        subRoutine.analyseNextChar('q');
        subRoutine.analyseNextChar('h');
        subRoutine.analyseNextChar('h');
        subRoutine.analyseNextChar('h');
        subRoutine.analyseNextChar('h');

        assertEquals(7, subRoutine.getNbAnalysedChars());
    }
}
