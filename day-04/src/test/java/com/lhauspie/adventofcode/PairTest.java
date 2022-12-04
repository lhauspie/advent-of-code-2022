package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Pair;
import com.lhauspie.adventofcode.model.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairTest {
    @Test
    public void testFullyContains1() {
        var range1 = new Range(10, 30);
        var range2 = new Range(40, 50);
        Assertions.assertFalse(new Pair(range1, range2).isFullyContain());
    }

    @Test
    public void testFullyContains2() {
        var range1 = new Range(10, 30);
        var range2 = new Range(20, 50);
        Assertions.assertFalse(new Pair(range1, range2).isFullyContain());
    }

    @Test
    public void testFullyContains3() {
        var range1 = new Range(20, 50);
        var range2 = new Range(10, 30);
        Assertions.assertFalse(new Pair(range1, range2).isFullyContain());
    }

    @Test
    public void testFullyContains4() {
        var range1 = new Range(20, 30);
        var range2 = new Range(10, 50);
        Assertions.assertTrue(new Pair(range1, range2).isFullyContain());
    }

    @Test
    public void testFullyContains5() {
        var range1 = new Range(10, 50);
        var range2 = new Range(20, 30);
        Assertions.assertTrue(new Pair(range1, range2).isFullyContain());
    }

    @Test
    public void testFullyContains6() {
        var range1 = new Range(10, 50);
        var range2 = new Range(20, 50);
        Assertions.assertTrue(new Pair(range1, range2).isFullyContain());
    }

    @Test
    public void testFullyContains7() {
        var range1 = new Range(10, 50);
        var range2 = new Range(10, 30);
        Assertions.assertTrue(new Pair(range1, range2).isFullyContain());
    }

    @Test
    public void testFullyContains8() {
        var range1 = new Range(10, 50);
        var range2 = new Range(10, 50);
        Assertions.assertTrue(new Pair(range1, range2).isFullyContain());
    }



    @Test
    public void testOverlap1() {
        var range1 = new Range(10, 30);
        var range2 = new Range(40, 50);
        Assertions.assertFalse(new Pair(range1, range2).isOverlap());
    }

    @Test
    public void testOverlap2() {
        var range1 = new Range(10, 30);
        var range2 = new Range(20, 50);
        Assertions.assertTrue(new Pair(range1, range2).isOverlap());
    }

    @Test
    public void testOverlap3() {
        var range1 = new Range(20, 50);
        var range2 = new Range(10, 30);
        Assertions.assertTrue(new Pair(range1, range2).isOverlap());
    }

    @Test
    public void testOverlap4() {
        var range1 = new Range(20, 30);
        var range2 = new Range(10, 50);
        Assertions.assertTrue(new Pair(range1, range2).isOverlap());
    }

    @Test
    public void testOverlap5() {
        var range1 = new Range(10, 50);
        var range2 = new Range(20, 30);
        Assertions.assertTrue(new Pair(range1, range2).isOverlap());
    }

    @Test
    public void testOverlap6() {
        var range1 = new Range(10, 50);
        var range2 = new Range(20, 50);
        Assertions.assertTrue(new Pair(range1, range2).isOverlap());
    }

    @Test
    public void testOverlap7() {
        var range1 = new Range(10, 50);
        var range2 = new Range(10, 30);
        Assertions.assertTrue(new Pair(range1, range2).isOverlap());
    }

    @Test
    public void testOverlap8() {
        var range1 = new Range(10, 50);
        var range2 = new Range(10, 50);
        Assertions.assertTrue(new Pair(range1, range2).isOverlap());
    }
}
