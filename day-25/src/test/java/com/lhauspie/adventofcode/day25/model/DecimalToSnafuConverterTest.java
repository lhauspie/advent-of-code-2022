package com.lhauspie.adventofcode.day25.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecimalToSnafuConverterTest {

    @Test
    public void testOne() {
        assertEquals("1", DecimalToSnafuConverter.convert(1));
    }

    @Test
    public void testTwo() {
        assertEquals("2", DecimalToSnafuConverter.convert(2));
    }

    @Test
    public void testThree() {
        assertEquals("1=", DecimalToSnafuConverter.convert(3));
    }

    @Test
    public void testFour() {
        assertEquals("1-", DecimalToSnafuConverter.convert(4));
    }

    @Test
    public void testFive() {
        assertEquals("10", DecimalToSnafuConverter.convert(5));
    }

    @Test
    public void testSix() {
        assertEquals("11", DecimalToSnafuConverter.convert(6));
    }

    @Test
    public void testSeven() {
        assertEquals("12", DecimalToSnafuConverter.convert(7));
    }

    @Test
    public void testEight() {
        assertEquals("2=", DecimalToSnafuConverter.convert(8));
    }

    @Test
    public void testNine() {
        assertEquals("2-", DecimalToSnafuConverter.convert(9));
    }

    @Test
    public void testTen() {
        assertEquals("20", DecimalToSnafuConverter.convert(10));
    }

    @Test
    public void testEleven() {
        assertEquals("21", DecimalToSnafuConverter.convert(11));
    }

    @Test
    public void testTwelve() {
        assertEquals("22", DecimalToSnafuConverter.convert(12));
    }

    @Test
    public void testFifteen() {
        assertEquals("1=0", DecimalToSnafuConverter.convert(15));
    }

    @Test
    public void testTwenty() {
        assertEquals("1-0", DecimalToSnafuConverter.convert(20));
    }

    @Test
    public void testTwentyFive() {
        assertEquals("100", DecimalToSnafuConverter.convert(25));
    }

    @Test
    public void testThirtyEight() {
        assertEquals("2==", DecimalToSnafuConverter.convert(38));
    }

    @Test
    public void testForty() {
        assertEquals("2=0", DecimalToSnafuConverter.convert(40));
    }

    @Test
    public void testSixtyTwo() {
        assertEquals("222", DecimalToSnafuConverter.convert(62));
    }

    @Test
    public void testSixtyThree() {
        assertEquals("1===", DecimalToSnafuConverter.convert(63));
    }

    @Test
    public void testSixtyFive() {
        assertEquals("1==0", DecimalToSnafuConverter.convert(65));
    }

    @Test
    public void testOneHundredAndEightyEight() {
        assertEquals("2===", DecimalToSnafuConverter.convert(188));
    }

    @Test
    public void testOneTwoThreeFourFive() {
        assertEquals("1-0---0", DecimalToSnafuConverter.convert(12345));
    }

    @Test
    public void testThreeOneFourOneFiveNineTwoSixFive() {
        assertEquals("1121-1110-1=0", DecimalToSnafuConverter.convert(314159265));
    }
}
