package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaveWithOneSensorTest {

    private Cave cave;
    //                1    1
    //      0    5    0    5
    // -2 ..........#..........
    // -1 .........###.........
    //  0 ........#####........
    //  1 .......#######.......
    //  2 ......#########......
    //  3 .....###########.....
    //  4 ....#############....
    //  5 ...###############...
    //  6 ..#################..
    //  7 .#########S#########.
    //  8 ..#################..
    //  9 ...###############...
    // 10 ....B############....
    // 11 .....###########.....
    // 12 ......#########......
    // 13 .......#######.......
    // 14 ........#####........
    // 15 .........###.........
    // 16 ..........#.........
    @BeforeEach
    public void init() {
        cave = new Cave();
        // Sensor at x=8, y=7: closest beacon is at x=2, y=10
        cave.addSensor(new Sensor(Position.of(8, 7), Position.of(2, 10)));
    }


    @Test
    public void testWithOneSensorFour() {
        assertEquals(5, cave.getNumberOfPositionsWhereABeaconCannotBePresent(0));
    }

    @Test
    public void testWithOneSensorFive() {
        assertEquals(12, cave.getNumberOfPositionsWhereABeaconCannotBePresent(10));
    }

    @Test
    public void testWithOneSensorOne() {
        assertEquals(11, cave.getNumberOfPositionsWhereABeaconCannotBePresent(11));
    }

    @Test
    public void testWithOneSensorTwo() {
        assertEquals(9, cave.getNumberOfPositionsWhereABeaconCannotBePresent(12));
    }

    @Test
    public void testWithOneSensorThree() {
        assertEquals(7, cave.getNumberOfPositionsWhereABeaconCannotBePresent(13));
    }

    @Test
    public void testWithOneSensorSeven() {
        assertEquals(1, cave.getNumberOfPositionsWhereABeaconCannotBePresent(16));
    }

    @Test
    public void testWithOneSensorSixOne() {
        assertEquals(0, cave.getNumberOfPositionsWhereABeaconCannotBePresent(17));
    }

    @Test
    public void testWithOneSensorSix() {
        assertEquals(0, cave.getNumberOfPositionsWhereABeaconCannotBePresent(20));
    }
}
