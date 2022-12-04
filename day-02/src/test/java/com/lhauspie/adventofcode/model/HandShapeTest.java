package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static com.lhauspie.adventofcode.model.HandShape.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandShapeTest {

    @Test
    public void handShapeRocksIsDraw() {
        assertTrue(ROCK.draw(ROCK));
    }

    @Test
    public void handShapePapersIsDraw() {
        assertTrue(PAPER.draw(PAPER));
    }

    @Test
    public void handShapeScissorsIsDraw() {
        assertTrue(SCISSORS.draw(SCISSORS));
    }

    @Test
    public void scoreOfRockShouldBeOne() {
        assertEquals(1, ROCK.getScore().getValue());
    }

    @Test
    public void scoreOfPaperShouldBeTwo() {
        assertEquals(2, PAPER.getScore().getValue());
    }

    @Test
    public void scoreOfScissorsShouldBeThree() {
        assertEquals(3, SCISSORS.getScore().getValue());
    }
}
