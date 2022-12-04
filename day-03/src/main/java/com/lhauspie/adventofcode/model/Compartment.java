package com.lhauspie.adventofcode.model;

import java.util.ArrayList;
import java.util.List;

public class Compartment {

    private List<Item> items = new ArrayList<>();

    public void load(Item item) {
        items.add(item);
    }

    public Iterable<Item> getItems() {
        return items;
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }
}
