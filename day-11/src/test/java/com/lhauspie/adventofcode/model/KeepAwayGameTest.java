package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeepAwayGameTest {

    @Test
    public void firstPuzzleKeepAwayGameResult() {
        KeepAwayGame keepAwayGame = buildKeepAwayGame();
        keepAwayGame.play();
        render(keepAwayGame);

        assertEquals(101L, keepAwayGame.getMonkeys().get(0).getNbInspectedItems());
        assertEquals(95L, keepAwayGame.getMonkeys().get(1).getNbInspectedItems());
        assertEquals(7L, keepAwayGame.getMonkeys().get(2).getNbInspectedItems());
        assertEquals(105L, keepAwayGame.getMonkeys().get(3).getNbInspectedItems());

    }

    private void render(KeepAwayGame keepAwayGame) {
        int i = 0;
        for (var monkey : keepAwayGame.getMonkeys()) {
            System.out.print("Monkey " + i++ + ": ");
            for (var item : monkey.getItems()) {
                System.out.print(item.getWorryLevel() + ", ");
            }
            System.out.println();
        }
    }

    private KeepAwayGame buildKeepAwayGame() {
        Monkey monkey0 = new Monkey();
        Monkey monkey1 = new Monkey();
        Monkey monkey2 = new Monkey();
        Monkey monkey3 = new Monkey();

//        Monkey 0:
//            Starting items: 79, 98
//            Operation: new = old * 19
//            Test: divisible by 23
//            If true: throw to monkey 2
//            If false: throw to monkey 3
        monkey0.catchItem(new ZenItem(79L));
        monkey0.catchItem(new ZenItem(98L));
        monkey0.setOperation(worryLevel -> worryLevel * 19L);
        monkey0.setDivisible(new Divisible(23L));
        monkey0.setTrueMonkey(monkey2);
        monkey0.setFalseMonkey(monkey3);

//        Monkey 1:
//            Starting items: 54, 65, 75, 74
//            Operation: new = old + 6
//            Test: divisible by 19
//            If true: throw to monkey 2
//            If false: throw to monkey 0
        monkey1.catchItem(new ZenItem(54L));
        monkey1.catchItem(new ZenItem(65L));
        monkey1.catchItem(new ZenItem(75L));
        monkey1.catchItem(new ZenItem(74L));
        monkey1.setOperation(worryLevel -> worryLevel + 6L);
        monkey1.setDivisible(new Divisible(19L));
        monkey1.setTrueMonkey(monkey2);
        monkey1.setFalseMonkey(monkey0);

//        Monkey 2:
//            Starting items: 79, 60, 97
//            Operation: new = old * old
//            Test: divisible by 13
//            If true: throw to monkey 1
//            If false: throw to monkey 3
        monkey2.catchItem(new ZenItem(79L));
        monkey2.catchItem(new ZenItem(60L));
        monkey2.catchItem(new ZenItem(97L));
        monkey2.setOperation(worryLevel -> worryLevel * worryLevel);
        monkey2.setDivisible(new Divisible(13L));
        monkey2.setTrueMonkey(monkey1);
        monkey2.setFalseMonkey(monkey3);

//        Monkey 3:
//            Starting items: 74
//            Operation: new = old + 3
//            Test: divisible by 17
//            If true: throw to monkey 0
//            If false: throw to monkey 1
        monkey3.catchItem(new ZenItem(74L));
        monkey3.setOperation(worryLevel -> worryLevel + 3L);
        monkey3.setDivisible(new Divisible(17L));
        monkey3.setTrueMonkey(monkey0);
        monkey3.setFalseMonkey(monkey1);


        return new KeepAwayGame(
                monkey0,
                monkey1,
                monkey2,
                monkey3
        );
    }
}
