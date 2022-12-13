package com.lhauspie.adventofcode.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeepAwayGame {
    private Owner centralPlayer;
    private List<Monkey> monkeys = new ArrayList<>();
    private Long productOfDivisors;
    private int roundNumber;

    public KeepAwayGame(int roundNumber, Owner centralPlayer, Monkey... monkeys) {
        this.roundNumber = roundNumber;
        this.centralPlayer = centralPlayer;
        this.productOfDivisors = calculateProductOfMonkeysDivisors(monkeys);
        for (int i = 0; i < monkeys.length; i++) {
            this.monkeys.add(monkeys[i]);
        }
    }

    private Long calculateProductOfMonkeysDivisors(Monkey[] monkeys) {
        return Arrays.stream(monkeys)
                .map(Monkey::getDivisible)
                .filter(divisible -> divisible != null)
                .map(Divisible::getDivisor)
                .reduce((aLong, aLong2) -> aLong * aLong2)
                .get();
    }

    public void play() {
        for (int i = 0; i < roundNumber; i++) {
            for (Monkey monkey : monkeys) {
                monkey.playRound();
            }
            shortenWorryLevelOfAllItemsToAvoidLongOverflowing();
        }
    }

    private void shortenWorryLevelOfAllItemsToAvoidLongOverflowing() {
        for(var item : centralPlayer.getItems()) {
            item.setWorryLevel(item.getWorryLevel() % productOfDivisors);
        }
    }

    public List<Monkey> getMonkeys() {
        return monkeys;
    }
}
