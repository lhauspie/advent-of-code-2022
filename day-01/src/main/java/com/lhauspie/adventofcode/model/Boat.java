package com.lhauspie.adventofcode.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Boat {

    private List<Elf> elves = new ArrayList<>();

    public Elf getTopOneElfWithMoreCalories() throws EmptyBoatException {
        if (boatIsEmpty()) {
            throw new EmptyBoatException();
        }
        return elves.stream()
                .sorted((o1, o2) -> o2.getCarriedCalories().compareTo(o1.getCarriedCalories()))
                .findFirst().get();
    }

    public void add(Elf elf) {
        elves.add(elf);
    }

    private boolean boatIsEmpty() {
        return elves.isEmpty();
    }

    public List<Elf> getTopThreeElvesWithMoreCalories() throws EmptyBoatException {
        if (boatIsEmpty()) {
            throw new EmptyBoatException();
        }
        return elves.stream()
                .sorted((o1, o2) -> o2.getCarriedCalories().compareTo(o1.getCarriedCalories()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
