package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void itemWithoutOwnerDoesntChangeTheWorryLevel() {
        var item = new Item(30L);
        item.inspect(worryLevel -> worryLevel * 10);
        assertEquals(30L, item.getWorryLevel());
    }

    @Test
    public void itemWithWorryLevelOfThirtyOfRelaxOwnerHasWorryLevelThreeTimesLessAfterInspection() {
        Owner owner = new RelaxOwner();
        var item = new Item(30L, owner);
        item.inspect(worryLevel -> worryLevel); // neutral inspection, don't worry
        assertEquals(10L, item.getWorryLevel());
    }

    @Test
    public void itemWithWorryLevelOfThirtyOneOfRelaxOwnerHasWorryLevelThreeTimesLessAfterInspection() {
        Owner owner = new RelaxOwner();
        var item = new Item(31L, owner);
        item.inspect(worryLevel -> worryLevel); // neutral inspection, don't worry
        assertEquals(10L, item.getWorryLevel());
    }

    @Test
    public void itemWithWorryLevelOfThirtyTwoOfRelaxOwnerHasWorryLevelThreeTimesLessAfterInspection() {
        Owner owner = new RelaxOwner();
        var item = new Item(32L, owner);
        item.inspect(worryLevel -> worryLevel); // neutral inspection, don't worry
        assertEquals(10L, item.getWorryLevel());
    }

    @Test
    public void itemWithWorryLevelOfThirtyThreeOfRelaxOwnerHasWorryLevelThreeTimesLessAfterInspection() {
        Owner owner = new RelaxOwner();
        var item = new Item(33L, owner);
        item.inspect(worryLevel -> worryLevel); // neutral inspection, don't worry
        assertEquals(11L, item.getWorryLevel());
    }
}
