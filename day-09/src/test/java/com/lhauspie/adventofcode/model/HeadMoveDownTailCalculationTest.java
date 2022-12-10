package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HeadMoveDownTailCalculationTest {

    @Test
    public void givenHeadAtSevenThreeAndTailSixFour_whenMoveDownHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 T..
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 4));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 .T.
        // 2 .H.
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenFour_whenMoveDownHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 .T.
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 4));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 .T.
        // 2 .H.
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailEightFour_whenMoveDownHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ..T
        // 3 .H.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 4));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 .T.
        // 2 .H.
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixThree_whenMoveDownHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ...
        // 3 TH.
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 3));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 T..
        // 2 .H.
        Assertions.assertEquals(Position.of(6, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenThree_whenMoveDownHead_thenTailShouldNotBeChanging() {
        //   678
        // 4 ...
        // 3 .H. (H cover T)
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 3));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 .T.
        // 2 .H.
        Assertions.assertEquals(Position.of(7, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailEightThree_whenMoveDownHead_thenTailShouldNotBeChanging() {
        //   678
        // 4 ...
        // 3 .HT
        // 2 ...
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 3));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 ..T
        // 2 .H.
        Assertions.assertEquals(Position.of(8, 3), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixTwo_whenMoveDownHead_thenTailShouldBeSevenThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 T..
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(6, 2));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 ...
        // 2 TH.
        Assertions.assertEquals(Position.of(6, 2), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSevenTwo_whenMoveDownHead_thenTailShouldBeFiveThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 .T.
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(7, 2));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 ...
        // 2 .H. (H cover T)
        Assertions.assertEquals(Position.of(7, 2), tail.getPosition());
    }

    @Test
    public void givenHeadAtSevenThreeAndTailSixFour_whenMoveDownHead_thenTailShouldBeSevenThree() {
        //   678
        // 4 ...
        // 3 .H.
        // 2 ..T
        var head = new RopeNode(Position.of(7, 3));
        var tail = new RopeNode(Position.of(8, 2));
        var rope = new Rope(head, tail);

        head.moveDown();

        //   678
        // 4 ...
        // 3 ...
        // 2 .HT
        Assertions.assertEquals(Position.of(8, 2), tail.getPosition());
    }
}
