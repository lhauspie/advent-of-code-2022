package com.lhauspie.adventofcode.day17.model.rock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RockFactoryTest {

    @Test
    public void firstRockBuildByFactoryIsHorizontalLine() {
        RockFactory rockFactory = new RockFactory();
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof HorizontalLineRock);
    }

    @Test
    public void secondRockBuildByFactoryIsCross() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof CrossRock);
    }

    @Test
    public void thirdRockBuildByFactoryIsRightAngle() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof RightAngle);
    }

    @Test
    public void fourthRockBuildByFactoryIsVerticalLine() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof VerticalLineRock);
    }

    @Test
    public void fifthRockBuildByFactoryIsVerticalLine() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof SquareRock);
    }

    @Test
    public void sixthRockBuildByFactoryIsHorizontalLine() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof HorizontalLineRock);
    }

    @Test
    public void seventhRockBuildByFactoryIsCross() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof CrossRock);
    }

    @Test
    public void eighthRockBuildByFactoryIsRightAngle() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof RightAngle);
    }

    @Test
    public void ninthRockBuildByFactoryIsVerticalLine() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof VerticalLineRock);
    }

    @Test
    public void tenthRockBuildByFactoryIsVerticalLine() {
        RockFactory rockFactory = new RockFactory();
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        rockFactory.createRock(0, 0);
        Rock rock = rockFactory.createRock(0, 0);
        assertTrue(rock instanceof SquareRock);
    }
}
