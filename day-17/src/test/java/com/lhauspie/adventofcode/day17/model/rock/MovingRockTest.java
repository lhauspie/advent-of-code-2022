package com.lhauspie.adventofcode.day17.model.rock;

import com.lhauspie.adventofcode.day17.model.MutablePosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovingRockTest {

    @Test
    public void crossCanMoveLeft() {
        Rock rock = new CrossRock(MutablePosition.of(10, 10));
        Rock rockAfterLeftMove = new CrossRock(MutablePosition.of(9, 10));
        rock.moveLeft();
        assertTrue(rockAfterLeftMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void crossCanMoveRight() {
        Rock rock = new CrossRock(MutablePosition.of(10, 10));
        Rock rockAfterRightMove = new CrossRock(MutablePosition.of(11, 10));
        rock.moveRight();
        assertTrue(rockAfterRightMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void crossCanMoveDown() {
        Rock rock = new CrossRock(MutablePosition.of(10, 10));
        Rock rockAfterDownMove = new CrossRock(MutablePosition.of(10, 9));
        rock.moveDown();
        assertTrue(rockAfterDownMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void horizontalLineCanMoveLeft() {
        Rock rock = new HorizontalLineRock(MutablePosition.of(10, 10));
        Rock rockAfterLeftMove = new HorizontalLineRock(MutablePosition.of(9, 10));
        rock.moveLeft();
        assertTrue(rockAfterLeftMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void horizontalLineCanMoveRight() {
        Rock rock = new HorizontalLineRock(MutablePosition.of(10, 10));
        Rock rockAfterRightMove = new HorizontalLineRock(MutablePosition.of(11, 10));
        rock.moveRight();
        assertTrue(rockAfterRightMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void horizontalLineCanMoveDown() {
        Rock rock = new HorizontalLineRock(MutablePosition.of(10, 10));
        Rock rockAfterDownMove = new HorizontalLineRock(MutablePosition.of(10, 9));
        rock.moveDown();
        assertTrue(rockAfterDownMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void verticalLineCanMoveLeft() {
        Rock rock = new VerticalLineRock(MutablePosition.of(10, 10));
        Rock rockAfterLeftMove = new VerticalLineRock(MutablePosition.of(9, 10));
        rock.moveLeft();
        assertTrue(rockAfterLeftMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void verticalLineCanMoveRight() {
        Rock rock = new VerticalLineRock(MutablePosition.of(10, 10));
        Rock rockAfterRightMove = new VerticalLineRock(MutablePosition.of(11, 10));
        rock.moveRight();
        assertTrue(rockAfterRightMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void verticalLineCanMoveDown() {
        Rock rock = new VerticalLineRock(MutablePosition.of(10, 10));
        Rock rockAfterDownMove = new VerticalLineRock(MutablePosition.of(10, 9));
        rock.moveDown();
        assertTrue(rockAfterDownMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void squareLineCanMoveLeft() {
        Rock rock = new SquareRock(MutablePosition.of(10, 10));
        Rock rockAfterLeftMove = new SquareRock(MutablePosition.of(9, 10));
        rock.moveLeft();
        assertTrue(rockAfterLeftMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void squareCanMoveRight() {
        Rock rock = new SquareRock(MutablePosition.of(10, 10));
        Rock rockAfterRightMove = new SquareRock(MutablePosition.of(11, 10));
        rock.moveRight();
        assertTrue(rockAfterRightMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void squareCanMoveDown() {
        Rock rock = new SquareRock(MutablePosition.of(10, 10));
        Rock rockAfterDownMove = new SquareRock(MutablePosition.of(10, 9));
        rock.moveDown();
        assertTrue(rockAfterDownMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void rightAngleLineCanMoveLeft() {
        Rock rock = new RightAngle(MutablePosition.of(10, 10));
        Rock rockAfterLeftMove = new RightAngle(MutablePosition.of(9, 10));
        rock.moveLeft();
        assertTrue(rockAfterLeftMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void rightAngleCanMoveRight() {
        Rock rock = new RightAngle(MutablePosition.of(10, 10));
        Rock rockAfterRightMove = new RightAngle(MutablePosition.of(11, 10));
        rock.moveRight();
        assertTrue(rockAfterRightMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }

    @Test
    public void rightAngleCanMoveDown() {
        Rock rock = new RightAngle(MutablePosition.of(10, 10));
        Rock rockAfterDownMove = new RightAngle(MutablePosition.of(10, 9));
        rock.moveDown();
        assertTrue(rockAfterDownMove.getRocksPositions().containsAll(rock.getRocksPositions()));
    }
}
