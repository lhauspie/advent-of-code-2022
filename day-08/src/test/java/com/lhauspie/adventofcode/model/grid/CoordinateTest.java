package com.lhauspie.adventofcode.model.grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest {

    @Test
    public void movingLeftIsDecreasingTheColumnWithoutChangingTheRow() {
        Coordinate movedLeftCoordinate = new Coordinate(Row.of(5), Column.of(5)).left();
        assertEquals(Column.of(4), movedLeftCoordinate.getColumn());
        assertEquals(Row.of(5), movedLeftCoordinate.getRow());
    }

    @Test
    public void movingRightIsIncreasingTheColumnWithoutChangingTheRow() {
        Coordinate movedRightCoordinate = new Coordinate(Row.of(5), Column.of(5)).right();
        assertEquals(Column.of(6), movedRightCoordinate.getColumn());
        assertEquals(Row.of(5), movedRightCoordinate.getRow());
    }

    @Test
    public void movingUpIsDecreasingTheRowWithoutChangingTheColumn() {
        Coordinate movedRightCoordinate = new Coordinate(Row.of(5), Column.of(5)).up();
        assertEquals(Column.of(5), movedRightCoordinate.getColumn());
        assertEquals(Row.of(4), movedRightCoordinate.getRow());
    }

    @Test
    public void movingDownIsIncreasingTheRowWithoutChangingTheColumn() {
        Coordinate movedRightCoordinate = new Coordinate(Row.of(5), Column.of(5)).down();
        assertEquals(Column.of(5), movedRightCoordinate.getColumn());
        assertEquals(Row.of(6), movedRightCoordinate.getRow());
    }
}
