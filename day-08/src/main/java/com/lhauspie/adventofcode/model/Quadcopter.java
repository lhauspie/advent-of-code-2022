package com.lhauspie.adventofcode.model;

import com.lhauspie.adventofcode.model.grid.Column;
import com.lhauspie.adventofcode.model.grid.Coordinate;
import com.lhauspie.adventofcode.model.grid.Row;

import java.util.*;

import static com.lhauspie.adventofcode.model.Quadcopter.Direction.*;

public class Quadcopter {
    private final Forest forest;

    public Quadcopter(Forest forest) {
        this.forest = forest;
    }

    enum Direction {
        LEFT(coordinate -> coordinate.left()),
        RIGHT(coordinate -> coordinate.right()),
        TOP(coordinate -> coordinate.up()),
        BOTTOM(coordinate -> coordinate.down());

        private CoordinateMover mover;

        Direction(CoordinateMover mover) {
            this.mover = mover;
        }

        public Coordinate move(Coordinate coordinate) {
            return mover.move(coordinate);
        }
    }

    @FunctionalInterface
    interface CoordinateMover {
        Coordinate move(Coordinate coordinate);
    }

    public Set<Coordinate> getCoordinatesVisibleFromOutside() {
        Set<Coordinate> visibleCoordinates = new HashSet<>();

        List<Row> rows = forest.rows();
        List<Column> columns = forest.columns();
        for (Row row : rows) {
            for (Column column : columns) {
                Coordinate coordinate = new Coordinate(row, column);
                if (treeIsVisibleFromOutside(coordinate)) {
                    visibleCoordinates.add(coordinate);
                }
            }
        }

        return visibleCoordinates;
    }

    public Map<Coordinate, ScenicScore> getScenicScores() {
        Map<Coordinate, ScenicScore> scenicScores = new HashMap<>();

        List<Row> rows = forest.rows();
        List<Column> columns = forest.columns();
        for (Row row : rows) {
            for (Column column : columns) {
                Coordinate coordinate = new Coordinate(row, column);
                scenicScores.put(coordinate, getScenicScore(coordinate));
            }
        }

        return scenicScores;
    }

    private boolean treeIsVisibleFromOutside(Coordinate coordinate) {
        return treeIsVisibleFrom(LEFT, coordinate)
                || treeIsVisibleFrom(TOP, coordinate)
                || treeIsVisibleFrom(RIGHT, coordinate)
                || treeIsVisibleFrom(BOTTOM, coordinate);
    }

    private ScenicScore getScenicScore(Coordinate coordinate) {
        return ScenicScore.of(
                getViewingDistanceLookingTo(LEFT, coordinate),
                getViewingDistanceLookingTo(TOP, coordinate),
                getViewingDistanceLookingTo(RIGHT, coordinate),
                getViewingDistanceLookingTo(BOTTOM, coordinate)
        );
    }

    private boolean treeIsVisibleFrom(Direction direction, Coordinate coordinate) {
        if (forest.isEdge(coordinate)) {
            return true;
        }

        Tree initialTree = forest.treeAt(coordinate);
        Coordinate movingCoordinate = coordinate;
        do {
            movingCoordinate = direction.move(movingCoordinate);
            Tree treeToBeCompared = forest.treeAt(movingCoordinate);
            if (!treeToBeCompared.isShorterThan(initialTree)) {
                return false;
            }
        } while (!forest.isEdge(movingCoordinate));

        return true;
    }

    private ViewingDistance getViewingDistanceLookingTo(Direction direction, Coordinate coordinate) {
        if (forest.isEdge(coordinate)) {
            return ViewingDistance.of(0);
        }

        int count = 0;
        Tree initialTree = forest.treeAt(coordinate);
        Coordinate movingCoordinate = coordinate;
        Tree treeToBeCompared;
        do {
            movingCoordinate = direction.move(movingCoordinate);
            treeToBeCompared = forest.treeAt(movingCoordinate);
            count++;
        } while (!forest.isEdge(movingCoordinate) && treeToBeCompared.isShorterThan(initialTree));

        return ViewingDistance.of(count);
    }
}
