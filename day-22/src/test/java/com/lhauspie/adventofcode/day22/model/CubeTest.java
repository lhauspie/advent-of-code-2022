package com.lhauspie.adventofcode.day22.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeTest {

    private Cube cubeOfSize1;
    private Cube cubeOfSize2;

    @BeforeEach
    public void init() {
        cubeOfSize1 = new Cube(1);
        // simulated input
        //  ..    12
        //  .     3
        // ..    45
        // .     6
        cubeOfSize1.addTile(new Tile(Position.of(2,1), true));
        cubeOfSize1.addTile(new Tile(Position.of(3,1), true));
        cubeOfSize1.addTile(new Tile(Position.of(2,2), true));
        cubeOfSize1.addTile(new Tile(Position.of(1,3), true));
        cubeOfSize1.addTile(new Tile(Position.of(2,3), true));
        cubeOfSize1.addTile(new Tile(Position.of(1,4), true));

        cubeOfSize1.consolidate();

        cubeOfSize2 = new Cube(2);
        // simulated input
        //   123456
        // 1   ....     1122
        // 2   ....     1122
        // 3   ..       33
        // 4   ..       33
        // 5 ....     4455
        // 6 ....     4455
        // 7 ..       66
        // 8 ..       66
        cubeOfSize2.addTile(new Tile(Position.of(3,1), true));
        cubeOfSize2.addTile(new Tile(Position.of(4,1), true));
        cubeOfSize2.addTile(new Tile(Position.of(5,1), true));
        cubeOfSize2.addTile(new Tile(Position.of(6,1), true));
        cubeOfSize2.addTile(new Tile(Position.of(3,2), true));
        cubeOfSize2.addTile(new Tile(Position.of(4,2), true));
        cubeOfSize2.addTile(new Tile(Position.of(5,2), true));
        cubeOfSize2.addTile(new Tile(Position.of(6,2), true));

        cubeOfSize2.addTile(new Tile(Position.of(3,3), true));
        cubeOfSize2.addTile(new Tile(Position.of(4,3), true));
        cubeOfSize2.addTile(new Tile(Position.of(3,4), true));
        cubeOfSize2.addTile(new Tile(Position.of(4,4), true));

        cubeOfSize2.addTile(new Tile(Position.of(1,5), true));
        cubeOfSize2.addTile(new Tile(Position.of(2,5), true));
        cubeOfSize2.addTile(new Tile(Position.of(3,5), true));
        cubeOfSize2.addTile(new Tile(Position.of(4,5), true));
        cubeOfSize2.addTile(new Tile(Position.of(1,6), true));
        cubeOfSize2.addTile(new Tile(Position.of(2,6), true));
        cubeOfSize2.addTile(new Tile(Position.of(3,6), true));
        cubeOfSize2.addTile(new Tile(Position.of(4,6), true));

        cubeOfSize2.addTile(new Tile(Position.of(1,7), true));
        cubeOfSize2.addTile(new Tile(Position.of(2,7), true));
        cubeOfSize2.addTile(new Tile(Position.of(1,8), true));
        cubeOfSize2.addTile(new Tile(Position.of(2,8), true));

        cubeOfSize2.consolidate();
    }

    @Test
    public void testCubeOfSizeOneOne() {
        Tile startTile = cubeOfSize1.getStartTile();
        assertEquals(Position.of(2,1), startTile.getPosition());
        assertEquals(Position.of(2,2), startTile.getSouth().getPosition());
        assertEquals(Position.of(1,4), startTile.getNorth().getPosition());
        assertEquals(Position.of(1,3), startTile.getWest().getPosition());
        assertEquals(Position.of(3,1), startTile.getEast().getPosition());
    }

    @Test
    public void testCubeOfSizeOneTwo() {
        Tile startTile = cubeOfSize1.getStartTile();
        assertEquals(Position.of(2,1), startTile.getPosition());
        assertEquals(Position.of(2,3), startTile.getSouth().getSouth().getPosition());
        assertEquals(Position.of(2,1), startTile.getSouth().getNorth().getPosition());
        assertEquals(Position.of(1,3), startTile.getSouth().getWest().getPosition());
        assertEquals(Position.of(3,1), startTile.getSouth().getEast().getPosition());
    }

    @Test
    public void testCubeOfSizeOneThree() {
        Tile startTile = cubeOfSize1.getStartTile();
        assertEquals(Position.of(2,1), startTile.getPosition());
        assertEquals(Position.of(3,1), startTile.getEast().getPosition());
        assertEquals(Position.of(2,2), startTile.getEast().getSouth().getPosition());
        assertEquals(Position.of(1,4), startTile.getEast().getNorth().getPosition());
        assertEquals(Position.of(2,1), startTile.getEast().getWest().getPosition());
        assertEquals(Position.of(2,3), startTile.getEast().getEast().getPosition());
    }

    @Test
    public void testCubeOfSizeOneFour() {
        Tile startTile = cubeOfSize1.getStartTile();
        assertEquals(Position.of(2,1), startTile.getPosition());
        assertEquals(Position.of(2,3), startTile.getSouth().getSouth().getPosition());
        assertEquals(Position.of(1,4), startTile.getSouth().getSouth().getSouth().getPosition());
        assertEquals(Position.of(2,2), startTile.getSouth().getSouth().getNorth().getPosition());
        assertEquals(Position.of(1,3), startTile.getSouth().getSouth().getWest().getPosition());
        assertEquals(Position.of(3,1), startTile.getSouth().getSouth().getEast().getPosition());
    }

    @Test
    public void testCubeOfSizeOneFive() {
        Tile startTile = cubeOfSize1.getStartTile();
        assertEquals(Position.of(2,1), startTile.getPosition());
        assertEquals(Position.of(1,4), startTile.getSouth().getSouth().getSouth().getPosition());
        // From this point going to south change the facing ---------------------------v   So West means in fact South ==> it means we turn the facing clockwise
        assertEquals(Position.of(2,1), startTile.getSouth().getSouth().getSouth().getWest().getPosition());
        // From this point going to south change the facing ---------------------------v   So North means in fact West ==> it means we turn the facing clockwise
        assertEquals(Position.of(1,3), startTile.getSouth().getSouth().getSouth().getNorth().getPosition());
        // From this point going to south change the facing ---------------------------v   So South means in fact East ==> it means we turn the facing clockwise
        assertEquals(Position.of(3,1), startTile.getSouth().getSouth().getSouth().getSouth().getPosition());
        // From this point going to south change the facing ---------------------------v   So East means in fact North ==> it means we turn the facing clockwise
        assertEquals(Position.of(2,3), startTile.getSouth().getSouth().getSouth().getEast().getPosition());
    }

    @Test
    public void testCubeOfSizeOneSix() {
        Tile startTile = cubeOfSize1.getStartTile();
        assertEquals(Position.of(2,1), startTile.getPosition());
        assertEquals(Position.of(1,3), startTile.getSouth().getSouth().getWest().getPosition());
        assertEquals(Position.of(2,1), startTile.getSouth().getSouth().getWest().getWest().getPosition());
        assertEquals(Position.of(2,2), startTile.getSouth().getSouth().getWest().getNorth().getPosition());
        assertEquals(Position.of(1,4), startTile.getSouth().getSouth().getWest().getSouth().getPosition());
        assertEquals(Position.of(2,3), startTile.getSouth().getSouth().getWest().getEast().getPosition());
    }

    @Test
    public void testCubeOfSizeTwoOne() {
        // simulated input
        //    123456
        // 1    ....     1122
        // 2    ....     1122
        // 3    ..       33
        // 4    ..       33
        // 5  ....     4455
        // 6  ....     4455
        // 7  ..       66
        // 8  ..       66

        Tile startTile = cubeOfSize2.getStartTile();
        assertEquals(Position.of(3,1), startTile.getPosition());
        assertEquals(Position.of(3,2), startTile.getSouth().getPosition());
        assertEquals(Position.of(3,3), startTile.getSouth().getSouth().getPosition());
        assertEquals(Position.of(3,4), startTile.getSouth().getSouth().getSouth().getPosition());
        assertEquals(Position.of(3,5), startTile.getSouth().getSouth().getSouth().getSouth().getPosition());
        assertEquals(Position.of(3,6), startTile.getSouth().getSouth().getSouth().getSouth().getSouth().getPosition());
        assertEquals(Position.of(2,7), startTile.getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getPosition());
        assertEquals(Position.of(2,8), startTile.getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getSouth().getPosition());
    }

    @Test
    public void testCubeOfSizeTwoTwo() {
        // simulated input
        //    123456
        // 1    ....     1122
        // 2    ....     1122
        // 3    ..       33
        // 4    ..       33
        // 5  ....     4455
        // 6  ....     4455
        // 7  ..       66
        // 8  ..       66

        Tile startTile = cubeOfSize2.getStartTile();
        assertEquals(Position.of(3,1), startTile.getPosition());
        assertEquals(Position.of(4,1), startTile.getEast().getPosition());
        assertEquals(Position.of(5,1), startTile.getEast().getEast().getPosition());
        assertEquals(Position.of(6,1), startTile.getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(4,6), startTile.getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(6,1), startTile.getEast().getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(4,6), startTile.getEast().getEast().getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(6,1), startTile.getEast().getEast().getEast().getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(4,2), startTile.getSouth().getEast().getPosition());
        assertEquals(Position.of(5,2), startTile.getSouth().getEast().getEast().getPosition());
        assertEquals(Position.of(6,2), startTile.getSouth().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(4,5), startTile.getSouth().getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(6,2), startTile.getSouth().getEast().getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(4,5), startTile.getSouth().getEast().getEast().getEast().getEast().getEast().getEast().getPosition());
        assertEquals(Position.of(6,2), startTile.getSouth().getEast().getEast().getEast().getEast().getEast().getEast().getEast().getPosition());
    }

    @Test
    public void testCubeOfSizeTwoThree() {
        // simulated input
        //    123456
        // 1    ....     1122
        // 2    ....     1122
        // 3    ..       33
        // 4    ..       33
        // 5  ....     4455
        // 6  ....     4455
        // 7  ..       66
        // 8  ..       66

        Tile startTile = cubeOfSize2.getStartTile();
        assertEquals(Position.of(3,1), startTile.getPosition());
        assertEquals(Position.of(1,6), startTile.getWest().getPosition());
        assertEquals(Position.of(3,1), startTile.getWest().getWest().getPosition());
        assertEquals(Position.of(1,6), startTile.getWest().getWest().getWest().getPosition());
        assertEquals(Position.of(3,1), startTile.getWest().getWest().getWest().getWest().getPosition());
        assertEquals(Position.of(1,5), startTile.getSouth().getWest().getPosition());
        assertEquals(Position.of(3,2), startTile.getSouth().getWest().getWest().getPosition());
        assertEquals(Position.of(1,5), startTile.getSouth().getWest().getWest().getWest().getPosition());
        assertEquals(Position.of(3,2), startTile.getSouth().getWest().getWest().getWest().getWest().getPosition());
    }

    @Test
    public void testCubeOfSizeTwoFour() {
        // simulated input
        //    123456
        // 1    ....     1122
        // 2    ....     1122
        // 3    ..       33
        // 4    ..       33
        // 5  ....     4455
        // 6  ....     4455
        // 7  ..       66
        // 8  ..       66

        Tile startTile = cubeOfSize2.getStartTile();
        assertEquals(Position.of(3,1), startTile.getPosition());
        assertEquals(Position.of(1,6), startTile.getWest().getPosition());
        assertEquals(Position.of(3,1), startTile.getWest().getWest().getPosition());
        assertEquals(Position.of(1,6), startTile.getWest().getWest().getWest().getPosition());
        assertEquals(Position.of(3,1), startTile.getWest().getWest().getWest().getWest().getPosition());
        assertEquals(Position.of(1,5), startTile.getSouth().getWest().getPosition());
        assertEquals(Position.of(3,2), startTile.getSouth().getWest().getWest().getPosition());
        assertEquals(Position.of(1,5), startTile.getSouth().getWest().getWest().getWest().getPosition());
        assertEquals(Position.of(3,2), startTile.getSouth().getWest().getWest().getWest().getWest().getPosition());
    }

    @Test
    public void testCubeOfSizeTwoFive() {
        // simulated input
        //    123456
        // 1    ....     1122
        // 2    ....     1122
        // 3    ..       33
        // 4    ..       33
        // 5  ....     4455
        // 6  ....     4455
        // 7  ..       66
        // 8  ..       66

        Tile startTile = cubeOfSize2.getStartTile();
        assertEquals(Position.of(3,1), startTile.getPosition());
        assertEquals(Position.of(1,7), startTile.getNorth().getPosition());
        assertEquals(Position.of(1,6), startTile.getNorth().getNorth().getPosition());
        assertEquals(Position.of(1,5), startTile.getNorth().getNorth().getNorth().getPosition());
        assertEquals(Position.of(3,3), startTile.getNorth().getNorth().getNorth().getNorth().getPosition());
        assertEquals(Position.of(3,2), startTile.getNorth().getNorth().getNorth().getNorth().getNorth().getPosition());
        assertEquals(Position.of(3,1), startTile.getNorth().getNorth().getNorth().getNorth().getNorth().getNorth().getPosition());
        assertEquals(Position.of(1,8), startTile.getEast().getNorth().getPosition());
        assertEquals(Position.of(1,7), startTile.getEast().getNorth().getNorth().getPosition());
        assertEquals(Position.of(1,6), startTile.getEast().getNorth().getNorth().getNorth().getPosition());
        assertEquals(Position.of(1,5), startTile.getEast().getNorth().getNorth().getNorth().getNorth().getPosition());
        assertEquals(Position.of(3,3), startTile.getEast().getNorth().getNorth().getNorth().getNorth().getNorth().getPosition());
    }
}
