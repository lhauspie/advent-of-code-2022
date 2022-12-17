package com.lhauspie.adventofcode.day15.model;

import com.lhauspie.adventofcode.day15.model.Position;
import com.lhauspie.adventofcode.day15.model.Sensor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SensorTest {

    @Test
    public void manhattanDistanceOne() {
        var sensor = new Sensor(Position.of(0, 0), Position.of(0, 0));

        Assertions.assertEquals(0, sensor.getManhattanDistanceToBeacon());
    }

    @Test
    public void manhattanDistanceTwo() {
        var sensor = new Sensor(Position.of(0, 0), Position.of(0, 1));

        Assertions.assertEquals(1, sensor.getManhattanDistanceToBeacon());
    }

    @Test
    public void manhattanDistanceThree() {
        var sensor = new Sensor(Position.of(0, 1), Position.of(0, -1));

        Assertions.assertEquals(2, sensor.getManhattanDistanceToBeacon());
    }

    @Test
    public void manhattanDistanceFour() {
        var sensor = new Sensor(Position.of(0, 0), Position.of(1, 0));

        Assertions.assertEquals(1, sensor.getManhattanDistanceToBeacon());
    }

    @Test
    public void manhattanDistanceFive() {
        var sensor = new Sensor(Position.of(1, 0), Position.of(-1, 0));

        Assertions.assertEquals(2, sensor.getManhattanDistanceToBeacon());
    }

    @Test
    public void manhattanDistanceSix() {
        var sensor = new Sensor(Position.of(-5, -5), Position.of(5, 5));
        // .......S..................
        // .......#..................
        // .......#..................
        // .......#..................
        // .......#..................
        // .......#..................
        // .......#..................
        // .......#..................
        // .......#..................
        // .......#..................
        // .......###########B.......
        // ..........................
        // ..........................
        Assertions.assertEquals(20, sensor.getManhattanDistanceToBeacon());
    }
}
