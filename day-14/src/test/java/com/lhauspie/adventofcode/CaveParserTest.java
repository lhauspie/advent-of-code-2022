package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Position;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaveParserTest {
    @Test
    public void parseSimpleInputMovingOnY() {
        String input = "498,4 -> 498,6";
        Set<Position> rocks = CaveParser.getRockPositionsFromPathDescription(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertFalse(rocks.contains(Position.of(498,7)));
    }

    @Test
    public void parseSimpleInputMovingOnReverseY() {
        String input = "498,6 -> 498,4";
        Set<Position> rocks = CaveParser.getRockPositionsFromPathDescription(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertFalse(rocks.contains(Position.of(498,7)));
    }

    @Test
    public void parseSimpleInputMovingOnX() {
        String input = "498,4 -> 500,4";
        Set<Position> rocks = CaveParser.getRockPositionsFromPathDescription(input);

        assertFalse(rocks.contains(Position.of(497,4)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(499,4)));
        assertTrue(rocks.contains(Position.of(500,4)));
        assertFalse(rocks.contains(Position.of(501,4)));
    }

    @Test
    public void parseSimpleInputMovingOnReverseX() {
        String input = "500,4 -> 498,4";
        Set<Position> rocks = CaveParser.getRockPositionsFromPathDescription(input);

        assertFalse(rocks.contains(Position.of(497,4)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(499,4)));
        assertTrue(rocks.contains(Position.of(500,4)));
        assertFalse(rocks.contains(Position.of(501,4)));
    }

    @Test
    public void parseSimpleInputContainingTwoMovesMovingOnY() {
        String input = "498,4 -> 498,6 -> 498,10";
        Set<Position> rocks = CaveParser.getRockPositionsFromPathDescription(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertTrue(rocks.contains(Position.of(498,7)));
        assertTrue(rocks.contains(Position.of(498,8)));
        assertTrue(rocks.contains(Position.of(498,9)));
        assertTrue(rocks.contains(Position.of(498,10)));
        assertFalse(rocks.contains(Position.of(498,11)));
    }

    @Test
    public void parseSimpleInputContainingTwoMovesMovingOnReverseY() {
        String input = "498,10 -> 498,6 -> 498,4";
        Set<Position> rocks = CaveParser.getRockPositionsFromPathDescription(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertTrue(rocks.contains(Position.of(498,7)));
        assertTrue(rocks.contains(Position.of(498,8)));
        assertTrue(rocks.contains(Position.of(498,9)));
        assertTrue(rocks.contains(Position.of(498,10)));
        assertFalse(rocks.contains(Position.of(498,11)));
    }

    @Test
    public void parseInputContainingDirectionChanges() {
        String input = "498,10 -> 498,6 -> 498,4 -> 500,4";
        Set<Position> rocks = CaveParser.getRockPositionsFromPathDescription(input);

        assertFalse(rocks.contains(Position.of(498,3)));
        assertFalse(rocks.contains(Position.of(501,4)));
        assertTrue(rocks.contains(Position.of(500,4)));
        assertTrue(rocks.contains(Position.of(499,4)));
        assertTrue(rocks.contains(Position.of(498,4)));
        assertFalse(rocks.contains(Position.of(497,4)));
        assertTrue(rocks.contains(Position.of(498,5)));
        assertTrue(rocks.contains(Position.of(498,6)));
        assertTrue(rocks.contains(Position.of(498,7)));
        assertTrue(rocks.contains(Position.of(498,8)));
        assertTrue(rocks.contains(Position.of(498,9)));
        assertTrue(rocks.contains(Position.of(498,10)));
        assertFalse(rocks.contains(Position.of(498,11)));
    }
}
