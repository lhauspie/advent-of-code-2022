package com.lhauspie.adventofcode.model;

public class Elf {

    private int calories = 0;

    public int getCarriedCalories() {
        return calories;
    }

    public void count(int calories) {
        this.calories += calories;
    }
}
