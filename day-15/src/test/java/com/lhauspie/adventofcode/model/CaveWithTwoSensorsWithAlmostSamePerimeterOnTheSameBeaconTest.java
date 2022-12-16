package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaveWithTwoSensorsWithAlmostSamePerimeterOnTheSameBeaconTest {
    private Cave cave;
    //                1    1
    //      0    5    0    5
    //  1 ............###.........
    //  2 ...........#####........
    //  3 ..........#######.......
    //  4 .........#########......
    //  5 ........###########.....
    //  6 .......#############....
    //  7 ......#######S#######...
    //  8 .......#############....
    //  9 ........###########.....
    // 10 .........B####S#####....
    // 11 ..........#########.....
    // 12 ...........#######......
    // 13 ............#####.......
    // 14 .............###........
    // 15 ..............#.........
    // 16 ........................
    @BeforeEach
    public void init() {
        cave = new Cave();
        cave.addSensor(new Sensor(Position.of(11, 7), Position.of(7, 10)));
        cave.addSensor(new Sensor(Position.of(12, 10), Position.of(7, 10)));
    }

    @Test
    public void testTwo() {
        assertEquals(0, cave.getNumberOfPositionsWhereABeaconCannotBePresent(16));
    }

    @Test
    public void testThree() {
        assertEquals(3, cave.getNumberOfPositionsWhereABeaconCannotBePresent(1));
    }

    @Test
    public void testFour() {
        assertEquals(5, cave.getNumberOfPositionsWhereABeaconCannotBePresent(13));
    }

    @Test
    public void testFive() {
        assertEquals(11, cave.getNumberOfPositionsWhereABeaconCannotBePresent(9));
    }

    @Test
    public void testSix() {
        assertEquals(10, cave.getNumberOfPositionsWhereABeaconCannotBePresent(10));
    }
}
