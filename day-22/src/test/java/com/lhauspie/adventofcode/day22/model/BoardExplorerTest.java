package com.lhauspie.adventofcode.day22.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardExplorerTest {

    @Test
    public void newExplorerMustFaceToEast() {
        BoardExplorer explorer = new BoardExplorer();
        Assertions.assertEquals(Facing.EAST, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToNorthAfterTurningCounterclockwise() {
        BoardExplorer explorer = new BoardExplorer();
        explorer.turnCounterclockwise();
        Assertions.assertEquals(Facing.NORTH, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToWestAfterTurningCounterclockwiseTwice() {
        BoardExplorer explorer = new BoardExplorer();
        explorer.turnCounterclockwise();
        explorer.turnCounterclockwise();
        Assertions.assertEquals(Facing.WEST, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToSouthAfterTurningCounterclockwiseThrice() {
        BoardExplorer explorer = new BoardExplorer();
        explorer.turnCounterclockwise();
        explorer.turnCounterclockwise();
        explorer.turnCounterclockwise();
        Assertions.assertEquals(Facing.SOUTH, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToSouthAfterTurningClockwise() {
        BoardExplorer explorer = new BoardExplorer();
        explorer.turnClockwise();
        Assertions.assertEquals(Facing.SOUTH, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToWestAfterTurningClockwiseTwice() {
        BoardExplorer explorer = new BoardExplorer();
        explorer.turnClockwise();
        explorer.turnClockwise();
        Assertions.assertEquals(Facing.WEST, explorer.getFacing());
    }

    @Test
    public void explorerMustFaceToNorthAfterTurningCounterclockwiseThrice() {
        BoardExplorer explorer = new BoardExplorer();
        explorer.turnClockwise();
        explorer.turnClockwise();
        explorer.turnClockwise();
        Assertions.assertEquals(Facing.NORTH, explorer.getFacing());
    }
}
