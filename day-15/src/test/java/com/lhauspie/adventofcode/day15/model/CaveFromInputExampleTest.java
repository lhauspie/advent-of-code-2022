package com.lhauspie.adventofcode.day15.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaveFromInputExampleTest {

    private Cave cave;

    @BeforeEach
    public void init() {
        cave = new Cave(Position.of(0, 0), Position.of(20, 20));
        // Sensor at x=2, y=18: closest beacon is at x=-2, y=15
        cave.addSensor(new Sensor(Position.of(2, 18), Position.of(-2, 15)));
        // Sensor at x=9, y=16: closest beacon is at x=10, y=16
        cave.addSensor(new Sensor(Position.of(9, 16), Position.of(10, 16)));
        // Sensor at x=13, y=2: closest beacon is at x=15, y=3
        cave.addSensor(new Sensor(Position.of(13, 2), Position.of(15, 3)));
        // Sensor at x=12, y=14: closest beacon is at x=10, y=16
        cave.addSensor(new Sensor(Position.of(12, 14), Position.of(10, 16)));
        // Sensor at x=10, y=20: closest beacon is at x=10, y=16
        cave.addSensor(new Sensor(Position.of(10, 20), Position.of(10, 16)));
        // Sensor at x=14, y=17: closest beacon is at x=10, y=16
        cave.addSensor(new Sensor(Position.of(14, 17), Position.of(10, 16)));
        // Sensor at x=8, y=7: closest beacon is at x=2, y=10
        cave.addSensor(new Sensor(Position.of(8, 7), Position.of(2, 10)));
        // Sensor at x=2, y=0: closest beacon is at x=2, y=10
        cave.addSensor(new Sensor(Position.of(2, 0), Position.of(2, 10)));
        // Sensor at x=0, y=11: closest beacon is at x=2, y=10
        cave.addSensor(new Sensor(Position.of(0, 11), Position.of(2, 10)));
        // Sensor at x=20, y=14: closest beacon is at x=25, y=17
        cave.addSensor(new Sensor(Position.of(20, 14), Position.of(25, 17)));
        // Sensor at x=17, y=20: closest beacon is at x=21, y=22
        cave.addSensor(new Sensor(Position.of(17, 20), Position.of(21, 22)));
        // Sensor at x=16, y=7: closest beacon is at x=15, y=3
        cave.addSensor(new Sensor(Position.of(16, 7), Position.of(15, 3)));
        // Sensor at x=14, y=3: closest beacon is at x=15, y=3
        cave.addSensor(new Sensor(Position.of(14, 3), Position.of(15, 3)));
        // Sensor at x=20, y=1: closest beacon is at x=15, y=3
        cave.addSensor(new Sensor(Position.of(20, 1), Position.of(15, 3)));
    }

    @Test
    public void testOne() {
        assertEquals(26, cave.getNumberOfPositionsWhereABeaconCannotBePresent(10));
    }

    @Test
    public void testTwo() {
        assertEquals(Position.of(14, 11), cave.getTheOnlyPositionNotCoveredByAtLeastOneSensor());
    }
}
