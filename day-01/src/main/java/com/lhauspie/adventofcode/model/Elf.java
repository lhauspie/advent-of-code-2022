package com.lhauspie.adventofcode.model;

public class Elf {

  private int carriedCalories = 0;

  public int getCarriedCalories() {
    return carriedCalories;
  }

  public void count(int calories) {
    this.carriedCalories += calories;
  }

  public boolean carriesMoreCaloriesThan(Elf other) {
    return other != null && this.getCarriedCalories() > other.getCarriedCalories();
  }
}
