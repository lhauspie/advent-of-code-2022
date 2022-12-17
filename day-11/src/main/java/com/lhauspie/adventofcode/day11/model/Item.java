package com.lhauspie.adventofcode.day11.model;

public class Item {
    private Owner owner;
    private long worryLevel;

    public Item(long worryLevel) {
        this.worryLevel = worryLevel;
    }

    public Item(long worryLevel, Owner owner) {
        this.worryLevel = worryLevel;
        this.owner = owner;
        owner.addItem(this);
    }

    public void inspect(Inspection inspection) {
        if (owner != null) {
            owner.itemInspected(this, inspection);
        }
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public long getWorryLevel() {
        return worryLevel;
    }

    public void setWorryLevel(long worryLevel) {
        this.worryLevel = worryLevel;
    }
}
