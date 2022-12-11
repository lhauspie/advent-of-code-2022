package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Item;
import com.lhauspie.adventofcode.model.KeepAwayGame;
import com.lhauspie.adventofcode.model.Monkey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner) {
        KeepAwayGame keepAwayGame = buildKeepAwayGame(scanner);
        keepAwayGame.play();

        return keepAwayGame.getMonkeys().stream()
                .map(monkey -> monkey.getNbInspectedItems())
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce((i, i2) -> i * i2)
                .get();
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        return 0L;
    }

    private static KeepAwayGame buildKeepAwayGame(Scanner scanner) {
        List<Monkey> monkeys = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            monkeys.add(new Monkey());
        }

        int monkeyIndex = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            Monkey aMonkey = monkeys.get(monkeyIndex++);

            String nextLine = scanner.nextLine();
            String[] itemWorryLevel = nextLine.replace("  Starting items: ", "").split(", ");
            for (int i = 0; i < itemWorryLevel.length; i++) {
                aMonkey.catchItem(new Item(Long.parseLong(itemWorryLevel[i])));
            }

            nextLine = scanner.nextLine();
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

            nextLine = scanner.nextLine();
            String condition = nextLine.replace("  Test: divisible by ", "");
            aMonkey.setCondition(worryLevel -> worryLevel % Long.parseLong(condition) == 0L);

            nextLine = scanner.nextLine();
            String ifTrue = nextLine.replace("    If true: throw to monkey ", "");
            aMonkey.setTrueMonkey(monkeys.get(Integer.parseInt(ifTrue)));

            nextLine = scanner.nextLine();
            String ifFalse = nextLine.replace("    If false: throw to monkey ", "");
            aMonkey.setFalseMonkey(monkeys.get(Integer.parseInt(ifFalse)));

            if (scanner.hasNextLine()) {
                scanner.nextLine(); // read the empty line separating monkeys
            }
        }

        return new KeepAwayGame(monkeys.toArray(new Monkey[monkeys.size()]));
    }
}

//     const wl = Math.floor(monkey.operation(monkey.items.shift()) / 3);
//     const wl =            monkey.operation(monkey.items.shift()) % pod;
