package com.lhauspie.adventofcode.model.v2.subroutine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BufferTest {

    @Test
    public void emptyBufferShouldReturnEmptyString() {
        LimitedSizedBuffer buffer = new LimitedSizedBuffer(10);
        assertEquals("", buffer.toString());
    }

    @Test
    public void overflowingBufferShouldDeleteOldestEntries() {
        LimitedSizedBuffer buffer = new LimitedSizedBuffer(10);
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
