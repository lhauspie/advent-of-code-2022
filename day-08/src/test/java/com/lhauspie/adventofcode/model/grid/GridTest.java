package com.lhauspie.adventofcode.model.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    @Test
    public void test() {
        Grid<Integer> grid = new Grid<>();

        grid.put(1, new Coordinate(Row.of(1), Column.of(1)));
        grid.put(2, new Coordinate(Row.of(1), Column.of(2)));
        grid.put(3, new Coordinate(Row.of(1), Column.of(3)));
        grid.put(4, new Coordinate(Row.of(2), Column.of(1)));
        grid.put(5, new Coordinate(Row.of(2), Column.of(2)));
        grid.put(6, new Coordinate(Row.of(2), Column.of(3)));
        grid.put(7, new Coordinate(Row.of(3), Column.of(1)));
        grid.put(8, new Coordinate(Row.of(3), Column.of(2)));
        grid.put(9, new Coordinate(Row.of(3), Column.of(3)));

        assertEquals(5, grid.getItemAt(new Coordinate(Row.of(2), Column.of(2))));
    }
}
