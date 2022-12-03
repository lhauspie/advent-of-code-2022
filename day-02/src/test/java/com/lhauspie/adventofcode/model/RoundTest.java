package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static com.lhauspie.adventofcode.model.HandShape.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundTest {

  @Test
  public void rockDefeatsScissorsAndResultsInScoreOfSeven() {
    var round = new Round(ROCK, SCISSORS);
    assertEquals(7, round.getScore().getValue());
  }

  @Test
  public void paperDefeatsRockAndResultsInScoreOfEight() {
    var round = new Round(PAPER, ROCK);
    assertEquals(8, round.getScore().getValue());
  }

  @Test
  public void scissorsDefeatsPaperAndResultsInScoreOfNine() {
    var round = new Round(SCISSORS, PAPER);
    assertEquals(9, round.getScore().getValue());
  }

  @Test
  public void rockIsDrawWithRockAndResultsInScoreOfFour() {
    var round = new Round(ROCK, ROCK);
    assertEquals(4, round.getScore().getValue());
  }

  @Test
  public void paperIsDrawWithRockAndResultsInScoreOfFive() {
    var round = new Round(PAPER, PAPER);
    assertEquals(5, round.getScore().getValue());
  }

  @Test
  public void scissorsIsDrawWithRockAndResultsInScoreOfSix() {
    var round = new Round(SCISSORS, SCISSORS);
    assertEquals(6, round.getScore().getValue());
  }

  @Test
  public void rockIsDefeatedByPaperAndResultsInScoreOfOne() {
    var round = new Round(ROCK, PAPER);
    assertEquals(1, round.getScore().getValue());
  }

  @Test
  public void paperIsDefeatedByScissorsAndResultsInScoreOfTwo() {
    var round = new Round(PAPER, SCISSORS);
    assertEquals(2, round.getScore().getValue());
  }

  @Test
  public void scissorsIsDefeatedByRockAndResultsInScoreOfThree() {
    var round = new Round(SCISSORS, ROCK);
    assertEquals(3, round.getScore().getValue());
  }
}
