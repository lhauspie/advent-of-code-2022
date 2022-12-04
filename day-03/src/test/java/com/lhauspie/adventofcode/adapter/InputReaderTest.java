package com.lhauspie.adventofcode.adapter;

import com.lhauspie.adventofcode.model.Priority;
import com.lhauspie.adventofcode.model.Rucksack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputReaderTest {

    @Test
    public void aLetterShouldBuildItemWithPriorityOne() {
        var rucksackContent = "aa";
        Rucksack rucksack = InputReader.inputRucksackContentToRucksack(rucksackContent);
        assertEquals(new Priority(1), rucksack.getItemPresentInBothCompartments().getType().getPriority());
    }

    @Test
    public void zLetterShouldBuildItemWithPriorityTwentySix() {
        var rucksackContent = "zz";
        Rucksack rucksack = InputReader.inputRucksackContentToRucksack(rucksackContent);
        assertEquals(new Priority(26), rucksack.getItemPresentInBothCompartments().getType().getPriority());
    }

    @Test
    public void ALetterShouldBuildItemWithPriorityTwentySeven() {
        var rucksackContent = "AA";
        Rucksack rucksack = InputReader.inputRucksackContentToRucksack(rucksackContent);
        assertEquals(new Priority(27), rucksack.getItemPresentInBothCompartments().getType().getPriority());
    }

    @Test
    public void ZLetterShouldBuildItemWithPriorityTwentySeven() {
        var rucksackContent = "ZZ";
        Rucksack rucksack = InputReader.inputRucksackContentToRucksack(rucksackContent);
        assertEquals(new Priority(52), rucksack.getItemPresentInBothCompartments().getType().getPriority());
    }
}
