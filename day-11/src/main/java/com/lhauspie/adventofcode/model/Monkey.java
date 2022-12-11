package com.lhauspie.adventofcode.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Monkey {
    private Deque<Item> items = new ArrayDeque<>();
    private Operation operation;
    private Divisible divisible;
    private Monkey monkeyReceiverForTrue;
    private Monkey monkeyReceiverForFalse;
    private long nbInspectedItems = 0L;

    public void catchItem(Item item) {
        items.addLast(item);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setDivisible(Divisible divisible) {
        this.divisible = divisible;
    }

    public Divisible getDivisible() {
        return divisible;
    }

    public void setTrueMonkey(Monkey monkeyReceiverForTrue) {
        this.monkeyReceiverForTrue = monkeyReceiverForTrue;
    }

    public void setFalseMonkey(Monkey monkeyReceiverForFalse) {
        this.monkeyReceiverForFalse = monkeyReceiverForFalse;
    }

    public void playRound() {
        while (stillHaveItems()) {
            playTurn();
        }
    }

    public void playTurn() {
        Item polledItem = items.pollFirst();
        evaluateNewWorryLevel(polledItem);
        inspect(polledItem);
        throwItem(polledItem);
    }

    private void evaluateNewWorryLevel(Item polledItem) {
        polledItem.setWorryLevel(operation.evaluateNewWorryLevel(polledItem.getWorryLevel()));
    }

    public Item getLastReceivedItem() {
        return items.getLast();
    }

    private void throwItem(Item polledItem) {
        if (divisible.isDivisible(polledItem.getWorryLevel())) {
            monkeyReceiverForTrue.catchItem(polledItem);
        } else {
            monkeyReceiverForFalse.catchItem(polledItem);
        }
    }

    private void inspect(Item polledItem) {
        polledItem.inspect();
        nbInspectedItems++;
    }

    private boolean stillHaveItems() {
        return items.size() != 0;
    }

    public long getNbInspectedItems() {
        return nbInspectedItems;
    }

    public Deque<Item> getItems() {
        return items;
    }
}
