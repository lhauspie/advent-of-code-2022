package com.lhauspie.adventofcode.day23.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ElfTest {

    private static final PositionFactory positionFactory = PositionFactory.getInstance();

    @Test
    public void elfWithoutNeighboursWillNotMove() {
        Elf elf = new Elf(positionFactory.create(1, 1));

        assertFalse(elf.chooseNextPosition(new ArrayList<>(), Direction.NORTH));
        assertFalse(elf.chooseNextPosition(new ArrayList<>(), Direction.SOUTH));
        assertFalse(elf.chooseNextPosition(new ArrayList<>(), Direction.WEST));
        assertFalse(elf.chooseNextPosition(new ArrayList<>(), Direction.EAST));
    }

    @Test
    public void elfWithNeighboursWillMove() {
        Elf elf = new Elf(positionFactory.create(1, 1));
        List<Elf> elfsNeighbours = List.of(new Elf(positionFactory.down(elf.getPosition())));

        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.NORTH));
        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.SOUTH));
        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.WEST));
        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.EAST));
    }

    @Test
    public void elfWithoutNorthNeighbourWillMoveToNorth() {
        Elf elf = new Elf(PositionFactory.getInstance().create(1, 1));
        List<Elf> elfsNeighbours = List.of(
                new Elf(positionFactory.down(elf.getPosition()))
        );

        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.NORTH));
        assertEquals(PositionFactory.getInstance().create(1, 0), elf.getNextPosition());
    }

    @Test
    public void elfWithNorthNeighboursWillMoveToSouth() {
        Elf elf = new Elf(PositionFactory.getInstance().create(1, 1));
        List<Elf> elfsNeighbours = List.of(
                new Elf(positionFactory.up(elf.getPosition())),
                new Elf(positionFactory.upLeft(elf.getPosition())),
                new Elf(positionFactory.upRight(elf.getPosition()))
        );

        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.NORTH));
        assertEquals(PositionFactory.getInstance().create(1, 2), elf.getNextPosition());
    }

    @Test
    public void elfWithNorthAndSouthNeighboursWillMoveToWest() {
        Elf elf = new Elf(PositionFactory.getInstance().create(1, 1));
        List<Elf> elfsNeighbours = List.of(
                new Elf(positionFactory.up(elf.getPosition())),
                new Elf(positionFactory.down(elf.getPosition()))
        );

        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.NORTH));
        assertEquals(PositionFactory.getInstance().create(0, 1), elf.getNextPosition());
    }

    @Test
    public void elfWithNorthAndSouthAndWestNeighboursWillMoveToEast() {
        Elf elf = new Elf(PositionFactory.getInstance().create(1, 1));
        List<Elf> elfsNeighbours = List.of(
                new Elf(positionFactory.up(elf.getPosition())),
                new Elf(positionFactory.down(elf.getPosition())),
                new Elf(positionFactory.left(elf.getPosition()))
        );

        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.NORTH));
        assertEquals(PositionFactory.getInstance().create(2, 1), elf.getNextPosition());
    }

    @Test
    public void elfWithNorthAndSouthAndWestAndEastNeighboursWillNotMove() {
        Elf elf = new Elf(PositionFactory.getInstance().create(1, 1));
        List<Elf> elfsNeighbours = List.of(
                new Elf(positionFactory.up(elf.getPosition())),
                new Elf(positionFactory.upLeft(elf.getPosition())),
                new Elf(positionFactory.upRight(elf.getPosition())),
                new Elf(positionFactory.down(elf.getPosition())),
                new Elf(positionFactory.downLeft(elf.getPosition())),
                new Elf(positionFactory.downRight(elf.getPosition())),
                new Elf(positionFactory.left(elf.getPosition())),
                new Elf(positionFactory.right(elf.getPosition()))
        );

        assertFalse(elf.chooseNextPosition(elfsNeighbours, Direction.NORTH));
        assertEquals(null, elf.getNextPosition());
    }

    @Test
    public void elfWithoutSouthNeighboursWillMoveToSouth() {
        Elf elf = new Elf(PositionFactory.getInstance().create(1, 1));
        List<Elf> elfsNeighbours = List.of(
                new Elf(positionFactory.up(elf.getPosition())),
                new Elf(positionFactory.upLeft(elf.getPosition())),
                new Elf(positionFactory.upRight(elf.getPosition()))
        );

        assertTrue(elf.chooseNextPosition(elfsNeighbours, Direction.SOUTH));
        assertEquals(PositionFactory.getInstance().create(1, 2), elf.getNextPosition());
    }

    @Test
    public void elfCannotMoveIfOtherElvesChooseTheSameNextPosition() {
        // Simulated Situation
        //   1234
        // 1 ##..
        // 2 ....
        // 3 ##..
        // 4 ....
        Elf elf1 = new Elf(PositionFactory.getInstance().create(1, 3));
        Elf elf2 = new Elf(PositionFactory.getInstance().create(1, 1));

        assertTrue(elf1.chooseNextPosition(List.of(new Elf(positionFactory.right(elf1.getPosition()))), Direction.NORTH));
        assertTrue(elf2.chooseNextPosition(List.of(new Elf(positionFactory.right(elf2.getPosition()))), Direction.SOUTH));

        assertEquals(PositionFactory.getInstance().create(1, 2), elf1.getNextPosition());
        assertEquals(PositionFactory.getInstance().create(1, 2), elf2.getNextPosition());

        elf1.cancelMoveIfCollision(List.of(elf2));
        elf2.cancelMoveIfCollision(List.of(elf1));

        assertFalse(elf1.move());
        assertFalse(elf2.move());
        assertEquals(PositionFactory.getInstance().create(1, 3), elf1.getPosition());
        assertEquals(PositionFactory.getInstance().create(1, 1), elf2.getPosition());
    }

    @Test
    public void elfCanMoveIfNoOtherElvesChooseTheSameNextPosition() {
        // Simulated Situation
        //   1234
        // 1 ....
        // 2 ##..
        // 3 ....
        // 4 ##..
        Elf elf1 = new Elf(PositionFactory.getInstance().create(1, 4));
        Elf elf2 = new Elf(PositionFactory.getInstance().create(1, 2));

        assertTrue(elf1.chooseNextPosition(List.of(new Elf(positionFactory.right(elf1.getPosition()))), Direction.NORTH));
        assertTrue(elf2.chooseNextPosition(List.of(new Elf(positionFactory.right(elf2.getPosition()))), Direction.NORTH));

        assertEquals(PositionFactory.getInstance().create(1, 3), elf1.getNextPosition());
        assertEquals(PositionFactory.getInstance().create(1, 1), elf2.getNextPosition());

        elf1.cancelMoveIfCollision(List.of(elf2));
        elf2.cancelMoveIfCollision(List.of(elf1));

        assertTrue(elf1.move());
        assertTrue(elf2.move());

        assertEquals(PositionFactory.getInstance().create(1, 3), elf1.getPosition());
        assertEquals(PositionFactory.getInstance().create(1, 1), elf2.getPosition());
    }
}
