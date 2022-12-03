package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Boat;
import com.lhauspie.adventofcode.model.EmptyBoatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoatTest {

    @Test
    public void findingTheGoodElfInEmptyBoatShouldThrowsAnException() {
        var boat = new Boat();
        Assertions.assertThrows(EmptyBoatException.class, () -> boat.findTheGoodElf());
    }
}
