package com.lhauspie.adventofcode.day11.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Owner {
    private List<Item> items = new ArrayList<>();

    abstract public void itemInspected(Item item, Inspection inspection);

    public void addItem(Item item) {
        items.add(item);
        item.setOwner(this);
    }

    public List<Item> getItems() {
        return items;
    }
}
