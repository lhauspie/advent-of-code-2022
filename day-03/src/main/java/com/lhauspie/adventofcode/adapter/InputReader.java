package com.lhauspie.adventofcode.adapter;

import com.lhauspie.adventofcode.model.Item;
import com.lhauspie.adventofcode.model.ItemType;
import com.lhauspie.adventofcode.model.Priority;
import com.lhauspie.adventofcode.model.Rucksack;

public class InputReader {

    public static Rucksack inputRucksackContentToRucksack(String rucksackContent) {
        var rucksack = new Rucksack();

        for (int itemIndex = 0; itemIndex < rucksackContent.length() / 2; itemIndex++) {
            rucksack.loadLeft(itemFromLetter(rucksackContent.charAt(itemIndex)));
        }

        for (int itemIndex = rucksackContent.length() / 2; itemIndex < rucksackContent.length(); itemIndex++) {
            rucksack.loadRight(itemFromLetter(rucksackContent.charAt(itemIndex)));
        }

        return rucksack;
    }

    private static Item itemFromLetter(char letter) {
        if (letter >= 'a' && letter <= 'z') {
            return new Item(new ItemType(new Priority(letter - 'a' + 1)));
        }
        if (letter >= 'A' && letter <= 'Z') {
            return new Item(new ItemType(new Priority(letter - 'A' + 27)));
        }
        return null;
    }
}
