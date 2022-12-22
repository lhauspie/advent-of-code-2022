package com.lhauspie.adventofcode.day21.model;

import java.util.function.Supplier;

public class OperationMonkey implements Monkey {
    private MonkeyId id;
    private Supplier<Monkey> leftMonkey;
    private Supplier<Monkey> rightMonkey;
    private Operation operation;
    // for memoization
    private Long value = null;

    public OperationMonkey(MonkeyId id, Supplier<Monkey> leftMonkey, Supplier<Monkey> rightMonkey, Operation operation) {
        this.id = id;
        this.leftMonkey = leftMonkey;
        this.rightMonkey = rightMonkey;
        this.operation = operation;
    }

    public long getValue() {
        if (value == null) {
            value = operation.calculate(getLeftMonkey().getValue(), getRightMonkey().getValue());
        }
        return value;
    }

    public MonkeyId getId() {
        return id;
    }

    public Monkey getLeftMonkey() {
        return leftMonkey.get();
    }

    public Monkey getRightMonkey() {
        return rightMonkey.get();
    }

    public long calculateTheNewRightValue(long value) {
        long newRightValue = 0;
        if (operation == Operation.ADDITION) {
            // means value = left + right  ==> left = value - right ==> right = value - left;
            newRightValue = value - getLeftMonkey().getValue();
        }
        if (operation == Operation.SUBTRACTION) {
            // means value = left - right  ==> left = value + right ==> right = left - value;
            newRightValue = getLeftMonkey().getValue() - value;
        }
        if (operation == Operation.DIVISION) {
            // means value = left / right  ==> left = value * right ==> right = left / value;
            newRightValue = getLeftMonkey().getValue() / value;
        }
        if (operation == Operation.MULTIPLICATION) {
            // means value = left * right  ==> left = value / right ==> right = value / left;
            newRightValue = value / getLeftMonkey().getValue();
        }
        return newRightValue;
    }

    public long calculateTheNewLeftValue(long totalValue) {
        long newLeftValue = 0;
        if (operation == Operation.ADDITION) {
            // means totalValue = left + right  ==> left = totalValue - right ==> right = totalValue - left;
            newLeftValue = totalValue - getRightMonkey().getValue();
        }
        if (operation == Operation.SUBTRACTION) {
            // means totalValue = left - right  ==> left = totalValue + right ==> right = left - totalValue;
            newLeftValue = totalValue + getRightMonkey().getValue();
        }
        if (operation == Operation.DIVISION) {
            // means totalValue = left / right  ==> left = totalValue * right ==> right = left / totalValue;
            newLeftValue = totalValue * getRightMonkey().getValue();
        }
        if (operation == Operation.MULTIPLICATION) {
            // means totalValue = left * right  ==> left = totalValue / right ==> right = totalValue / left;
            newLeftValue = totalValue / getRightMonkey().getValue();
        }
        return newLeftValue;
    }
}