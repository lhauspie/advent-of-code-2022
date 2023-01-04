package com.lhauspie.adventofcode.day25.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnafuToDecimalConverterTest {

    @Test
    public void testOne() {
        assertEquals(1, SnafuToDecimalConverter.convert("1"));
    }

    @Test
    public void testTwo() {
        assertEquals(2, SnafuToDecimalConverter.convert("2"));
    }

    @Test
    public void testThree() {
        assertEquals(3, SnafuToDecimalConverter.convert("1="));
    }

    @Test
    public void testFour() {
        assertEquals(4, SnafuToDecimalConverter.convert("1-"));
    }

    @Test
    public void testFive() {
        assertEquals(5, SnafuToDecimalConverter.convert("10"));
    }

    @Test
    public void testSix() {
        assertEquals(6, SnafuToDecimalConverter.convert("11"));
    }

    @Test
    public void testSeven() {
        assertEquals(7, SnafuToDecimalConverter.convert("12"));
    }

    @Test
    public void testEight() {
        assertEquals(8, SnafuToDecimalConverter.convert("2="));
    }

    @Test
    public void testNine() {
        assertEquals(9, SnafuToDecimalConverter.convert("2-"));
    }

    @Test
    public void testTen() {
        assertEquals(10, SnafuToDecimalConverter.convert("20"));
    }

    @Test
    public void testFifteen() {
        assertEquals(15, SnafuToDecimalConverter.convert("1=0"));
    }

    @Test
    public void testTwenty() {
        assertEquals(20, SnafuToDecimalConverter.convert("1-0"));
    }

    @Test
    public void testForty() {
        assertEquals(40, SnafuToDecimalConverter.convert("2=0"));
    }

    @Test
    public void testOneHundredAndTwentyFive() {
        assertEquals(125, SnafuToDecimalConverter.convert("1000"));
    }

    @Test
    public void testTwoThousandAndTwentyTwo() {
        assertEquals(2022, SnafuToDecimalConverter.convert("1=11-2"));
    }

    @Test
    public void testOneTwoThreeFourFive() {
        assertEquals(12345, SnafuToDecimalConverter.convert("1-0---0"));
    }

    @Test
    public void testThreeOneFourOneFiveNineTwoSixFive() {
        assertEquals(314159265, SnafuToDecimalConverter.convert("1121-1110-1=0"));
    }
}
