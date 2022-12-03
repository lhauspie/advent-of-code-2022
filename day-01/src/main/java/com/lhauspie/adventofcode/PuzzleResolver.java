package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Boat;
import com.lhauspie.adventofcode.model.Elf;
import com.lhauspie.adventofcode.model.EmptyBoatException;
import com.lhauspie.adventofcode.model.Quantity;

import java.util.Scanner;

public class PuzzleResolver {
  public static Quantity resolve(Scanner scanner) throws EmptyBoatException {
    Boat boat = new Boat();

    while (scanner.hasNextLine()) {
      boat.add(nextElf(scanner));
    }
    return boat.getElfWithMoreCalories().getCarriedCalories();
  }

  private static Elf nextElf(Scanner scanner) {
    var elf = new Elf();
    var nextLine = scanner.nextLine();
    boolean keepBuildingElf = true;

    while (!nextLine.isEmpty() && keepBuildingElf) {
      elf.count(Quantity.of(Integer.valueOf(nextLine)));
      if (scanner.hasNextLine()) {
        nextLine = scanner.nextLine();
      } else {
        keepBuildingElf = false;
      }
    }

    return elf;
  }
}
