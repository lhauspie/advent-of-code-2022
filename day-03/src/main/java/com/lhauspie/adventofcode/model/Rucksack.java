package com.lhauspie.adventofcode.model;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Rucksack {
    private Compartment left;
    private Compartment right;

    public Rucksack() {
        this.left = new Compartment();
        this.right = new Compartment();
    }

    public void loadLeft(Item item) {
        left.load(item);
    }

    public void loadRight(Item item) {
        right.load(item);
    }

    public Item getItemPresentInBothCompartments() {
        return StreamSupport.stream(left.getItems().spliterator(), false)
                .distinct()
                .filter(right::contains)
                .findFirst().orElseThrow(() -> new NoErrorFoundException());
    }

    public Item getItemPresentInThreeRucksacks(Rucksack secondRucksack, Rucksack thirdRucksack) {
        return getRucksackContent()
                .distinct()
                .filter(secondRucksack::contains)
                .filter(thirdRucksack::contains)
                .findFirst().orElseThrow(() -> new NoCommonItemFoundException());
    }

    private Stream<Item> getRucksackContent() {
        return Stream
                .concat(
                        StreamSupport.stream(left.getItems().spliterator(), false),
                        StreamSupport.stream(right.getItems().spliterator(), false)
                );
    }

    private boolean contains(Item item) {
        return left.contains(item) || right.contains(item);
    }
}
