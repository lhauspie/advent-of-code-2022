package com.lhauspie.adventofcode.model;

public class Boat {

  Elf elf;

  public Elf findTheGoodElf() throws EmptyBoatException {
    if (elf == null) {
      throw new EmptyBoatException();
    }
    return elf;
  }

  public void add(Elf elf) {
    if (this.elf == null || elf.carriesMoreCaloriesThan(this.elf)) {
      this.elf = elf;
    }
  }
}
