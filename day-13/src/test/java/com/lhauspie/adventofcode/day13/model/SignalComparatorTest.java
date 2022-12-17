package com.lhauspie.adventofcode.day13.model;

import com.lhauspie.adventofcode.day13.model.SignalComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignalComparatorTest {

    @Test
    public void test1() {
        String left  = "[]";
        String right = "[]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test1_2() {
        String left  = "[[],[1]]";
        String right = "[[],[1]]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test1_3() {
        String left  = "[[],[2]]";
        String right = "[[],[1]]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test2() {
        String left  = "[1]";
        String right = "[]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test3() {
        String left  = "[]";
        String right = "[1]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test4() {
        String left  = "[1]";
        String right = "[2]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test4_1() {
        String left  = "[1]";
        String right = "[1]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test5() {
        String left  = "[2]";
        String right = "[1]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test6() {
        String left  = "[[2]]";
        String right = "[1]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test7() {
        String left  = "[[1]]";
        String right = "[2]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test8() {
        String left  = "[2]";
        String right = "[[1]]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test9() {
        String left  = "[[2]]";
        String right = "[[1]]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void test10() {
        String left  = "[1,1]";
        String right = "[1]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample1() {
        String left  = "[1,1,3,1,1]";
        String right = "[1,1,5,1,1]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample2() {
        String left  = "[[1],[2,3,4]]";
        String right = "[[1],4]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample2_1() {
        String left  = "[[1],[2,3,4]]";
        String right = "[[1,4]]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample2_2() {
        String left  = "[[1],[2,3,4]]";
        String right = "[[1],1]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample2_3() {
        String left  = "[[1],[2,3,4]]";
        String right = "[[1],[2,1]]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample3() {
        String left  = "[9]";
        String right = "[[8,7,6]]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample4() {
        String left  = "[[4,4],4,4]";
        String right = "[[4,4],4,4,4]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample5() {
        String left  = "[7,7,7,7]";
        String right = "[7,7,7]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample6() {
        String left  = "[]";
        String right = "[3]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample7() {
        String left  = "[[[]]]";
        String right = "[[]]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample8() {
        String left  = "[1,[2,[3,[4,[5,6,7]]]],8,9]";
        String right = "[1,[2,[3,[4,[5,6,0]]]],8,9]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample9() {
        String left  = "[1,[2,[3,[4,[5,6,7]]]],8,9]";
        String right = "[1,[2,[3,[4,[5,6,7]]]],8,9,0]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleExample10() {
        String left  = "[1,[2,[3,[4,[5,6,7]]]],8,9]";
        String right = "[1,[2,[3,[4,[5,6,8]]]],8,9,0]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleInputPair1() {
        String left  = "[[7,6,3,6,10],[[[5,3,6,7,7]],2,1,2,6]]";
        String right = "[[],[8,[8,6,5],[[5,1,8]],7],[]]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleInputPair2() {
        String left  = "[[10,[],[9,8,6,[2,7,0,8]],[],[[4,6,2,1,4],6,5]]]";
        String right = "[[4,5,1,[[0,0],[6,10],4,5],10],[[2,4,6,1,[6,8]],[[2,0,10]],[[5,10],[6,4,5,6],[8,9,2]]],[[[],10,0,7,7],[[9,9,7,3,8]]],[[[7],3,8],[6,3],1,5]]";

        assertFalse(SignalComparator.pairIsInTheRightOrder(left, right));
    }

    @Test
    public void testPuzzleInputPair3() {
        String left  = "[[0,[[9,6,4,5]],[]]]";
        String right = "[[10,9,[[5,7],4,[5,8,0,9,8],[0,10],[3,1]],4]]";

        assertTrue(SignalComparator.pairIsInTheRightOrder(left, right));
    }
}