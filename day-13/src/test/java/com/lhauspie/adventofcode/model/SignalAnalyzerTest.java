package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignalAnalyzerTest {

    @Test
    public void test1() {
        String left  = "[]";
        String right = "[]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test2() {
        String left  = "[1]";
        String right = "[]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test3() {
        String left  = "[]";
        String right = "[1]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test4() {
        String left  = "[1]";
        String right = "[2]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test4_1() {
        String left  = "[1]";
        String right = "[1]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test5() {
        String left  = "[2]";
        String right = "[1]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test6() {
        String left  = "[[2]]";
        String right = "[1]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test7() {
        String left  = "[[1]]";
        String right = "[2]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test8() {
        String left  = "[2]";
        String right = "[[1]]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test9() {
        String left  = "[[2]]";
        String right = "[[1]]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test10() {
        String left  = "[1,1]";
        String right = "[1]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample1() {
        String left  = "[1,1,3,1,1]";
        String right = "[1,1,5,1,1]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample2() {
        String left  = "[[1],[2,3,4]]";
        String right = "[[1],4]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample2_1() {
        String left  = "[[1],[2,3,4]]";
        String right = "[[1,4]]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample2_2() {
        String left  = "[[1],[2,3,4]]";
        String right = "[[1],1]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample2_3() {
        String left  = "[[1],[2,3,4]]";
        String right = "[[1],[2,1]]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample3() {
        String left  = "[9]";
        String right = "[[8,7,6]]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample4() {
        String left  = "[[4,4],4,4]";
        String right = "[[4,4],4,4,4]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample5() {
        String left  = "[7,7,7,7]";
        String right = "[7,7,7]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample6() {
        String left  = "[]";
        String right = "[3]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample7() {
        String left  = "[[[]]]";
        String right = "[[]]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample9() {
        String left  = "[1,[2,[3,[4,[5,6,7]]]],8,9]";
        String right = "[1,[2,[3,[4,[5,6,0]]]],8,9]";

        assertFalse(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample10() {
        String left  = "[1,[2,[3,[4,[5,6,7]]]],8,9]";
        String right = "[1,[2,[3,[4,[5,6,7]]]],8,9,0]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample11() {
        String left  = "[1,[2,[3,[4,[5,6,7]]]],8,9]";
        String right = "[1,[2,[3,[4,[5,6,8]]]],8,9,0]";

        assertTrue(SignalAnalyzer.pairIsInTheRightOrder(left, right));
    }
}