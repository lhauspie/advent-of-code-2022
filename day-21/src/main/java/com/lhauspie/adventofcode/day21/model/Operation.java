package com.lhauspie.adventofcode.day21.model;

@FunctionalInterface
public interface Operation {
    Operation PLUS =     (left, right) -> left + right;
    Operation MINUS =    (left, right) -> left - right;
    Operation DIVIDE =   (left, right) -> left / right;
    Operation MULTIPLY = (left, right) -> left * right;

//    long calculate(String leftMonkeyId, String rightMonkeyId);
    long calculate(long leftValue, long rightValue);
}

