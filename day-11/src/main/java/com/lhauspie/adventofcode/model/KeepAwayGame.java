package com.lhauspie.adventofcode.model;

import java.util.ArrayList;
import java.util.List;

public class KeepAwayGame {
    private List<Monkey> monkeys = new ArrayList<>();
    private static int ROUND_NUMBER = 20;


    public KeepAwayGame(Monkey... monkeys) {
        for (int i = 0; i < monkeys.length; i++) {
            this.monkeys.add(monkeys[i]);
        }
    }

    public void play() {
        for (int i = 0; i < ROUND_NUMBER; i++) {
            for (Monkey monkey : monkeys) {
                monkey.playRound();
            }
        }
    }

    public List<Monkey> getMonkeys() {
        return monkeys;
    }
}
