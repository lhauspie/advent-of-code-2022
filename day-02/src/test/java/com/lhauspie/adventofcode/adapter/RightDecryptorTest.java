package com.lhauspie.adventofcode.adapter;

import org.junit.jupiter.api.Test;

import static com.lhauspie.adventofcode.model.HandShape.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RightDecryptorTest {

    @Test
    public void givenOpponentHandShapeIsRockAndMyEncryptedValueIsX_thenIShouldChooseScissors() {
        assertEquals(SCISSORS, RightDecryptor.decryptMyEncryptedValue(ROCK, "X"));
    }

    @Test
    public void givenOpponentHandShapeIsRockAndMyEncryptedValueIsY_thenIShouldChooseRock() {
        assertEquals(ROCK, RightDecryptor.decryptMyEncryptedValue(ROCK, "Y"));
    }

    @Test
    public void givenOpponentHandShapeIsRockAndMyEncryptedValueIsZ_thenIShouldChoosePaper() {
        assertEquals(PAPER, RightDecryptor.decryptMyEncryptedValue(ROCK, "Z"));
    }

    @Test
    public void givenOpponentHandShapeIsPaperAndMyEncryptedValueIsX_thenIShouldChooseRock() {
        assertEquals(ROCK, RightDecryptor.decryptMyEncryptedValue(PAPER, "X"));
    }

    @Test
    public void givenOpponentHandShapeIsPaperAndMyEncryptedValueIsY_thenIShouldChooseRock() {
        assertEquals(PAPER, RightDecryptor.decryptMyEncryptedValue(PAPER, "Y"));
    }

    @Test
    public void givenOpponentHandShapeIsPaperAndMyEncryptedValueIsZ_thenIShouldChoosePaper() {
        assertEquals(SCISSORS, RightDecryptor.decryptMyEncryptedValue(PAPER, "Z"));
    }

    @Test
    public void givenOpponentHandShapeIsScissorsAndMyEncryptedValueIsX_thenIShouldChooseRock() {
        assertEquals(PAPER, RightDecryptor.decryptMyEncryptedValue(SCISSORS, "X"));
    }

    @Test
    public void givenOpponentHandShapeIsScissorsAndMyEncryptedValueIsY_thenIShouldChooseRock() {
        assertEquals(SCISSORS, RightDecryptor.decryptMyEncryptedValue(SCISSORS, "Y"));
    }

    @Test
    public void givenOpponentHandShapeIsScissorsAndMyEncryptedValueIsZ_thenIShouldChoosePaper() {
        assertEquals(ROCK, RightDecryptor.decryptMyEncryptedValue(SCISSORS, "Z"));
    }
}
