package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Boat;
import com.lhauspie.adventofcode.model.Elf;
import com.lhauspie.adventofcode.model.EmptyBoatException;
import com.lhauspie.adventofcode.model.Quantity;

import java.util.Scanner;

public class PuzzleResolver {
  public static Quantity resolve(Scanner scanner) throws EmptyBoatException {
    Boat boat = new Boat();

    if (scanner.hasNext()) {
      var elf = new Elf();
      elf.count(Quantity.of(scanner.nextInt()));
      elf.count(Quantity.of(scanner.nextInt()));
      boat.add(elf);
    }
    return boat.getElfWithMoreCalories().getCarriedCalories();
  }
}
