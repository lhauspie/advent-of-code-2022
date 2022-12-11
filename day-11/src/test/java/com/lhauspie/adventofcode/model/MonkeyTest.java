package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonkeyTest {

    @Test
    public void monkeyThrowsToTheTrueMonkeyIfConditionIsTrue() {
        Monkey monkeyPlayer = new Monkey();
        Monkey monkeyReceiverForTrue = new Monkey();
        monkeyPlayer.catchItem(new ZenItem(69L));
        monkeyPlayer.setOperation(worryLevel -> worryLevel * 19L);
        monkeyPlayer.setDivisible(new Divisible(23L));
        monkeyPlayer.setTrueMonkey(monkeyReceiverForTrue);
        monkeyPlayer.playTurn();

        assertEquals(437, monkeyReceiverForTrue.getLastReceivedItem().getWorryLevel());
    }

    @Test
    public void monkeyThrowsToTheFalseMonkeyIfConditionIsFalse() {
        Monkey monkeyPlayer = new Monkey();
        Monkey monkeyReceiverForFalse = new Monkey();
        monkeyPlayer.catchItem(new ZenItem(79L));
        monkeyPlayer.setOperation(worryLevel -> worryLevel * 19L);
        monkeyPlayer.setDivisible(new Divisible(23L));
        monkeyPlayer.setFalseMonkey(monkeyReceiverForFalse);
        monkeyPlayer.playTurn();

        assertEquals(500, monkeyReceiverForFalse.getLastReceivedItem().getWorryLevel());
    }

    @Test
    public void monkeyThrowsItemToTheGoodMonkeyAccordingToTheCondition() {
        Monkey monkeyPlayer = new Monkey();
        Monkey monkeyReceiverForTrue = new Monkey();
        Monkey monkeyReceiverForFalse = new Monkey();

        monkeyPlayer.catchItem(new ZenItem(79L));
        monkeyPlayer.catchItem(new ZenItem(69L));
        monkeyPlayer.setOperation(worryLevel -> worryLevel * 19L);
        monkeyPlayer.setDivisible(new Divisible(23L));
        monkeyPlayer.setTrueMonkey(monkeyReceiverForTrue);
        monkeyPlayer.setFalseMonkey(monkeyReceiverForFalse);
        monkeyPlayer.playRound();

        assertEquals(437, monkeyReceiverForTrue.getLastReceivedItem().getWorryLevel());
        assertEquals(500, monkeyReceiverForFalse.getLastReceivedItem().getWorryLevel());
        assertEquals(2, monkeyPlayer.getNbInspectedItems());
    }
}
