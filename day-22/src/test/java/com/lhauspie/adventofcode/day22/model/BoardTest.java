package com.lhauspie.adventofcode.day22.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void testOne() {
        Board board = new Board();
        // simulated input
        // .
        board.addTile(new Tile(Position.of(1,1), true));

        Tile startTile = board.getStartTile();
        assertEquals(Position.of(1,1), startTile.getPosition());
        assertEquals(Position.of(1,1), startTile.getSouth().getPosition());
        assertEquals(Position.of(1,1), startTile.getNorth().getPosition());
        assertEquals(Position.of(1,1), startTile.getWest().getPosition());
        assertEquals(Position.of(1,1), startTile.getEast().getPosition());
    }

    @Test
    public void testTwo() {
        Board board = new Board();
        // simulated input
        // ..
        board.addTile(new Tile(Position.of(1,1), true));
        board.addTile(new Tile(Position.of(2,1), true));

        Tile startTile = board.getStartTile();
        assertEquals(Position.of(1,1), startTile.getPosition());
        assertEquals(Position.of(1,1), startTile.getSouth().getPosition());
        assertEquals(Position.of(1,1), startTile.getNorth().getPosition());
        assertEquals(Position.of(2,1), startTile.getWest().getPosition());
        assertEquals(Position.of(2,1), startTile.getEast().getPosition());
    }

    @Test
    public void testThree() {
        Board board = new Board();
        // simulated input
        // ..
        // .
        board.addTile(new Tile(Position.of(1,1), true));
        board.addTile(new Tile(Position.of(2,1), true));
        board.addTile(new Tile(Position.of(1,2), true));

        Tile startTile = board.getStartTile();
        assertEquals(Position.of(1,1), startTile.getPosition());
        assertEquals(Position.of(1,2), startTile.getSouth().getPosition());
        assertEquals(Position.of(1,2), startTile.getNorth().getPosition());
        assertEquals(Position.of(2,1), startTile.getWest().getPosition());
        assertEquals(Position.of(2,1), startTile.getEast().getPosition());
        assertEquals(Position.of(2,1), startTile.getEast().getNorth().getPosition());
    }

    @Test
    public void testFour() {
        Board board = new Board();
        // simulated input
        // ......
        // ......
        // ......
        // ......
        for (int y = 1; y <= 4; y++) {
            for (int x = 1; x <= 6; x++) {
                board.addTile(new Tile(Position.of(x,y), true));
            }
        }

        Tile startTile = board.getStartTile();
        assertEquals(Position.of(1,1), startTile.getPosition());
        assertEquals(Position.of(1,3), startTile.getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getPosition());
        assertEquals(Position.of(1,4), startTile.getNorth().getNorth().getNorth().getNorth().getNorth().getPosition());
        assertEquals(Position.of(4,1), startTile.getWest().getWest().getWest().getWest().getWest().getWest().getWest().getWest().getWest().getPosition());
        assertEquals(Position.of(3,1), startTile.getEast().getEast().getEast().getEast().getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(2,4), startTile.getEast().getNorth().getPosition());
        assertEquals(Position.of(3,3), startTile.getEast().getNorth().getEast().getNorth().getPosition());
        assertEquals(Position.of(1,3), startTile.getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getPosition());
    }

    @Test
    public void testFive() {
        Board board = new Board();
        // simulated input
        //   123456789
        // 1    ......
        // 2    ......
        // 3 ......
        // 4 ......
        for (int y = 1; y <= 2; y++) {
            for (int x = 4; x <= 9; x++) {
                board.addTile(new Tile(Position.of(x,y), true));
            }
        }
        for (int y = 3; y <= 4; y++) {
            for (int x = 1; x <= 6; x++) {
                board.addTile(new Tile(Position.of(x,y), true));
            }
        }

        Tile startTile = board.getStartTile();
        assertEquals(Position.of(4,1), startTile.getPosition());
        assertEquals(Position.of(4,3), startTile.getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getPosition());
        assertEquals(Position.of(4,4), startTile.getNorth().getNorth().getNorth().getNorth().getNorth().getPosition());
        assertEquals(Position.of(7,1), startTile.getWest().getWest().getWest().getWest().getWest().getWest().getWest().getWest().getWest().getPosition());
        assertEquals(Position.of(6,1), startTile.getEast().getEast().getEast().getEast().getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(5,4), startTile.getEast().getNorth().getPosition());
        assertEquals(Position.of(6,3), startTile.getEast().getNorth().getEast().getNorth().getPosition());
        assertEquals(Position.of(1,4), startTile.getEast().getNorth().getEast().getNorth().getEast().getNorth().getPosition());
        assertEquals(Position.of(2,3), startTile.getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getPosition());
        assertEquals(Position.of(3,4), startTile.getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getPosition());
        assertEquals(Position.of(4,3), startTile.getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getEast().getNorth().getPosition());
    }


    @Test
    public void testSix() {
        Board board = new Board();
        // simulated input
        //   123456789
        // 1    ......
        // 2    ......
        // 3 ......
        // 4 ......
        for (int y = 1; y <= 2; y++) {
            for (int x = 4; x <= 9; x++) {
                board.addTile(new Tile(Position.of(x,y), true));
            }
        }
        for (int y = 3; y <= 4; y++) {
            for (int x = 1; x <= 6; x++) {
                board.addTile(new Tile(Position.of(x,y), true));
            }
        }

        Tile startTile = board.getStartTile();
        Tile tileAfter10MovesToEast = startTile.getEast().getEast().getEast().getEast().getEast().getEast().getEast().getEast().getEast().getEast();
        Tile tileAfter10MovesToSouth = tileAfter10MovesToEast.getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getSouth();

        assertEquals(Position.of(8, 1), tileAfter10MovesToEast.getPosition());
        assertEquals(Position.of(8, 1), tileAfter10MovesToSouth.getPosition());
    }
}
