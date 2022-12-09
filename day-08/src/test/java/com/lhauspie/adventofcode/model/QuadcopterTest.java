package com.lhauspie.adventofcode.model;

import com.lhauspie.adventofcode.model.grid.Column;
import com.lhauspie.adventofcode.model.grid.Coordinate;
import com.lhauspie.adventofcode.model.grid.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class QuadcopterTest {

    @Test
    public void forestTwoByTwoHasFourVisibleCoordinates1() {
        // 99
        // 99
        Forest forest = new Forest();

        // 99
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(1), Column.of(1)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(1), Column.of(2)));
        // 99
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(2), Column.of(1)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(2), Column.of(2)));

        Quadcopter quadcopter = new Quadcopter(forest);
        Assertions.assertEquals(4, quadcopter.getCoordinatesVisibleFromOutside().size());
    }

    @Test
    public void forestThreeByThreeHasSevenVisibleCoordinates() {
        // 989
        // 749
        // 999
        Forest forest = new Forest();

        // 989
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(1), Column.of(1)));
        forest.put(new Tree(Height.of(8)), new Coordinate(Row.of(1), Column.of(2)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(1), Column.of(3)));
        // 749
        forest.put(new Tree(Height.of(7)), new Coordinate(Row.of(2), Column.of(1)));
        forest.put(new Tree(Height.of(4)), new Coordinate(Row.of(2), Column.of(2)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(2), Column.of(3)));
        // 999
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(3), Column.of(1)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(3), Column.of(2)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(3), Column.of(3)));

        Quadcopter quadcopter = new Quadcopter(forest);
        Assertions.assertEquals(8, quadcopter.getCoordinatesVisibleFromOutside().size());
    }

    @Test
    public void forestFourByFourHasSevenVisibleCoordinates() {
        // 9891
        // 7492
        // 9993
        // 4567
        Forest forest = new Forest();

        // 9891
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(1), Column.of(1)));
        forest.put(new Tree(Height.of(8)), new Coordinate(Row.of(1), Column.of(2)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(1), Column.of(3)));
        forest.put(new Tree(Height.of(1)), new Coordinate(Row.of(1), Column.of(4)));
        // 7492
        forest.put(new Tree(Height.of(7)), new Coordinate(Row.of(2), Column.of(1)));
        forest.put(new Tree(Height.of(4)), new Coordinate(Row.of(2), Column.of(2)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(2), Column.of(3)));
        forest.put(new Tree(Height.of(2)), new Coordinate(Row.of(2), Column.of(4)));
        // 9993
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(3), Column.of(1)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(3), Column.of(2)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(3), Column.of(3)));
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(3), Column.of(4)));
        // 4567
        forest.put(new Tree(Height.of(4)), new Coordinate(Row.of(4), Column.of(1)));
        forest.put(new Tree(Height.of(5)), new Coordinate(Row.of(4), Column.of(2)));
        forest.put(new Tree(Height.of(6)), new Coordinate(Row.of(4), Column.of(3)));
        forest.put(new Tree(Height.of(7)), new Coordinate(Row.of(4), Column.of(4)));

        Quadcopter quadcopter = new Quadcopter(forest);
        Assertions.assertEquals(15, quadcopter.getCoordinatesVisibleFromOutside().size());
    }

    @Test
    public void exampleForestHasTwentyOneVisibleCoordinates() {
        Forest forest = getExampleForest();

        Quadcopter quadcopter = new Quadcopter(forest);
        Assertions.assertEquals(21, quadcopter.getCoordinatesVisibleFromOutside().size());
    }

    @Test
    public void exampleForestHasScenicScoreOfFourForTreeAtRowTwoAndColumnThree() {
        Forest forest = getExampleForest();

        Quadcopter quadcopter = new Quadcopter(forest);
        Map<Coordinate, ScenicScore> scenicScores = quadcopter.getScenicScores();
        Assertions.assertEquals(ScenicScore.of(4), scenicScores.get(new Coordinate(Row.of(2), Column.of(3))));
    }

    @Test
    public void exampleForestHasScenicScoreOfEightForTreeAtRowFourAndColumnThree() {
        Forest forest = getExampleForest();

        Quadcopter quadcopter = new Quadcopter(forest);
        Map<Coordinate, ScenicScore> scenicScores = quadcopter.getScenicScores();
        Assertions.assertEquals(ScenicScore.of(8), scenicScores.get(new Coordinate(Row.of(4), Column.of(3))));
    }

    private Forest getExampleForest() {
        // 30373
        // 25512
        // 65332
        // 33549
        // 35390
        Forest forest = new Forest();

        // 30373
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(1), Column.of(1)));
        forest.put(new Tree(Height.of(0)), new Coordinate(Row.of(1), Column.of(2)));
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(1), Column.of(3)));
        forest.put(new Tree(Height.of(7)), new Coordinate(Row.of(1), Column.of(4)));
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(1), Column.of(5)));
        // 25512
        forest.put(new Tree(Height.of(2)), new Coordinate(Row.of(2), Column.of(1)));
        forest.put(new Tree(Height.of(5)), new Coordinate(Row.of(2), Column.of(2)));
        forest.put(new Tree(Height.of(5)), new Coordinate(Row.of(2), Column.of(3)));
        forest.put(new Tree(Height.of(1)), new Coordinate(Row.of(2), Column.of(4)));
        forest.put(new Tree(Height.of(2)), new Coordinate(Row.of(2), Column.of(5)));
        // 65332
        forest.put(new Tree(Height.of(6)), new Coordinate(Row.of(3), Column.of(1)));
        forest.put(new Tree(Height.of(5)), new Coordinate(Row.of(3), Column.of(2)));
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(3), Column.of(3)));
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(3), Column.of(4)));
        forest.put(new Tree(Height.of(2)), new Coordinate(Row.of(3), Column.of(5)));
        // 33549
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(4), Column.of(1)));
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(4), Column.of(2)));
        forest.put(new Tree(Height.of(5)), new Coordinate(Row.of(4), Column.of(3)));
        forest.put(new Tree(Height.of(4)), new Coordinate(Row.of(4), Column.of(4)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(4), Column.of(5)));
        // 35390
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(5), Column.of(1)));
        forest.put(new Tree(Height.of(5)), new Coordinate(Row.of(5), Column.of(2)));
        forest.put(new Tree(Height.of(3)), new Coordinate(Row.of(5), Column.of(3)));
        forest.put(new Tree(Height.of(9)), new Coordinate(Row.of(5), Column.of(4)));
        forest.put(new Tree(Height.of(0)), new Coordinate(Row.of(5), Column.of(5)));
        return forest;
    }
}
