package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonkeyTest {

    @Test
    public void monkeyThrowsToTheTrueMonkeyIfConditionIsTrue() {
        Owner owner = new RelaxOwner();
        Monkey monkeyPlayer = new Monkey();
        Monkey monkeyReceiverForTrue = new Monkey();

        monkeyPlayer.catchItem(new Item(69L, owner));
        monkeyPlayer.setInspection(worryLevel -> worryLevel * 19L);
        monkeyPlayer.setDivisible(new Divisible(23L));
        monkeyPlayer.setTrueMonkey(monkeyReceiverForTrue);
        monkeyPlayer.playTurn();

        assertEquals(437, monkeyReceiverForTrue.getLastCaughtItem().getWorryLevel());
    }

    @Test
    public void monkeyThrowsToTheFalseMonkeyIfConditionIsFalse() {
        Owner owner = new RelaxOwner();
        Monkey monkeyPlayer = new Monkey();
        Monkey monkeyReceiverForFalse = new Monkey();

        monkeyPlayer.catchItem(new Item(79L, owner));
        monkeyPlayer.setInspection(worryLevel -> worryLevel * 19L);
        monkeyPlayer.setDivisible(new Divisible(23L));
        monkeyPlayer.setFalseMonkey(monkeyReceiverForFalse);
        monkeyPlayer.playTurn();

        assertEquals(500, monkeyReceiverForFalse.getLastCaughtItem().getWorryLevel());
    }

    @Test
    public void monkeyThrowsItemToTheGoodMonkeyAccordingToTheCondition() {
        Owner owner = new RelaxOwner();
        Monkey monkeyPlayer = new Monkey();
        Monkey monkeyReceiverForTrue = new Monkey();
        Monkey monkeyReceiverForFalse = new Monkey();

        monkeyPlayer.catchItem(new Item(79L, owner));
        monkeyPlayer.catchItem(new Item(69L, owner));
        monkeyPlayer.setInspection(worryLevel -> worryLevel * 19L);
        monkeyPlayer.setDivisible(new Divisible(23L));
        monkeyPlayer.setTrueMonkey(monkeyReceiverForTrue);
        monkeyPlayer.setFalseMonkey(monkeyReceiverForFalse);
        monkeyPlayer.playRound();

        assertEquals(437, monkeyReceiverForTrue.getLastCaughtItem().getWorryLevel());
        assertEquals(500, monkeyReceiverForFalse.getLastCaughtItem().getWorryLevel());
        assertEquals(2, monkeyPlayer.getNbInspectedItems());
    }
}
