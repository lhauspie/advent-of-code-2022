package com.lhauspie.adventofcode.model.v2;

import com.lhauspie.adventofcode.model.v2.subroutine.SubRoutine;

public class Device {

    private SubRoutine subRoutine;

    public Device(SubRoutine subRoutine) {
        this.subRoutine = subRoutine;
    }

    public void receive(char c) {
        subRoutine.analyseNextChar(c);
    }

    public SubRoutine getSubRoutine() {
        return subRoutine;
    }
}
