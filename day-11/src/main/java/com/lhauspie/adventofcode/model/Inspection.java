package com.lhauspie.adventofcode.model;

@FunctionalInterface
public interface Inspection {
    long evaluateNewWorryLevel(long worryLevel);
}
