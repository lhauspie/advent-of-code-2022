package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeightTest {

    @Test
    public void heightIsHigherThanAnotherHeight() {
        Height higherHeight = Height.of(10);
        Height lowerHeight = Height.of(1);

        assertTrue(lowerHeight.isLowerThan(higherHeight));
    }
}
