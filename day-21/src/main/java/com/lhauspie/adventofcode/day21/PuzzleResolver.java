package com.lhauspie.adventofcode.day21;

import com.lhauspie.adventofcode.day21.model.Monkey;
import com.lhauspie.adventofcode.day21.model.Operation;
import com.lhauspie.adventofcode.day21.model.OperationMonkey;
import com.lhauspie.adventofcode.day21.model.ValueMonkey;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuzzleResolver {

    private static final String ROOT = "root";
    private static Map<String, Monkey> monkeys = new HashMap<>();
    private static Map<String, Operation> operations = Map.of(
            "+", Operation.PLUS,
            "-", Operation.MINUS,
            "/", Operation.DIVIDE,
            "*", Operation.MULTIPLY
    );

    public static long resolveFirstPuzzle(Scanner scanner) {
        Pattern monkeyJobPattern = Pattern.compile("([a-z]+): ([a-z]+) (.) ([a-z]+)");
        Pattern monkeyNumberPattern = Pattern.compile("([a-z]+): ([0-9]+)");

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            Monkey monkey = null;

            Matcher monkeyJobMatcher = monkeyJobPattern.matcher(nextLine);
            if (monkeyJobMatcher.find()) {
                monkey = buildOperationMonkey(
                        monkeyJobMatcher.group(1),
                        monkeyJobMatcher.group(2),
                        monkeyJobMatcher.group(4),
                        monkeyJobMatcher.group(3)
                );
            } else {
                Matcher monkeyNumberMatcher = monkeyNumberPattern.matcher(nextLine);
                if (monkeyNumberMatcher.find()) {
                    monkey = new ValueMonkey(
                            monkeyNumberMatcher.group(1),
                            Long.parseLong(monkeyNumberMatcher.group(2)));
                }
            }
            monkeys.put(monkey.getId(), monkey);
        }
        return monkeys.get(ROOT).getValue();
    }

    private static Monkey buildOperationMonkey(String monkeyId, String leftMonkeyId, String rightMonkeyId, String operator) {
        return new OperationMonkey(
                monkeyId,
                () -> monkeys.get(leftMonkeyId),
                () -> monkeys.get(rightMonkeyId),
                operations.get(operator)
        );
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        return 0;
    }
}
