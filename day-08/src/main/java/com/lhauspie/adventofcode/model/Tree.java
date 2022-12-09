package com.lhauspie.adventofcode.model;

public class Tree {

    private Height height;

    public Tree(Height height) {
        this.height = height;
    }

    public boolean isShorterThan(Tree tree) {
        return this.getHeight().isLowerThan(tree.getHeight());
    }

    private Height getHeight() {
        return height;
    }
}
