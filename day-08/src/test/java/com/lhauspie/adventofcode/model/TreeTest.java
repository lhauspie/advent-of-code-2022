package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeTest {

    @Test
    public void treeIsHigherThanAnother() {
        Tree bigTree = new Tree(Height.of(9));
        Tree littleTree = new Tree(Height.of(0));

        assertTrue(littleTree.isShorterThan(bigTree));
    }
}
