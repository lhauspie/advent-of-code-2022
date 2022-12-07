package com.lhauspie.adventofcode.model.v2.subroutine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * This class allows to have a LimitedSizedBuffer as a FIFO.
 * But the particularity of this Buffer is that if there is an overflow,
 * the oldest value is removed from it to guarantee we only have the allowed number of element, no more.
 * Without any exceptions.
 */
public class LimitedSizedBuffer {
    private Deque<Character> buffer = new ArrayDeque<>();
    private int bufferSize;

    public LimitedSizedBuffer(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public LimitedSizedBuffer fulfill(char nextChar) {
        buffer.addLast(nextChar);
        if (buffer.size() > bufferSize) {
            buffer.pollFirst();
        }
        return this;
    }

    public String toString() {
        return buffer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
