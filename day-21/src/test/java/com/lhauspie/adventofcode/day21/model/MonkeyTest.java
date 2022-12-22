package com.lhauspie.adventofcode.day21.model;

import com.lhauspie.adventofcode.day21.PuzzleResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonkeyTest {

    @Test
    public void shouldBeAbleToRevertTheAdditionOperationToFindTheNewLeftValue() {
        OperationMonkey monkey = new OperationMonkey(
                MonkeyId.of("toto"), // left + 10 == 100
                () -> new ValueMonkey(MonkeyId.of("left"), 20L),
                () -> new ValueMonkey(MonkeyId.of("right"), 10L),
                Operation.ADDITION
        );
        Assertions.assertEquals(90, monkey.calculateTheNewLeftValue(100));
    }

    @Test
    public void shouldBeAbleToRevertTheAdditionOperationToFindTheNewRightValue() {
        OperationMonkey monkey = new OperationMonkey(
                MonkeyId.of("toto"), // 20 + right == 100
                () -> new ValueMonkey(MonkeyId.of("left"), 20L),
                () -> new ValueMonkey(MonkeyId.of("right"), 10L),
                Operation.ADDITION
        );
        assertEquals(80, monkey.calculateTheNewRightValue(100));
    }

    @Test
    public void shouldBeAbleToRevertTheMultiplicationOperationToFindTheNewLeftValue() {
        OperationMonkey monkey = new OperationMonkey(
                MonkeyId.of("toto"), // left * 10 == 100
                () -> new ValueMonkey(MonkeyId.of("left"), 20L),
                () -> new ValueMonkey(MonkeyId.of("right"), 10L),
                Operation.MULTIPLICATION
        );

        assertEquals(10, monkey.calculateTheNewLeftValue(100));
    }

    @Test
    public void shouldBeAbleToRevertTheMultiplicationOperationToFindTheNewRightValue() {
        OperationMonkey monkey = new OperationMonkey(
                MonkeyId.of("toto"), // 20 * right == 100
                () -> new ValueMonkey(MonkeyId.of("left"), 20L),
                () -> new ValueMonkey(MonkeyId.of("right"), 10L),
                Operation.MULTIPLICATION
        );

        assertEquals(5, monkey.calculateTheNewRightValue(100));
    }

    @Test
    public void shouldBeAbleToRevertTheDivisionOperationToFindTheNewLeftValue() {
        OperationMonkey monkey = new OperationMonkey(
                MonkeyId.of("toto"), // left / 20 == 100
                () -> new ValueMonkey(MonkeyId.of("left"), 10L),
                () -> new ValueMonkey(MonkeyId.of("right"), 20L),
                Operation.DIVISION
        );
        assertEquals(2000, monkey.calculateTheNewLeftValue(100));
    }

    @Test
    public void shouldBeAbleToRevertTheDivisionOperationToFindTheNewRightValue() {
        OperationMonkey monkey = new OperationMonkey(
                MonkeyId.of("toto"), // 10000 / right == 100
                () -> new ValueMonkey(MonkeyId.of("left"), 10000L),
                () -> new ValueMonkey(MonkeyId.of("right"), 20L),
                Operation.DIVISION
        );
        assertEquals(100, monkey.calculateTheNewRightValue(100));
    }

    @Test
    public void shouldBeAbleToRevertTheSubtractionOperationToFindTheNewLeftValue() {
        OperationMonkey monkey = new OperationMonkey(
                MonkeyId.of("toto"), // left - 10 == 100
                () -> new ValueMonkey(MonkeyId.of("left"), 20L),
                () -> new ValueMonkey(MonkeyId.of("right"), 10L),
                Operation.SUBTRACTION
        );

        assertEquals(110, monkey.calculateTheNewLeftValue(100));
    }

    @Test
    public void shouldBeAbleToRevertTheSubtractionOperationToFindTheNewRightValue() {
        OperationMonkey monkey = new OperationMonkey(
                MonkeyId.of("toto"), // 20 - right == 100
                () -> new ValueMonkey(MonkeyId.of("left"), 20L),
                () -> new ValueMonkey(MonkeyId.of("right"), 10L),
                Operation.SUBTRACTION
        );
        assertEquals(-80, monkey.calculateTheNewRightValue(100));
    }
}
