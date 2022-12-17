package com.lhauspie.adventofcode.day11.model;

import com.lhauspie.adventofcode.day11.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeepAwayGameTest {

    @Test
    public void firstPuzzleKeepAwayGameResult() {
        KeepAwayGame keepAwayGame = buildKeepAwayGameBasedOnInputExample(20, new RelaxOwner());
        keepAwayGame.play();

        assertEquals(101L, keepAwayGame.getMonkeys().get(0).getNbInspectedItems());
        assertEquals(95L, keepAwayGame.getMonkeys().get(1).getNbInspectedItems());
        assertEquals(7L, keepAwayGame.getMonkeys().get(2).getNbInspectedItems());
        assertEquals(105L, keepAwayGame.getMonkeys().get(3).getNbInspectedItems());

    }

    @Test
    public void secondPuzzleKeepAwayGameRound1() {
        KeepAwayGame keepAwayGame = buildKeepAwayGameBasedOnInputExample(1, new WorriedOwner());
        keepAwayGame.play();

        assertEquals(2L, keepAwayGame.getMonkeys().get(0).getNbInspectedItems());
        assertEquals(4L, keepAwayGame.getMonkeys().get(1).getNbInspectedItems());
        assertEquals(3L, keepAwayGame.getMonkeys().get(2).getNbInspectedItems());
        assertEquals(6L, keepAwayGame.getMonkeys().get(3).getNbInspectedItems());
    }

    @Test
    public void secondPuzzleKeepAwayGameRound20() {
        KeepAwayGame keepAwayGame = buildKeepAwayGameBasedOnInputExample(20, new WorriedOwner());
        keepAwayGame.play();

        assertEquals(99L, keepAwayGame.getMonkeys().get(0).getNbInspectedItems());
        assertEquals(97L, keepAwayGame.getMonkeys().get(1).getNbInspectedItems());
        assertEquals(8L, keepAwayGame.getMonkeys().get(2).getNbInspectedItems());
        assertEquals(103L, keepAwayGame.getMonkeys().get(3).getNbInspectedItems());
    }

    @Test
    public void secondPuzzleKeepAwayGameRound1000() {
        KeepAwayGame keepAwayGame = buildKeepAwayGameBasedOnInputExample(1000, new WorriedOwner());
        keepAwayGame.play();

        assertEquals(5204L, keepAwayGame.getMonkeys().get(0).getNbInspectedItems());
        assertEquals(4792L, keepAwayGame.getMonkeys().get(1).getNbInspectedItems());
        assertEquals(199L, keepAwayGame.getMonkeys().get(2).getNbInspectedItems());
        assertEquals(5192L, keepAwayGame.getMonkeys().get(3).getNbInspectedItems());
    }

    @Test
    public void secondPuzzleKeepAwayGameRound2000() {
        KeepAwayGame keepAwayGame = buildKeepAwayGameBasedOnInputExample(2000, new WorriedOwner());
        keepAwayGame.play();

        assertEquals(10419L, keepAwayGame.getMonkeys().get(0).getNbInspectedItems());
        assertEquals(9577L, keepAwayGame.getMonkeys().get(1).getNbInspectedItems());
        assertEquals(392L, keepAwayGame.getMonkeys().get(2).getNbInspectedItems());
        assertEquals(10391L, keepAwayGame.getMonkeys().get(3).getNbInspectedItems());
    }

    @Test
    public void secondPuzzleKeepAwayGameRound10000() {
        KeepAwayGame keepAwayGame = buildKeepAwayGameBasedOnInputExample(10000, new WorriedOwner());
        keepAwayGame.play();

        assertEquals(52166L, keepAwayGame.getMonkeys().get(0).getNbInspectedItems());
        assertEquals(47830L, keepAwayGame.getMonkeys().get(1).getNbInspectedItems());
        assertEquals(1938L, keepAwayGame.getMonkeys().get(2).getNbInspectedItems());
        assertEquals(52013L, keepAwayGame.getMonkeys().get(3).getNbInspectedItems());
    }

    private KeepAwayGame buildKeepAwayGameBasedOnInputExample(int roundNumber, Owner owner) {
        Monkey monkey0 = new Monkey();
        Monkey monkey1 = new Monkey();
        Monkey monkey2 = new Monkey();
        Monkey monkey3 = new Monkey();

        monkey0.catchItem(new Item(79L, owner));
        monkey0.catchItem(new Item(98L, owner));
        monkey0.setInspection(worryLevel -> worryLevel * 19L);
        monkey0.setDivisible(new Divisible(23L));
        monkey0.setTrueMonkey(monkey2);
        monkey0.setFalseMonkey(monkey3);

        monkey1.catchItem(new Item(54L, owner));
        monkey1.catchItem(new Item(65L, owner));
        monkey1.catchItem(new Item(75L, owner));
        monkey1.catchItem(new Item(74L, owner));
        monkey1.setInspection(worryLevel -> worryLevel + 6L);
        monkey1.setDivisible(new Divisible(19L));
        monkey1.setTrueMonkey(monkey2);
        monkey1.setFalseMonkey(monkey0);

        monkey2.catchItem(new Item(79L, owner));
        monkey2.catchItem(new Item(60L, owner));
        monkey2.catchItem(new Item(97L, owner));
        monkey2.setInspection(worryLevel -> worryLevel * worryLevel);
        monkey2.setDivisible(new Divisible(13L));
        monkey2.setTrueMonkey(monkey1);
        monkey2.setFalseMonkey(monkey3);

        monkey3.catchItem(new Item(74L, owner));
        monkey3.setInspection(worryLevel -> worryLevel + 3L);
        monkey3.setDivisible(new Divisible(17L));
        monkey3.setTrueMonkey(monkey0);
        monkey3.setFalseMonkey(monkey1);


        return new KeepAwayGame(
                roundNumber,
                owner,
                monkey0,
                monkey1,
                monkey2,
                monkey3
        );
    }
}
