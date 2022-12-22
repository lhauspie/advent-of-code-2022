package com.lhauspie.adventofcode.day21.model;

import java.util.function.Supplier;

public class OperationMonkey implements Monkey {
    private String id;
//    private String leftMonkeyId;
//    private String rightMonkeyId;
    private Supplier<Monkey> leftMonkey;
    private Supplier<Monkey> rightMonkey;
    private Operation operation;

    public OperationMonkey(String id, Supplier<Monkey> leftMonkey, Supplier<Monkey> rightMonkey, Operation operation) {
        this.id = id;
        this.leftMonkey = leftMonkey;
        this.rightMonkey = rightMonkey;
        this.operation = operation;
    }

//    public OperationMonkey(String id, String leftMonkeyId, String rightMonkeyId, Operation operation) {
//        this.id = id;
//        this.leftMonkeyId = leftMonkeyId;
//        this.rightMonkeyId = rightMonkeyId;
//        this.operation = operation;
//    }

//    public long getValue() {
//        return operation.calculate(leftMonkeyId, rightMonkeyId);
//    }

    public long getValue() {
        return operation.calculate(leftMonkey.get().getValue(), rightMonkey.get().getValue());
    }

    public String getId() {
        return id;
    }
}