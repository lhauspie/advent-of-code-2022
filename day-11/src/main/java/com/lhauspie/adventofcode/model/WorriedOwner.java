package com.lhauspie.adventofcode.model;

public class WorriedOwner extends Owner {
    public void itemInspected(Item item, Inspection inspection) {
        // Panic, just let the worry level after the inspection
        item.setWorryLevel(inspection.evaluateNewWorryLevel(item.getWorryLevel()));
    }
}
