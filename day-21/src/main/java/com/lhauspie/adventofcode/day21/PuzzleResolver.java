package com.lhauspie.adventofcode.day21;

import com.lhauspie.adventofcode.day21.model.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuzzleResolver {

    private static final MonkeyId ROOT = MonkeyId.of("root");
    private static final MonkeyId HUMAN = MonkeyId.of("humn");

    public static long resolveFirstPuzzle(Scanner scanner) {
        Map<MonkeyId, Monkey> monkeys = parseInput(scanner);
        return monkeys.get(ROOT).getValue();
    }

    private static Map<MonkeyId, Monkey> monkeys = new HashMap<>();

    private static Map<MonkeyId, Monkey> parseInput(Scanner scanner) {

        Pattern monkeyJobPattern = Pattern.compile("([a-z]+): ([a-z]+) (.) ([a-z]+)");
        Pattern monkeyNumberPattern = Pattern.compile("([a-z]+): ([0-9]+)");

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            Monkey monkey = null;

            Matcher monkeyJobMatcher = monkeyJobPattern.matcher(nextLine);
            if (monkeyJobMatcher.find()) {
                monkey = buildOperationMonkey(
                        monkeys,
                        MonkeyId.of(monkeyJobMatcher.group(1)),
                        MonkeyId.of(monkeyJobMatcher.group(2)),
                        MonkeyId.of(monkeyJobMatcher.group(4)),
                        monkeyJobMatcher.group(3)
                );
            } else {
                Matcher monkeyNumberMatcher = monkeyNumberPattern.matcher(nextLine);
                if (monkeyNumberMatcher.find()) {
                    monkey = new ValueMonkey(
                            MonkeyId.of(monkeyNumberMatcher.group(1)),
                            Long.parseLong(monkeyNumberMatcher.group(2)));
                }
            }
            monkeys.put(monkey.getId(), monkey);
        }

        return monkeys;
    }

    private static OperationMonkey buildOperationMonkey(Map<MonkeyId, Monkey> monkeys, MonkeyId monkeyId, MonkeyId leftMonkeyId, MonkeyId rightMonkeyId, String operator) {
        return new OperationMonkey(
                monkeyId,
                () -> monkeys.get(leftMonkeyId),
                () -> monkeys.get(rightMonkeyId),
                Operation.valueOf(operator)
        );
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        Map<MonkeyId, Monkey> monkeys = parseInput(scanner);
        Set<MonkeyId> monkeyIdsLinkedToHuman = getMonkeyIdsThatLeadToHumanIncludingTheHuman(monkeys);

        Monkey leftMonkey = ((OperationMonkey) monkeys.get(ROOT)).getLeftMonkey();
        Monkey rightMonkey = ((OperationMonkey) monkeys.get(ROOT)).getRightMonkey();
        long valueHumanNeedToYell = 0;
        if (monkeyIdsLinkedToHuman.contains(leftMonkey.getId())) {
            // leftMonkey is linked to Human, so ask the human response to the left monkey and provide the expected result
            valueHumanNeedToYell = getValueHumanNeedToYellToRespectEquality(monkeyIdsLinkedToHuman, leftMonkey, rightMonkey.getValue());
        }
        if (monkeyIdsLinkedToHuman.contains(rightMonkey.getId())) {
            // rightMonkey is linked to Human, so ask the human response to the left monkey and provide the expected result
            valueHumanNeedToYell = getValueHumanNeedToYellToRespectEquality(monkeyIdsLinkedToHuman, rightMonkey, leftMonkey.getValue());
        }

        return valueHumanNeedToYell;
    }

    private static Set<MonkeyId> getMonkeyIdsThatLeadToHumanIncludingTheHuman(Map<MonkeyId, Monkey> monkeys) {
        Map<MonkeyId, Monkey> parentMonkeys = getMapMonkeyIdToParentMonkey(monkeys);

        Set<MonkeyId> monkeyIdsThatLeadToHuman = new HashSet<>();
        Monkey parentMonkeyOfHuman = parentMonkeys.get(HUMAN);
        monkeyIdsThatLeadToHuman.add(HUMAN);
        while (parentMonkeyOfHuman != null) {
            monkeyIdsThatLeadToHuman.add(parentMonkeyOfHuman.getId());
            parentMonkeyOfHuman = parentMonkeys.get(parentMonkeyOfHuman.getId());
        }
        return monkeyIdsThatLeadToHuman;
    }

    private static Map<MonkeyId, Monkey> getMapMonkeyIdToParentMonkey(Map<MonkeyId, Monkey> monkeys) {
        Map<MonkeyId, Monkey> parentMonkeys = new HashMap<>();
        monkeys.values().stream()
                .filter(monkey -> monkey instanceof OperationMonkey)
                .map(monkey -> (OperationMonkey) monkey)
                .forEach(operationMonkey -> {
                    parentMonkeys.put(operationMonkey.getLeftMonkey().getId(), operationMonkey);
                    parentMonkeys.put(operationMonkey.getRightMonkey().getId(), operationMonkey);
                });
        return parentMonkeys;
    }

    private static long getValueHumanNeedToYellToRespectEquality(Set<MonkeyId> monkeyIdsLinkedToHuman, Monkey monkey, long value) {
        // Here the monkey is the Human because we only followed the path that led to the human
        if (monkey.getId().equals(HUMAN)) {
            return value;
        }

        OperationMonkey operationMonkey = (OperationMonkey) monkey;
        Monkey leftMonkey  = operationMonkey.getLeftMonkey();
        Monkey rightMonkey = operationMonkey.getRightMonkey();

        long valueHumanNeedToYell = 0;
        if (monkeyIdsLinkedToHuman.contains(leftMonkey.getId())) {
            // leftMonkey is linked to Human, so ask the human response to the left monkey and provide the expected result
            long newLeftValue = operationMonkey.calculateTheNewLeftValue(value);
            valueHumanNeedToYell = getValueHumanNeedToYellToRespectEquality(monkeyIdsLinkedToHuman, leftMonkey, newLeftValue);
        }
        if (monkeyIdsLinkedToHuman.contains(rightMonkey.getId())) {
            // rightMonkey is linked to Human, so ask the human response to the left monkey and provide the expected result
            long newRightValue = operationMonkey.calculateTheNewRightValue(value);
            valueHumanNeedToYell = getValueHumanNeedToYellToRespectEquality(monkeyIdsLinkedToHuman, rightMonkey, newRightValue);
        }

        return valueHumanNeedToYell;
    }
}
