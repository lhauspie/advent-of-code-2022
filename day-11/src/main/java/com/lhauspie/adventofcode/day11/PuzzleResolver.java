package com.lhauspie.adventofcode.day11;

import com.lhauspie.adventofcode.day11.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner) {
        KeepAwayGame keepAwayGame = buildKeepAwayGame(
                scanner,
                new RelaxOwner(),
                20
        );
        keepAwayGame.play();

        return getMonkeyBusiness(keepAwayGame);
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        KeepAwayGame keepAwayGame = buildKeepAwayGame(
                scanner,
                new WorriedOwner(),
                10000
        );
        keepAwayGame.play();

        return getMonkeyBusiness(keepAwayGame);
    }

    private static Long getMonkeyBusiness(KeepAwayGame keepAwayGame) {
        return keepAwayGame.getMonkeys().stream()
                .map(monkey -> monkey.getNbInspectedItems())
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce((i, i2) -> i * i2)
                .get();
    }

    private static KeepAwayGame buildKeepAwayGame(Scanner scanner, Owner owner, int roundNumber) {
        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            monkeys.add(new Monkey());
        }

        int monkeyIndex = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            Monkey aMonkey = monkeys.get(monkeyIndex++);

            initItems(aMonkey, scanner.nextLine(), owner);
            initInspection(aMonkey, scanner.nextLine());
            initDivisible(aMonkey, scanner.nextLine());
            initTrueMonkey(monkeys, aMonkey, scanner.nextLine());
            initFalseMonkey(monkeys, aMonkey, scanner.nextLine());
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // read the empty line separating monkeys
            }
        }

        return new KeepAwayGame(roundNumber, owner, monkeys.toArray(new Monkey[monkeys.size()]));
    }

    private static void initFalseMonkey(List<Monkey> monkeys, Monkey aMonkey, String nextLine) {
        String ifFalse = nextLine.replace("    If false: throw to monkey ", "");
        aMonkey.setFalseMonkey(monkeys.get(Integer.parseInt(ifFalse)));
    }

    private static void initTrueMonkey(List<Monkey> monkeys, Monkey aMonkey, String nextLine) {
        String ifTrue = nextLine.replace("    If true: throw to monkey ", "");
        aMonkey.setTrueMonkey(monkeys.get(Integer.parseInt(ifTrue)));
    }

    private static void initDivisible(Monkey aMonkey, String nextLine) {
        String condition = nextLine.replace("  Test: divisible by ", "");
        aMonkey.setDivisible(new Divisible(Long.parseLong(condition)));
    }

    private static void initInspection(Monkey aMonkey, String nextLine) {
        String inspection = nextLine.replace("  Operation: new = old ", "");
        if (inspection.startsWith("*")) {
            aMonkey.setInspection(worryLevel -> {
                String operand = inspection.replace("* ", "");
                if (operand.equals("old")) {
                    return worryLevel * worryLevel;
                } else {
                    return worryLevel * Long.parseLong(operand);
                }
            });
        } else if (inspection.startsWith("+")) {
            aMonkey.setInspection(worryLevel -> worryLevel + Long.parseLong(inspection.replace("+ ", "")));
        }
    }

    private static void initItems(Monkey aMonkey, String nextLine, Owner owner) {
        String[] itemWorryLevel = nextLine.replace("  Starting items: ", "").split(", ");
        for (int i = 0; i < itemWorryLevel.length; i++) {
            aMonkey.catchItem(new Item(Long.parseLong(itemWorryLevel[i]), owner));
        }
    }
}
