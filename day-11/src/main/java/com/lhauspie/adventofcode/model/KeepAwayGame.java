package com.lhauspie.adventofcode.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeepAwayGame {
    private List<Monkey> monkeys = new ArrayList<>();
    private static int ROUND_NUMBER = 20;
    private Long productOfDivisors;
    private int roundNumber;

    public KeepAwayGame(Monkey... monkeys) {
        this(ROUND_NUMBER, monkeys);
    }

    public KeepAwayGame(int roundNumber, Monkey... monkeys) {
        this.roundNumber = roundNumber;
        for (int i = 0; i < monkeys.length; i++) {
            this.monkeys.add(monkeys[i]);
        }

        productOfDivisors = Arrays.stream(monkeys)
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
        }
        for (var monkey: monkeys) {
            for (var item : monkey.getItems()) {
                item.setWorryLevel(item.getWorryLevel() % productOfDivisors);
            }
        }
    }

    public List<Monkey> getMonkeys() {
        return monkeys;
    }
}
