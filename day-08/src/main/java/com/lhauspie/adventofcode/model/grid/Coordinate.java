package com.lhauspie.adventofcode.model.grid;

import java.util.Objects;

public class Coordinate {

    private Row row;
    private Column column;

    public Coordinate(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }

    public Coordinate left() {
        return new Coordinate(row, column.left());
    }

    public Coordinate right() {
        return new Coordinate(row, column.right());
    }

    public Coordinate up() {
        return new Coordinate(row.top(), column);
    }

    public Coordinate down() {
        return new Coordinate(row.bottom(), column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(row, that.row) && Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
