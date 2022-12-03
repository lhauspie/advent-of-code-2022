package com.lhauspie.adventofcode.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Boat {

  private Elf elfWithMoreCalories;
  private List<Elf> elves = new ArrayList<>();

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
    elves.add(elf);
  }

  private boolean boatIsEmpty() {
    return elfWithMoreCalories == null;
  }

  public List<Elf> getTopThreeElves() {
    elves.sort((o1, o2) -> Integer.compare(o2.getCarriedCalories().getValue(), o1.getCarriedCalories().getValue()));
    return elves.stream().limit(3).collect(Collectors.toList());
  }
}
