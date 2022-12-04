package com.lhauspie.adventofcode.model;

import java.util.Objects;

public class ItemType {

    private Priority priority;

    public ItemType(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemType itemType = (ItemType) o;
        return Objects.equals(priority, itemType.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority);
    }
}
