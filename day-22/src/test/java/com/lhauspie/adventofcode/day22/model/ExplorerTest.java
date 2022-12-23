package com.lhauspie.adventofcode.day22.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExplorerTest {

    @Test
    public void newExplorerMustFaceToEast() {
        Explorer explorer = new Explorer(new Tile(Position.of(1, 1), true));
        Assertions.assertEquals(Facing.EAST, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToNorthAfterTurningCounterclockwise() {
        Explorer explorer = new Explorer(new Tile(Position.of(1, 1), true));
        explorer.turnCounterclockwise();
        Assertions.assertEquals(Facing.NORTH, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToWestAfterTurningCounterclockwiseTwice() {
        Explorer explorer = new Explorer(new Tile(Position.of(1, 1), true));
        explorer.turnCounterclockwise();
        explorer.turnCounterclockwise();
        Assertions.assertEquals(Facing.WEST, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToSouthAfterTurningCounterclockwiseThrice() {
        Explorer explorer = new Explorer(new Tile(Position.of(1, 1), true));
        explorer.turnCounterclockwise();
        explorer.turnCounterclockwise();
        explorer.turnCounterclockwise();
        Assertions.assertEquals(Facing.SOUTH, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToSouthAfterTurningClockwise() {
        Explorer explorer = new Explorer(new Tile(Position.of(1, 1), true));
        explorer.turnClockwise();
        Assertions.assertEquals(Facing.SOUTH, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToWestAfterTurningClockwiseTwice() {
        Explorer explorer = new Explorer(new Tile(Position.of(1, 1), true));
        explorer.turnClockwise();
        explorer.turnClockwise();
        Assertions.assertEquals(Facing.WEST, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToNorthAfterTurningCounterclockwiseThrice() {
        Explorer explorer = new Explorer(new Tile(Position.of(1, 1), true));
        explorer.turnClockwise();
        explorer.turnClockwise();
        explorer.turnClockwise();
        Assertions.assertEquals(Facing.NORTH, explorer.getFacing());
    }
}
