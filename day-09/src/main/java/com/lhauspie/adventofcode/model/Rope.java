package com.lhauspie.adventofcode.model;

public class Rope {
    private RopeNode head;
    private RopeNode tail;

    public Rope(RopeNode... nodes) {
        head = nodes[0];
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].addObserver(nodes[i + 1]);
        }
        tail = nodes[nodes.length - 1];
    }

    public RopeNode getHead() {
        return head;
    }

    public RopeNode getTail() {
        return tail;
    }
}
