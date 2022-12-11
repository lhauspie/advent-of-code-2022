package com.lhauspie.adventofcode.model;

@FunctionalInterface
public interface Operation {
    long evaluateNewWorryLevel(long worryLevel);
}
