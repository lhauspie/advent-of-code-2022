package com.lhauspie.adventofcode.day22.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

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

    static Cube cubeWithWalls = new Cube(3);
    // simulated input
    //    123456789
    //  1    ......
    //  2    ......
    //  3    ......
    //  4    ...
    //  5    ...
    //  6    ...
    //  7 ......
    //  8 .....#
    //  9 #..#..
    // 10 ...
    // 11 ...
    // 12 ...
    static Set<Position> cubeWalls = Set.of(Position.of(6, 8), Position.of(1, 9), Position.of(4, 9));
    static {
        for (int y = 1; y <= 3; y++) {
            for (int x = 4; x <= 9; x++) {
                cubeWithWalls.addTile(new Tile(Position.of(x, y), !cubeWalls.contains(Position.of(x, y))));
            }
        }
        for (int y = 4; y <= 6; y++) {
            for (int x = 4; x <= 6; x++) {
                cubeWithWalls.addTile(new Tile(Position.of(x, y), !cubeWalls.contains(Position.of(x, y))));
            }
        }
        for (int y = 7; y <= 9; y++) {
            for (int x = 1; x <= 6; x++) {
                cubeWithWalls.addTile(new Tile(Position.of(x, y), !cubeWalls.contains(Position.of(x, y))));
            }
        }
        for (int y = 10; y <= 12; y++) {
            for (int x = 1; x <= 3; x++) {
                cubeWithWalls.addTile(new Tile(Position.of(x, y), !cubeWalls.contains(Position.of(x, y))));
            }
        }

        cubeWithWalls.consolidate();
    }

    @Test
    public void exploreEmptyBoardOne() {
        BoardExplorer explorer = new BoardExplorer(emptyBoard);
        explorer.move(1);
        assertEquals(Position.of(5, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyBoardTwo() {
        BoardExplorer explorer = new BoardExplorer(emptyBoard);
        explorer.move(10);
        assertEquals(Position.of(8, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyBoardThree() {
        BoardExplorer explorer = new BoardExplorer(emptyBoard);
        explorer.move(10);  // ==> Position.of(8, 1)
        explorer.turnClockwise(); // Face to south
        explorer.move(10);  // ==> Position.of()
        assertEquals(Position.of(8, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyBoardFour() {
        BoardExplorer explorer = new BoardExplorer(emptyBoard);
        explorer.move(10);  // ==> Position.of(8, 1)
        explorer.turnClockwise(); // Face to south
        explorer.turnClockwise(); // Face to south
        explorer.move(10);  // ==> Position.of()
        assertEquals(Position.of(4, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreBoardWithWallsOne() {
        BoardExplorer explorer = new BoardExplorer(boardWithWalls);
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
        CubeExplorer explorer = new CubeExplorer(emptyCube);
        explorer.move(1);  // ==> Position.of(8, 1)
        assertEquals(Position.of(5, 1), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyCubeTwo() {
        // simulated input
        //    123456789
        //  1    >>>>>>
        //  2    ......
        //  3    ......
        //  4    ...
        //  5    ...
        //  6    ...
        //  7 ......
        //  8 ......
        //  9 .<<<<<
        // 10 ...
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), emptyCube.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(emptyCube);
        explorer.move(10);  // ==> Position.of(8, 1)
        assertEquals(Position.of(2, 9), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyCubeThree() {
        // simulated input
        //    123456789
        //  1    V.....
        //  2    >>>>>>
        //  3    ......
        //  4    ...
        //  5    ...
        //  6    ...
        //  7 ......
        //  8 ..<<<<
        //  9 ......
        // 10 ...
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), emptyCube.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(emptyCube);
        explorer.turnClockwise();
        explorer.move(1);
        explorer.turnCounterclockwise();
        explorer.move(9);
        assertEquals(Position.of(3, 8), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyCubeFour() {
        // simulated input
        //    123456789
        //  1    V.....
        //  2    V.....
        //  3    >>>>>>
        //  4    ...
        //  5    ...
        //  6    ...
        //  7 .<<<<<
        //  8 ......
        //  9 ......
        // 10 ...
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), emptyCube.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(emptyCube);
        explorer.turnClockwise();
        explorer.move(2);
        explorer.turnCounterclockwise();
        explorer.move(10);
        assertEquals(Position.of(2, 7), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyCubeFive() {
        // simulated input
        //    123456789
        //  1    V.....
        //  2    V.....
        //  3    >>>>>>
        //  4    ...
        //  5    ...
        //  6    ...
        //  7 <<<<<<
        //  8 ......
        //  9 ......
        // 10 ...
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), emptyCube.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(emptyCube);
        explorer.turnClockwise();
        explorer.move(2);
        explorer.turnCounterclockwise();
        explorer.move(15);
        assertEquals(Position.of(7, 3), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyCubeSix() {
        // simulated input
        //    123456789
        //  1    V.....
        //  2    V.....
        //  3    V.....
        //  4    V..
        //  5    V..
        //  6    V..
        //  7 ...V..
        //  8 ...V..
        //  9 ...V..
        // 10 <<<
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), emptyCube.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(emptyCube);
        explorer.turnClockwise();
        explorer.move(15);
        assertEquals(Position.of(4, 4), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyCubeSeven() {
        // simulated input
        //    123456789
        //  1    >>>>V.
        //  2    ....V.
        //  3    ....V.
        //  4    ...
        //  5    <<<
        //  6    ...
        //  7 .V....
        //  8 .V....
        //  9 .V....
        // 10 .V.
        // 11 .V.
        // 12 .V.
        assertEquals(Position.of(4, 1), emptyCube.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(emptyCube);
        explorer.move(4);
        explorer.turnClockwise();
        explorer.move(15);
        assertEquals(Position.of(6, 5), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreEmptyCubeEight() {
        // simulated input
        //    123456789
        //  1    ^.....
        //  2    ^.....
        //  3    ^.....
        //  4    ^..
        //  5    ^..
        //  6    ^..
        //  7 ...^..
        //  8 ...^..
        //  9 ...^..
        // 10 >>>
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), emptyCube.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(emptyCube);
        explorer.turnCounterclockwise();
        explorer.move(15);
        assertEquals(Position.of(3, 10), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreCubeWithWallsOne() {
        // simulated input
        //    123456789
        //  1    >>>>>>
        //  2    ......
        //  3    ......
        //  4    ...
        //  5    ...
        //  6    ...
        //  7 ......
        //  8 .....#
        //  9 #..#<<
        // 10 ...
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), cubeWithWalls.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(cubeWithWalls);
        explorer.move(15);
        assertEquals(Position.of(5, 9), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreCubeWithWallsTwo() {
        // simulated input
        //    123456789
        //  1    V.....
        //  2    >>>>>>
        //  3    ......
        //  4    ...
        //  5    ...
        //  6    ...
        //  7 ......
        //  8 .....#
        //  9 #..#..
        // 10 ...
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), cubeWithWalls.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(cubeWithWalls);
        explorer.turnClockwise();
        explorer.move(1);
        explorer.turnCounterclockwise();
        explorer.move(15);
        assertEquals(Position.of(9, 2), explorer.getCurrentTile().getPosition());
    }

    @Test
    public void exploreCubeWithWallsThree() {
        // simulated input
        //    123456789
        //  1    ^.....
        //  2    ......
        //  3    ......
        //  4    ...
        //  5    ...
        //  6    ...
        //  7 ......
        //  8 .....#
        //  9 #..#..
        // 10 >>>
        // 11 ...
        // 12 ...
        assertEquals(Position.of(4, 1), cubeWithWalls.getStartTile().getPosition());
        CubeExplorer explorer = new CubeExplorer(cubeWithWalls);
        explorer.turnCounterclockwise();
        explorer.move(20);
        assertEquals(Position.of(3, 10), explorer.getCurrentTile().getPosition());
    }
}
