package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void worryLevelOfThirtyIsThreeTimesLessAfterInspection() {
        var item = new Item(30L);
        item.inspect();
        assertEquals(10L, item.getWorryLevel());
    }

    @Test
    public void worryLevelOfThirtyOneIsThreeTimesLessAfterInspection() {
        var item = new Item(31L);
        item.inspect();
        assertEquals(10L, item.getWorryLevel());
    }

    @Test
    public void worryLevelOfThirtyTwoIsThreeTimesLessAfterInspection() {
        var item = new Item(32L);
        item.inspect();
        assertEquals(10L, item.getWorryLevel());
    }

    @Test
    public void worryLevelOfThirtyThreeIsThreeTimesLessAfterInspection() {
        var item = new Item(33L);
        item.inspect();
        assertEquals(11L, item.getWorryLevel());
    }
}
