package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner) {
        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            monkeys.add(new Monkey());
        }

        int monkeyIndex = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            Monkey aMonkey = monkeys.get(monkeyIndex++);

            initZenItems(aMonkey, scanner.nextLine());
            initOperation(aMonkey, scanner.nextLine());
            initDivisible(aMonkey, scanner.nextLine());
            initTrueMonkey(monkeys, aMonkey, scanner.nextLine());
            initFalseMonkey(monkeys, aMonkey, scanner.nextLine());
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // read the empty line separating monkeys
            }
        }

        KeepAwayGame keepAwayGame = new KeepAwayGame(monkeys.toArray(new Monkey[monkeys.size()]));
        keepAwayGame.play();

        return keepAwayGame.getMonkeys().stream()
                .map(monkey -> monkey.getNbInspectedItems())
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce((i, i2) -> i * i2)
                .get();
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            monkeys.add(new Monkey());
        }

        int monkeyIndex = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            Monkey aMonkey = monkeys.get(monkeyIndex++);

            initPanicItems(aMonkey, scanner.nextLine());
            initOperation(aMonkey, scanner.nextLine());
            initDivisible(aMonkey, scanner.nextLine());
            initTrueMonkey(monkeys, aMonkey, scanner.nextLine());
            initFalseMonkey(monkeys, aMonkey, scanner.nextLine());
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // read the empty line separating monkeys
            }
        }

        KeepAwayGame keepAwayGame = new KeepAwayGame(10000, monkeys.toArray(new Monkey[monkeys.size()]));
        keepAwayGame.play();

        return keepAwayGame.getMonkeys().stream()
                .map(monkey -> monkey.getNbInspectedItems())
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce((i, i2) -> i * i2)
                .get();
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

    private static void initOperation(Monkey aMonkey, String nextLine) {
        String operation = nextLine.replace("  Operation: new = old ", "");
        if (operation.startsWith("*")) {
            aMonkey.setOperation(worryLevel -> {
                String operand = operation.replace("* ", "");
                if (operand.equals("old")) {
                    return worryLevel * worryLevel;
                } else {
                    return worryLevel * Long.parseLong(operand);
                }
            });
        } else if (operation.startsWith("+")) {
            aMonkey.setOperation(worryLevel -> worryLevel + Long.parseLong(operation.replace("+ ", "")));
        }
    }

    private static void initPanicItems(Monkey aMonkey, String nextLine) {
        String[] itemWorryLevel = nextLine.replace("  Starting items: ", "").split(", ");
        for (int i = 0; i < itemWorryLevel.length; i++) {
            aMonkey.catchItem(new PanicItem(Long.parseLong(itemWorryLevel[i])));
        }
    }

    private static void initZenItems(Monkey aMonkey, String nextLine) {
        String[] itemWorryLevel = nextLine.replace("  Starting items: ", "").split(", ");
        for (int i = 0; i < itemWorryLevel.length; i++) {
            aMonkey.catchItem(new ZenItem(Long.parseLong(itemWorryLevel[i])));
        }
    }
}

//     const wl = Math.floor(monkey.operation(monkey.items.shift()) / 3);
//     const wl =            monkey.operation(monkey.items.shift()) % pod;
