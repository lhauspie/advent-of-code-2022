package com.lhauspie.adventofcode.model.v2.subroutine;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BufferTest {

    @Test
    public void overflowingBufferShouldDeleteFirstEntries() {
        Buffer buffer = new Buffer(10);
        buffer.fulfill('a');
        buffer.fulfill('b');
        buffer.fulfill('c');
        buffer.fulfill('d');
        buffer.fulfill('e');
        buffer.fulfill('f');
        buffer.fulfill('g');
        buffer.fulfill('h');
        buffer.fulfill('i');
        buffer.fulfill('j');
        buffer.fulfill('k');
        buffer.fulfill('l');
        buffer.fulfill('m');

        assertEquals("defghijklm", buffer.toString());
    }
}
