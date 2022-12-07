package com.lhauspie.adventofcode.model.v2.subroutine;

import com.lhauspie.adventofcode.model.v2.marker.MarkerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GenericSubRoutineTest {

    @Test
    public void analyseNextCharWithInconsistentSubRoutineShouldThrowNoValidMarkerFoundException() {
        var genericSubRoutine = new GenericSubRoutine(
                10,
                input -> MarkerFactory.buildMarkerFrom(input)
        );

        genericSubRoutine.analyseNextChar('a');
        genericSubRoutine.analyseNextChar('a');
        genericSubRoutine.analyseNextChar('b');
        genericSubRoutine.analyseNextChar('b');
        genericSubRoutine.analyseNextChar('c');
        genericSubRoutine.analyseNextChar('d');
        genericSubRoutine.analyseNextChar('e');
        genericSubRoutine.analyseNextChar('f');
        genericSubRoutine.analyseNextChar('g');
        genericSubRoutine.analyseNextChar('h');
        genericSubRoutine.analyseNextChar('i');
        genericSubRoutine.analyseNextChar('j');
        genericSubRoutine.analyseNextChar('k');
        genericSubRoutine.analyseNextChar('l');
        genericSubRoutine.analyseNextChar('m');
        genericSubRoutine.analyseNextChar('n');
        genericSubRoutine.analyseNextChar('o');
        genericSubRoutine.analyseNextChar('p');
        genericSubRoutine.analyseNextChar('q');
        genericSubRoutine.analyseNextChar('h');
        genericSubRoutine.analyseNextChar('h');
        genericSubRoutine.analyseNextChar('h');
        genericSubRoutine.analyseNextChar('h');

        assertThrows(NoValidMarkerFoundException.class, () -> genericSubRoutine.getNbAnalysedChars());
    }
}
