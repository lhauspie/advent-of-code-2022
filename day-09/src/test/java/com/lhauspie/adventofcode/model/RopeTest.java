package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RopeTest {

    @Test
    public void movingUpTheFourNodesRopeHeadShouldUpdateTheRopeTail() {
        RopeNode node1 = new RopeNode(Position.of(0, 0));
        RopeNode node2 = new RopeNode(Position.of(0, 0));
        RopeNode node3 = new RopeNode(Position.of(0, 0));
        RopeNode node4 = new RopeNode(Position.of(0, 0));

        Rope rope = new Rope(
                node1,
                node2,
                node3,
                node4
        );

        rope.getHead().moveUp(); // head.y = 1 / tail.y = 0
        rope.getHead().moveUp(); // head.y = 2 / tail.y = 0
        rope.getHead().moveUp(); // head.y = 3 / tail.y = 0
        rope.getHead().moveUp(); // head.y = 4 / tail.y = 1
        rope.getHead().moveUp(); // head.y = 5 / tail.y = 2
        rope.getHead().moveUp(); // head.y = 6 / tail.y = 3

        assertEquals(Position.of(0, 3), rope.getTail().getPosition());
    }
}
