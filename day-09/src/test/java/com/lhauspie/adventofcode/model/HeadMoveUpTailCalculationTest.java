package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HeadMoveUpTailCalculationTest {

    @Test
    public void givenHeadAtSevenThreeAndTailSixFour_whenMoveUpHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 T..
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 4));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 TH.
        // 3 ...
        // 2 ...
        Assertions.assertEquals(Position.of(6, 4), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenFour_whenMoveUpHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 .T.
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 4));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 .H. (H cover T)
        // 3 ...
        // 2 ...
        Assertions.assertEquals(Position.of(7, 4), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailEightFour_whenMoveUpHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ..T
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 4));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 .HT
        // 3 ...
        // 2 ...
        Assertions.assertEquals(Position.of(8, 4), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixThree_whenMoveUpHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ...
        // 3 TH.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 3));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 .H.
        // 3 T..
        // 2 ...
        Assertions.assertEquals(Position.of(6, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenThree_whenMoveUpHead_thenTailShouldNotBeChanging() {
        //   678
        // 4 ...
        // 3 .H. (H cover T)
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 3));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 .H.
        // 3 .T.
        // 2 ...
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailEightThree_whenMoveUpHead_thenTailShouldNotBeChanging() {
        //   678
        // 4 ...
        // 3 .HT
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 3));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 .H.
        // 3 ..T
        // 2 ...
        Assertions.assertEquals(Position.of(8, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixTwo_whenMoveUpHead_thenTailShouldBeSevenThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 T..
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 2));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 .H.
        // 3 .T.
        // 2 ...
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenTwo_whenMoveUpHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 .T.
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 2));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 .H.
        // 3 .T.
        // 2 ...
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixFour_whenMoveUpHead_thenTailShouldBeSevenThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 ..T
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 2));
        Rope rope = new Rope(head, tail);

        head.moveUp();

        //   678
        // 4 .H.
        // 3 .T.
        // 2 ...
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }
}
