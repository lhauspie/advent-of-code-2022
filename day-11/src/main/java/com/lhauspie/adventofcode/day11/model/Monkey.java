package com.lhauspie.adventofcode.day11.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Monkey {
    private Deque<Item> items = new ArrayDeque<>();
    private Inspection inspection;
    private Divisible divisible;
    private Monkey monkeyReceiverForTrue;
    private Monkey monkeyReceiverForFalse;
    private long nbInspectedItems = 0L;

    public void catchItem(Item item) {
        items.addLast(item);
    }

    public void setInspection(Inspection inspection) {
        this.inspection = inspection;
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
        inspect(polledItem);
        throwItem(polledItem);
    }

    public Item getLastCaughtItem() {
        return items.getLast();
    }

    private void inspect(Item polledItem) {
        polledItem.inspect(inspection);
        nbInspectedItems++;
    }

    private void throwItem(Item polledItem) {
        if (divisible.isDivisible(polledItem.getWorryLevel())) {
            monkeyReceiverForTrue.catchItem(polledItem);
        } else {
            monkeyReceiverForFalse.catchItem(polledItem);
        }
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
