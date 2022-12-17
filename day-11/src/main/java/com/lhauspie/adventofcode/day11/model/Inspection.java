package com.lhauspie.adventofcode.day11.model;

@FunctionalInterface
public interface Inspection {
    long evaluateNewWorryLevel(long worryLevel);
}
