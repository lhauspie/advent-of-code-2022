package com.lhauspie.adventofcode.day17.model;

import com.lhauspie.adventofcode.day17.model.rock.CrossRock;
import com.lhauspie.adventofcode.day17.model.rock.HorizontalLineRock;
import com.lhauspie.adventofcode.day17.model.rock.Rock;
import com.lhauspie.adventofcode.day17.model.rock.VerticalLineRock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovingRockInVerticalChamberTest {

    @Test
    public void rockAdjacentToRightWallCannotMoveRight() {
        // |.......|
        // |.......|
        // |.....@.|
        // |....@@@|
        // |.....@.|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(4, 0));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        assertFalse(verticalChamber.moveRightIfPossible(rockToMove));
    }


    @Test
    public void rockNotAdjacentToRightWallCanMoveRight() {
        // |.......|
        // |.......|
        // |....@..|
        // |...@@@.|
        // |....@..|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(3, 0));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        assertTrue(verticalChamber.moveRightIfPossible(rockToMove));
    }

    @Test
    public void rockAdjacentToRockOnRightCannotMoveRight() {
        // |.......|
        // |......#|
        // |....@.#|
        // |...@@@#|
        // |....@.#|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(3, 0));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        verticalChamber.restRock(new VerticalLineRock(MutablePosition.of(6, 0)));
        assertFalse(verticalChamber.moveRightIfPossible(rockToMove));
    }

    @Test
    public void rockNotAdjacentToRockOnRightCannotMoveRight() {
        // |....@..|
        // |...@@@.|
        // |....@.#|
        // |......#|
        // |......#|
        // |......#|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(3, 3));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        verticalChamber.restRock(new VerticalLineRock(MutablePosition.of(6, 0)));
        assertTrue(verticalChamber.moveRightIfPossible(rockToMove));
    }

    @Test
    public void rockOnTheFloorCannotMoveDown() {
        // |.......|
        // |.......|
        // |...@...|
        // |..@@@..|
        // |...@...|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(2, 0));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        assertFalse(verticalChamber.moveDownIfPossible(rockToMove));
    }

    @Test
    public void rockNotOnTheFloorCanMoveDown() {
        // |.......|
        // |....@..|
        // |...@@@.|
        // |....@..|
        // |.......|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(3, 1));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        assertTrue(verticalChamber.moveDownIfPossible(rockToMove));
    }

    @Test
    public void rockOnRestingRockCannotMoveDown() {
        // |.......|
        // |....@..|
        // |...@@@.|
        // |....@..|
        // |..####.|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(3, 1));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        verticalChamber.restRock(new HorizontalLineRock(MutablePosition.of(2, 0)));
        assertFalse(verticalChamber.moveDownIfPossible(rockToMove));
    }

    @Test
    public void rockNotOnRestingRockCanMoveDown() {
        // |.......|
        // |....@..|
        // |...@@@.|
        // |....@..|
        // |.......|
        // |..####.|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(3, 2));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        verticalChamber.restRock(new VerticalLineRock(MutablePosition.of(2, 0)));
        assertTrue(verticalChamber.moveDownIfPossible(rockToMove));
    }

    @Test
    public void rockAdjacentToLeftWallCannotMoveLeft() {
        // |.......|
        // |.......|
        // |.@.....|
        // |@@@....|
        // |.@.....|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(0, 0));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        assertFalse(verticalChamber.moveLeftIfPossible(rockToMove));
    }


    @Test
    public void rockNotAdjacentToLeftWallCanMoveLeft() {
        // |.......|
        // |.......|
        // |..@....|
        // |.@@@...|
        // |..@....|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(1, 0));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        assertTrue(verticalChamber.moveLeftIfPossible(rockToMove));
    }

    @Test
    public void rockAdjacentToRockOnLeftCannotMoveLeft() {
        // |.......|
        // |#......|
        // |#.@....|
        // |#@@@...|
        // |#.@....|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(1, 0));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        verticalChamber.restRock(new HorizontalLineRock(MutablePosition.of(0, 0)));
        assertFalse(verticalChamber.moveLeftIfPossible(rockToMove));
    }

    @Test
    public void rockNotAdjacentToRockOnLeftCanMoveLeft() {
        // |..@....|
        // |.@@@...|
        // |#.@....|
        // |#......|
        // |#......|
        // |#......|
        // |_______|
        Rock rockToMove = new CrossRock(MutablePosition.of(1, 3));
        VerticalChamber verticalChamber = new VerticalChamber(7);
        verticalChamber.restRock(new VerticalLineRock(MutablePosition.of(0, 0)));
        assertTrue(verticalChamber.moveLeftIfPossible(rockToMove));
    }
}
