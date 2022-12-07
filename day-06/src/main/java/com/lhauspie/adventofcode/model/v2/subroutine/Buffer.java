package com.lhauspie.adventofcode.model.v2.subroutine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Buffer {
    private Deque<Character> buffer = new ArrayDeque<>();
    private int bufferSize = 0;

    public Buffer(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public Buffer fulfill(char nextChar) {
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
