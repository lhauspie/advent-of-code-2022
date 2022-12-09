package com.lhauspie.adventofcode.model;

import com.lhauspie.adventofcode.model.grid.Column;
import com.lhauspie.adventofcode.model.grid.Coordinate;
import com.lhauspie.adventofcode.model.grid.Grid;
import com.lhauspie.adventofcode.model.grid.Row;

import java.util.List;

public class Forest {

    private Grid<Tree> trees = new Grid<>();

    public Tree treeAt(Coordinate coordinate) {
        return trees.getItemAt(coordinate);
    }

    public List<Row> rows() {
        return trees.rows();
    }

    public List<Column> columns() {
        return trees.columns();
    }

    public void put(Tree tree, Coordinate coordinate) {
        trees.put(tree, coordinate);
    }

    public boolean isEdge(Coordinate coordinate) {
        return trees.isEdge(coordinate);
    }
}
