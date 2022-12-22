package com.lhauspie.adventofcode.day21.model;

import java.util.Map;

@FunctionalInterface
public interface Operation {
    Operation ADDITION =       (left, right) -> left + right;
    Operation SUBTRACTION =    (left, right) -> left - right;
    Operation DIVISION =       (left, right) -> left / right;
    Operation MULTIPLICATION = (left, right) -> left * right;

    long calculate(long leftValue, long rightValue);

    Map<String, Operation> operations = Map.of(
            "+", Operation.ADDITION,
            "-", Operation.SUBTRACTION,
            "/", Operation.DIVISION,
            "*", Operation.MULTIPLICATION
    );

    static Operation valueOf(String operator) {
        return operations.get(operator);
    }
}

