package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Boat;
import com.lhauspie.adventofcode.model.Elf;
import com.lhauspie.adventofcode.model.EmptyBoatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoatTest {

  @Test
  public void findingTheGoodElfInEmptyBoatShouldThrowsAnException() {
    var boat = new Boat();
    Assertions.assertThrows(EmptyBoatException.class, () -> boat.findTheGoodElf());
  }

  @Test
  public void findingTheGoodElfInBoatWithOneElfShouldReturnTheLonelyElf()
      throws EmptyBoatException {
    var boat = new Boat();
    Elf elf = new Elf();
    boat.add(elf);
    Assertions.assertTrue(elf == boat.findTheGoodElf());
  }
}
