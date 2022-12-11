package com.lhauspie.adventofcode.model;

public class ZenItem extends Item {

    public ZenItem(long worryLevel) {
        super(worryLevel);
    }

    public void inspect() {
        setWorryLevel(getWorryLevel() / 3L);
    }
}
