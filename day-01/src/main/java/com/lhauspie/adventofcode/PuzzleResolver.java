package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Boat;
import com.lhauspie.adventofcode.model.EmptyBoatException;

import java.util.Scanner;

public class PuzzleResolver {
    public static void resolve(Scanner scanner) throws EmptyBoatException {
        new Boat().getElfWithMoreCalories().getCarriedCalories();
    }
}
