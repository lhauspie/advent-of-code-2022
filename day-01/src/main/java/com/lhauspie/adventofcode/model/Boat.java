package com.lhauspie.adventofcode.model;

public class Boat {

  private Elf elfWithMoreCalories;

  public Elf getElfWithMoreCalories() throws EmptyBoatException {
    if (boatIsEmpty()) {
      throw new EmptyBoatException();
    }
    return elfWithMoreCalories;
  }

  public void add(Elf elf) {
    if (boatIsEmpty() || elf.carriesMoreCaloriesThan(elfWithMoreCalories)) {
      elfWithMoreCalories = elf;
    }
  }

  private boolean boatIsEmpty() {
    return elfWithMoreCalories == null;
  }
}
