package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HeadMoveLeftTailCalculationTest {

    @Test
    public void givenHeadAtSevenThreeAndTailSixFour_whenMoveLeftHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 T..
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 4));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 T..
        // 3 H..
        // 2 ...
        Assertions.assertEquals(Position.of(6, 4), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenFour_whenMoveLeftHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 .T.
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 4));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 .T.
        // 3 H..
        // 2 ...
        Assertions.assertEquals(Position.of(7, 4), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailEightFour_whenMoveLeftHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ..T
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 4));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 ...
        // 3 HT.
        // 2 ...
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixThree_whenMoveLeftHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ...
        // 3 TH.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 3));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 ...
        // 3 H.. (H cover T)
        // 2 ...
        Assertions.assertEquals(Position.of(6, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenThree_whenMoveLeftHead_thenTailShouldNotBeChanging() {
        //   678
        // 4 ...
        // 3 .H. (H cover T)
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 3));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 ...
        // 3 HT.
        // 2 ...
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailEightThree_whenMoveLeftHead_thenTailShouldNotBeChanging() {
        //   678
        // 4 ...
        // 3 .HT
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 3));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 ...
        // 3 HT.
        // 2 ...
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixTwo_whenMoveLeftHead_thenTailShouldBeSevenThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 T..
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 2));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 ...
        // 3 H..
        // 2 T..
        Assertions.assertEquals(Position.of(6, 2), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenTwo_whenMoveLeftHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 .T.
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 2));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 ...
        // 3 H..
        // 2 .T.
        Assertions.assertEquals(Position.of(7, 2), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixFour_whenMoveLeftHead_thenTailShouldBeSevenThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 ..T
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 2));
        Rope rope = new Rope(head, tail);

        head.moveLeft();

        //   678
        // 4 ...
        // 3 HT.
        // 2 ...
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }
}
