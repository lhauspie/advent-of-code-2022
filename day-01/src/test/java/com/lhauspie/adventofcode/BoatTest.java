package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Boat;
import com.lhauspie.adventofcode.model.Elf;
import com.lhauspie.adventofcode.model.EmptyBoatException;
import com.lhauspie.adventofcode.model.Quantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoatTest {

  @Test
  public void findingTheGoodElfInEmptyBoatShouldThrowsAnException() {
    var boat = new Boat();
    Assertions.assertThrows(EmptyBoatException.class, () -> boat.getElfWithMoreCalories());
  }

  @Test
  public void findingTheGoodElfInBoatWithOneElfShouldReturnTheLonelyElf()
      throws EmptyBoatException {
    var boat = new Boat();
    Elf elf = new Elf();
    boat.add(elf);
    Assertions.assertTrue(elf == boat.getElfWithMoreCalories());
  }

  @Test
  public void findingTheGoodElfInBoatWithOneElfWith3000CaloriesAndAnotherOneWith200CaloriesShouldReturnTheElfWith3000()
      throws EmptyBoatException {
    var boat = new Boat();

    Elf elfWith3000Calories = new Elf();
    elfWith3000Calories.count(Quantity.of(3000));
    boat.add(elfWith3000Calories);

    Elf elfWith200Calories = new Elf();
    elfWith200Calories.count(Quantity.of(200));
    boat.add(elfWith200Calories);

    Assertions.assertEquals(elfWith3000Calories.getCarriedCalories(), boat.getElfWithMoreCalories().getCarriedCalories());
  }
}
