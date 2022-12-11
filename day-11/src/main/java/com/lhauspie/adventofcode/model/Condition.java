package com.lhauspie.adventofcode.model;

@FunctionalInterface
public interface Condition {
    boolean isTrue(long worryLevel);
}
