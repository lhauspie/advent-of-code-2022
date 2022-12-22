package com.lhauspie.adventofcode.day20.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequenceTest {

    @Test
    public void testOne() {
        // encrypted sequence : 0, 1, 2
        // NOT Moving 0 results in : 0, 1, 2
        // Moving 1 right once should result in : 0, 2, 1
        // Moving 2 right once should result in : 0, 1, 2
        // Moving 2 right once should result in : 0, 2, 1
        // decrypted sequence : 0, 2, 1
        Sequence seq = new Sequence();
        seq.add(0);
        seq.add(1);
        seq.add(2);

        Number zero = seq.decryptAndGetZeroNumber();

        assertAll(
                () -> assertEquals(0, zero.getValue()),
                () -> assertEquals(2, zero.getNextNumber().getValue()),
                () -> assertEquals(1, zero.getNextNumber().getNextNumber().getValue())
        );
    }

    @Test
    public void testTwo() {
        // encrypted sequence : 3, 0, 5
        // Moving 3 right once should result in : 0, 3, 5
        // Moving 3 right once should result in : 0, 5, 3
        // Moving 3 right once should result in : 0, 3, 5

        // NOT Moving 0 results in : 0, 3, 5

        // Moving 5 right once should result in : 0, 5, 3
        // Moving 5 right once should result in : 0, 3, 5
        // Moving 5 right once should result in : 0, 5, 3
        // Moving 5 right once should result in : 0, 3, 5
        // Moving 5 right once should result in : 0, 5, 3

        // decrypted sequence : 3, 4, 5
        Sequence seq = new Sequence();
        seq.add(3);
        seq.add(0);
        seq.add(5);

        Number zero = seq.decryptAndGetZeroNumber();

        assertAll(
                () -> assertEquals(0, zero.getValue()),
                () -> assertEquals(5, zero.getNextNumber().getValue()),
                () -> assertEquals(3, zero.getNextNumber().getNextNumber().getValue())
        );
    }

    @Test
    public void testThree() {
        // encrypted sequence : 3, 0, 20
        // Moving 3 right once should result in : 0,  3, 20
        // Moving 3 right once should result in : 0, 20,  3
        // Moving 3 right once should result in : 0,  3, 20

        // NOT Moving 0 results in : 0, 3, 5

        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20
        // Moving 20 right once should result in : 0, 20,  3
        // Moving 20 right once should result in : 0,  3, 20

        // decrypted sequence : 3, 4, 5
        Sequence seq = new Sequence();
        seq.add(3);
        seq.add(0);
        seq.add(20);

        Number zero = seq.decryptAndGetZeroNumber();

        assertAll(
                () -> assertEquals(0, zero.getValue()),
                () -> assertEquals(3, zero.getNextNumber().getValue()),
                () -> assertEquals(20, zero.getNextNumber().getNextNumber().getValue())
        );
    }


    @Test
    public void testFour() {
        // encrypted sequence : 3, 0, -5
        // Moving 3 right once should result in : 0,  3, -5
        // Moving 3 right once should result in : 0, -5,  3
        // Moving 3 right once should result in : 0,  3, -5

        // NOT Moving 0 results in : 0, 3, 5

        // Moving -5 left once should result in :  0, -5,  3
        // Moving -5 left once should result in : -5,  0,  3
        // Moving -5 left once should result in :  0, -5,  3
        // Moving -5 left once should result in : -5,  0,  3
        // Moving -5 left once should result in :  0, -5,  3

        // decrypted sequence : 0, -5, 3
        Sequence seq = new Sequence();
        seq.add(3);
        seq.add(0);
        seq.add(-5);

        Number zero = seq.decryptAndGetZeroNumber();

        assertAll(
                () -> assertEquals(0, zero.getValue()),
                () -> assertEquals(-5, zero.getNextNumber().getValue()),
                () -> assertEquals(3, zero.getNextNumber().getNextNumber().getValue())
        );
    }


    @Test
    public void testSeven() {
        // encrypted sequence : 0, -1, -3
        // NOT Moving 0 results in : 0, -1, -3
        // Moving -1 left once should result in : -1,  0, -3
        // Moving -3 left once should result in : -1, -3,  0
        // Moving -3 left once should result in : -3, -1,  0
        // Moving -3 left once should result in : -1, -3,  0
        // decrypted sequence : 0, 2, 1
        Sequence seq = new Sequence();
        seq.add(0);
        seq.add(-1);
        seq.add(-3);

        Number zero = seq.decryptAndGetZeroNumber();

        assertAll(
                () -> assertEquals(0, zero.getValue()),
                () -> assertEquals(-1, zero.getNextNumber().getValue()),
                () -> assertEquals(-3, zero.getNextNumber().getNextNumber().getValue())
        );
    }

    @Test
    public void testTen() {
        Sequence seq = new Sequence();
        seq.add(1);
        seq.add(2);
        seq.add(-3);
        seq.add(3);
        seq.add(-2);
        seq.add(0);
        seq.add(4);

        Number zero = seq.decryptAndGetZeroNumber();
        Number number = zero;

        for (int i = 0; i < 7; i++) {
            System.out.print(number.getValue() + ", ");
            number = number.getNextNumber();
        }
        System.out.println();

        assertAll(
                () -> assertEquals(0, zero.getValue(), "Error at position 1"),
                () -> assertEquals(3, zero.getNextNumber().getValue(), "Error at position 2"),
                () -> assertEquals(-2, zero.getNextNumber().getNextNumber().getValue(), "Error at position 3"),
                () -> assertEquals(1, zero.getNextNumber().getNextNumber().getNextNumber().getValue(), "Error at position 4"),
                () -> assertEquals(2, zero.getNextNumber().getNextNumber().getNextNumber().getNextNumber().getValue(), "Error at position 5"),
                () -> assertEquals(-3, zero.getNextNumber().getNextNumber().getNextNumber().getNextNumber().getNextNumber().getValue(), "Error at position 6"),
                () -> assertEquals(4, zero.getNextNumber().getNextNumber().getNextNumber().getNextNumber().getNextNumber().getNextNumber().getValue(), "Error at position 7")
        );
    }

    @Test
    public void testEleven() {
        Sequence seq = new Sequence();
        seq.add(1);
        seq.add(2);
        seq.add(-3);
        seq.add(3);
        seq.add(-2);
        seq.add(0);
        seq.add(4);

        Number zero = seq.decryptAndGetZeroNumber(811589153);
        Number number = zero;
        for (int i = 0; i < 7; i++) {
            System.out.print(number.getValue() + ", ");
            number = number.getNextNumber();
        }
        System.out.println();
        number = zero;
        for (int i = 0; i < 7; i++) {
            System.out.print(number.getMoveValue() + ", ");
            number = number.getNextNumber();
        }
        System.out.println();

        assertAll(
                () -> assertEquals(0, zero.getValue(), "Error at position 1"),
                () -> assertEquals(-2434767459L, zero.getNextNumber().getValue(), "Error at position 2"),
                () -> assertEquals(1623178306L, zero.getNextNumber().getNextNumber().getValue(), "Error at position 3"),
                () -> assertEquals(3246356612L, zero.getNextNumber().getNextNumber().getNextNumber().getValue(), "Error at position 4"),
                () -> assertEquals(-1623178306L, zero.getNextNumber().getNextNumber().getNextNumber().getNextNumber().getValue(), "Error at position 5"),
                () -> assertEquals( 2434767459L, zero.getNextNumber().getNextNumber().getNextNumber().getNextNumber().getNextNumber().getValue(), "Error at position 6"),
                () -> assertEquals( 811589153L, zero.getNextNumber().getNextNumber().getNextNumber().getNextNumber().getNextNumber().getNextNumber().getValue(), "Error at position 7")
        );
    }
}
