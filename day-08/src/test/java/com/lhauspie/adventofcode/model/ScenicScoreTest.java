package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScenicScoreTest {
    @Test
    public void scenicScoreIsTheMultiplicationOfViewingDistances() {
        assertEquals(ScenicScore.of(256), ScenicScore.of(
                ViewingDistance.of(4),
                ViewingDistance.of(4),
                ViewingDistance.of(4),
                ViewingDistance.of(4)
        ));
    }
}
