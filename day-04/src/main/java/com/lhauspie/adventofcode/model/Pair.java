package com.lhauspie.adventofcode.model;

public record Pair(Range left, Range right) {
    public boolean isFullyContain() {
        return left.fullyContains(right) || right.fullyContains(left);
    }

    public boolean isOverlap() {
        return left.overlap(right);
    }
}
