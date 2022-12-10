package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RopeNodeTest {

    @Test
    public void movingUpNodeShouldUpdateItsPosition() {
        RopeNode node = new RopeNode(Position.of(0, 0));
        node.moveUp();
        assertEquals(Position.of(0, 1), node.getPosition());
    }

    @Test
    public void movingDownNodeShouldUpdateItsPosition() {
        RopeNode node = new RopeNode(Position.of(0, 0));
        node.moveDown();
        assertEquals(Position.of(0, -1), node.getPosition());
    }

    @Test
    public void movingLeftNodeShouldUpdateItsPosition() {
        RopeNode node = new RopeNode(Position.of(0, 0));
        node.moveLeft();
        assertEquals(Position.of(-1, 0), node.getPosition());
    }

    @Test
    public void movingRightNodeShouldUpdateItsPosition() {
        RopeNode node = new RopeNode(Position.of(0, 0));
        node.moveRight();
        assertEquals(Position.of(1, 0), node.getPosition());
    }
}
