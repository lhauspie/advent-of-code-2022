package com.lhauspie.adventofcode.day11.model;

public class RelaxOwner extends Owner {
    public void itemInspected(Item item, Inspection inspection) {
        // Don't Panic, just reduce worry level by three after the inspection
        item.setWorryLevel(inspection.evaluateNewWorryLevel(item.getWorryLevel()) / 3L);
    }
}
