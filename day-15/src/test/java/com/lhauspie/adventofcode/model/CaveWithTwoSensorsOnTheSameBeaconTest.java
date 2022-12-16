package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaveWithTwoSensorsOnTheSameBeaconTest {
    private Cave cave;
    //                1    1
    //      0    5    0    5
    //  1 ............###.........
    //  2 ...........#####........
    //  3 ..........#######.......
    //  4 .........#########......
    //  5 ........###########.....
    //  6 .....#.#############....
    //  7 ....#########S#######...
    //  8 ...#################....
    //  9 ..#################.....
    // 10 .########B########......
    // 11 #####S###########.......
    // 12 .#########.#####........
    // 13 ..#######...###.........
    // 14 ...#####.....#..........
    // 15 ....###.................
    // 16 .....#.................
    @BeforeEach
    public void init() {
        cave = new Cave();
        cave.addSensor(new Sensor(Position.of(11, 7), Position.of(7, 10)));
        cave.addSensor(new Sensor(Position.of(3, 11), Position.of(7, 10)));
    }

    @Test
    public void testOne() {
        assertEquals(0, cave.getNumberOfPositionsWhereABeaconCannotBePresent(17));
    }

    @Test
    public void testTwo() {
        assertEquals(1, cave.getNumberOfPositionsWhereABeaconCannotBePresent(16));
    }

    @Test
    public void testThree() {
        assertEquals(3, cave.getNumberOfPositionsWhereABeaconCannotBePresent(1));
    }

    @Test
    public void testFour() {
        assertEquals(10, cave.getNumberOfPositionsWhereABeaconCannotBePresent(13));
    }

    @Test
    public void testFive() {
        assertEquals(17, cave.getNumberOfPositionsWhereABeaconCannotBePresent(9));
    }

    @Test
    public void testSix() {
        assertEquals(16, cave.getNumberOfPositionsWhereABeaconCannotBePresent(10));
    }
}
