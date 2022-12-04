package com.lhauspie.adventofcode.model;

import java.util.Objects;

public class Item {

    private ItemType type;

    public Item(ItemType type) {
        this.type = type;
    }

    public ItemType getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(type, item.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
