package com.lhauspie.adventofcode.adapter;

import org.junit.jupiter.api.Test;

import static com.lhauspie.adventofcode.model.HandShape.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WrongDecryptorTest {

  @Test
  public void handShapeFromAOpponentEncryptedValueShouldReturnRock() {
    assertEquals(ROCK, WrongDecryptor.decryptOpponentEncryptedValue("A"));
  }

  @Test
  public void handShapeFromBOpponentEncryptedValueShouldReturnPaper() {
    assertEquals(PAPER, WrongDecryptor.decryptOpponentEncryptedValue("B"));
  }

  @Test
  public void handShapeFromCOpponentEncryptedValueShouldReturnScissors() {
    assertEquals(SCISSORS, WrongDecryptor.decryptOpponentEncryptedValue("C"));
  }

  @Test
  public void handShapeFromXMyEncryptedValueShouldReturnRock() {
    assertEquals(ROCK, WrongDecryptor.decryptMyEncryptedValue("X"));
  }

  @Test
  public void handShapeFromYMyEncryptedValueShouldReturnPaper() {
    assertEquals(PAPER, WrongDecryptor.decryptMyEncryptedValue("Y"));
  }

  @Test
  public void handShapeFromZMyEncryptedValueShouldReturnScissors() {
    assertEquals(SCISSORS, WrongDecryptor.decryptMyEncryptedValue("Z"));
  }
}
