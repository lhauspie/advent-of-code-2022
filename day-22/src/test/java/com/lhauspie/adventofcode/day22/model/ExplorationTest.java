package com.lhauspie.adventofcode.day22.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplorationTest {

    static Board emptyBoard = new Board();
    static {
        // simulated input
        //   123456789
        // 1    ......
        // 2    ......
        // 3 ......
        // 4 ......
        for (int y = 1; y <= 2; y++) {
            for (int x = 4; x <= 9; x++) {
                emptyBoard.addTile(new Tile(Position.of(x, y), true));
            }
        }
        for (int y = 3; y <= 4; y++) {
            for (int x = 1; x <= 6; x++) {
                emptyBoard.addTile(new Tile(Position.of(x, y), true));
            }
        }
    }

    static Cube emptyCube = new Cube(3);
    // simulated input
    //    123456789
    //  1    ......
    //  2    ......
    //  3    ......
    //  4    ...
    //  5    ...
    //  6    ...
    //  7 ......
    //  8 ......
    //  9 ......
    // 10 ...
    // 11 ...
    // 12 ...
    static {
        for (int y = 1; y <= 3; y++) {
            for (int x = 4; x <= 9; x++) {
                emptyCube.addTile(new Tile(Position.of(x, y), true));
            }
        }
        for (int y = 4; y <= 6; y++) {
            for (int x = 4; x <= 6; x++) {
                emptyCube.addTile(new Tile(Position.of(x, y), true));
            }
        }
        for (int y = 7; y <= 9; y++) {
            for (int x = 1; x <= 6; x++) {
                emptyCube.addTile(new Tile(Position.of(x, y), true));
            }
        }
        for (int y = 10; y <= 12; y++) {
            for (int x = 1; x <= 3; x++) {
                emptyCube.addTile(new Tile(Position.of(x, y), true));
            }
        }

        emptyCube.consolidate();
    }


    static Board boardWithWalls = new Board();
    static {
        // simulated input
        //   123456789
        // 1    ...#..
        // 2    ......
        // 3 ......
        // 4 ......
        boardWithWalls.addTile(new Tile(Position.of(4, 1), true));
        boardWithWalls.addTile(new Tile(Position.of(5, 1), true));
        boardWithWalls.addTile(new Tile(Position.of(6, 1), true));
        boardWithWalls.addTile(new Tile(Position.of(7, 1), false));
        boardWithWalls.addTile(new Tile(Position.of(8, 1), true));
        boardWithWalls.addTile(new Tile(Position.of(9, 1), true));
        for (int y = 2; y <= 2; y++) {
            for (int x = 4; x <= 9; x++) {
                boardWithWalls.addTile(new Tile(Position.of(x, y), true));
            }
        }
        for (int y = 3; y <= 4; y++) {
            for (int x = 1; x <= 6; x++) {
                boardWithWalls.addTile(new Tile(Position.of(x, y), true));
            }
        }
    }

    @Test
    public void exploreEmptyBoardOne() {
        Explorer explorer = new Explorer(emptyBoard.getStartTile());
        explorer.move(1);
        assertEquals(Position.of(5, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyBoardTwo() {
        Explorer explorer = new Explorer(emptyBoard.getStartTile());
        explorer.move(10);
        assertEquals(Position.of(8, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyBoardThree() {
        Explorer explorer = new Explorer(emptyBoard.getStartTile());
        explorer.move(10);  // ==> Position.of(8, 1)
        explorer.turnClockwise(); // Face to south
        explorer.move(10);  // ==> Position.of()
        assertEquals(Position.of(8, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyBoardFour() {
        Explorer explorer = new Explorer(emptyBoard.getStartTile());
        explorer.move(10);  // ==> Position.of(8, 1)
        explorer.turnClockwise(); // Face to south
        explorer.turnClockwise(); // Face to south
        explorer.move(10);  // ==> Position.of()
        assertEquals(Position.of(4, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreBoardWithWallsOne() {
        Explorer explorer = new Explorer(boardWithWalls.getStartTile());
        explorer.move(10);
        assertEquals(Position.of(6, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyCubeOne() {
        // simulated input
        //    123456789
        //  1    >>....
        //  2    ......
        //  3    ......
        //  4    ...
        //  5    ...
        //  6    ...
        //  7 ......
        //  8 ......
        //  9 ......
        // 10 ...
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), emptyCube.getStartTile().getPosition());
        Explorer explorer = new Explorer(emptyCube.getStartTile());
        explorer.move(1);  // ==> Position.of(8, 1)
        assertEquals(Position.of(5, 1), explorer.getCurrentTile().getPosition());
    }
}
