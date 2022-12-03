package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Boat;
import com.lhauspie.adventofcode.model.Elf;
import com.lhauspie.adventofcode.model.EmptyBoatException;
import com.lhauspie.adventofcode.model.Quantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

  @Test
  public void findingTopThreeElvesInBoatWith5ElvesShouldReturnThreeElvesWithMoreCalories()
      throws EmptyBoatException {
    var boat = new Boat();

    Elf elfWith3000Calories = new Elf();
    elfWith3000Calories.count(Quantity.of(3000));
    boat.add(elfWith3000Calories);

    Elf elfWith10000Calories = new Elf();
    elfWith10000Calories.count(Quantity.of(10000));
    boat.add(elfWith10000Calories);

    Elf elfWith100Calories = new Elf();
    elfWith100Calories.count(Quantity.of(100));
    boat.add(elfWith100Calories);

    Elf elfWith500Calories = new Elf();
    elfWith500Calories.count(Quantity.of(500));
    boat.add(elfWith500Calories);

    Elf elfWith200Calories = new Elf();
    elfWith200Calories.count(Quantity.of(200));
    boat.add(elfWith200Calories);

    List<Elf> topThreeElvesWithMoreCalories = boat.getTopThreeElves();
    Assertions.assertEquals(3, topThreeElvesWithMoreCalories.size());
    Assertions.assertEquals(10000, topThreeElvesWithMoreCalories.get(0).getCarriedCalories().getValue());
    Assertions.assertEquals(3000, topThreeElvesWithMoreCalories.get(1).getCarriedCalories().getValue());
    Assertions.assertEquals(500, topThreeElvesWithMoreCalories.get(2).getCarriedCalories().getValue());
  }
}
