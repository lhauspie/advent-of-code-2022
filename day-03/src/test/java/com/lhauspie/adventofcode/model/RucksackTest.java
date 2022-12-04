package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RucksackTest {

    @Test
    public void getItemPresentInBothCompartmentsOfTheRucksack() {
        var rucksack = new Rucksack();
        rucksack.loadLeft(new Item(new ItemType(new Priority(14))));
        rucksack.loadLeft(new Item(new ItemType(new Priority(15))));
        rucksack.loadLeft(new Item(new ItemType(new Priority(16))));
        rucksack.loadLeft(new Item(new ItemType(new Priority(17))));
        rucksack.loadRight(new Item(new ItemType(new Priority(17))));
        rucksack.loadRight(new Item(new ItemType(new Priority(18))));
        rucksack.loadRight(new Item(new ItemType(new Priority(19))));
        rucksack.loadRight(new Item(new ItemType(new Priority(20))));

        assertEquals(17, rucksack.getItemPresentInBothCompartments().getType().getPriority().getValue());
    }

    @Test
    public void getItemPresentInThreeRucksack() {
        var firstRucksack = new Rucksack();
        firstRucksack.loadLeft(new Item(new ItemType(new Priority(14))));
        firstRucksack.loadLeft(new Item(new ItemType(new Priority(15))));
        firstRucksack.loadLeft(new Item(new ItemType(new Priority(16))));
        firstRucksack.loadLeft(new Item(new ItemType(new Priority(17))));
        firstRucksack.loadRight(new Item(new ItemType(new Priority(17))));
        firstRucksack.loadRight(new Item(new ItemType(new Priority(18))));
        firstRucksack.loadRight(new Item(new ItemType(new Priority(19))));
        firstRucksack.loadRight(new Item(new ItemType(new Priority(20))));

        var secondRucksack = new Rucksack();
        secondRucksack.loadLeft(new Item(new ItemType(new Priority(14))));
        secondRucksack.loadRight(new Item(new ItemType(new Priority(25))));

        var thirdRucksack = new Rucksack();
        thirdRucksack.loadLeft(new Item(new ItemType(new Priority(14))));
        thirdRucksack.loadRight(new Item(new ItemType(new Priority(22))));

        assertEquals(14, firstRucksack.getItemPresentInThreeRucksacks(secondRucksack, thirdRucksack).getType().getPriority().getValue());
    }
}
