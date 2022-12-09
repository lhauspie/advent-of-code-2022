package com.lhauspie.adventofcode.model.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid<T> {
    private int nbRows;
    private int nbColumns;
    private Map<Coordinate, T> items = new HashMap<>();

    public void put(T item, Coordinate coordinate) {
        calculateNbRows(coordinate.getRow());
        calculateNbColumns(coordinate.getColumn());
        items.put(coordinate, item);
    }

    private void calculateNbColumns(Column column) {
        if (column.getValue() > nbColumns) {
            nbColumns = column.getValue();
        }
    }

    private void calculateNbRows(Row row) {
        if (row.getValue() > nbRows) {
            nbRows = row.getValue();
        }
    }

    public T getItemAt(Coordinate coordinate) {
        return items.get(coordinate);
    }

    public boolean isEdge(Coordinate coordinate) {
        return coordinate.getRow().equals(getFirstRow())
                || coordinate.getColumn().equals(getFirstColumn())
                || coordinate.getRow().equals(getLastRow())
                || coordinate.getColumn().equals(getLastColumn());
    }

    public List<Row> rows() {
        return IntStream.range(1, nbRows+1).mapToObj(r -> Row.of(r)).collect(Collectors.toList());
    }

    public List<Column> columns() {
        return IntStream.range(1, nbColumns+1).mapToObj(r -> Column.of(r)).collect(Collectors.toList());
    }

    public Row getFirstRow() {
        return Row.of(1);
    }

    public Row getLastRow() {
        return Row.of(nbRows);
    }

    public Column getFirstColumn() {
        return Column.of(1);
    }

    public Column getLastColumn() {
        return Column.of(nbColumns);
    }
}
