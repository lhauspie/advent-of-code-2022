package com.lhauspie.adventofcode.model;

public class Elf {

    private Quantity carriedCalories = Quantity.of(0);

    public Quantity getCarriedCalories() {
        return carriedCalories;
    }

    public void count(Quantity calories) {
        this.carriedCalories = this.carriedCalories.add(calories);
    }

    public boolean carriesMoreCaloriesThan(Elf other) {
        return other != null && this.getCarriedCalories().moreThan(other.getCarriedCalories());
    }
}
