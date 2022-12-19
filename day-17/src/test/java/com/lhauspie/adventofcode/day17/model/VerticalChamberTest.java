package com.lhauspie.adventofcode.day17.model;

import com.lhauspie.adventofcode.day17.model.rock.CrossRock;
import com.lhauspie.adventofcode.day17.model.rock.RockFactory;
import com.lhauspie.adventofcode.day17.model.rock.VerticalLineRock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VerticalChamberTest {

    private RockFactory rockFactory;
    private VerticalChamber verticalChamber;

    @BeforeEach
    public void init() {
        verticalChamber = new VerticalChamber();
        rockFactory = new RockFactory();
    }

    @Test
    public void newVerticalChamberHasTallOfZero() {
        Assertions.assertEquals(0, verticalChamber.getTowerTall());
    }

    @Test
    public void restingCrossInVerticalChamberResultsToTallThree() {
        verticalChamber.restRock(new CrossRock(MutablePosition.of(0, 0)));
        Assertions.assertEquals(3, verticalChamber.getTowerTall());
        Assertions.assertEquals(2, verticalChamber.getHighestPosition().getY());
    }

    @Test
    public void restingVerticalLineInVerticalChamberResultsToTallFour() {
        verticalChamber.restRock(new VerticalLineRock(MutablePosition.of(0, 0)));
        Assertions.assertEquals(4, verticalChamber.getTowerTall());
        Assertions.assertEquals(3, verticalChamber.getHighestPosition().getY());
    }
}
