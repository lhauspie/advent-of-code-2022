package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Test;

import static com.lhauspie.adventofcode.model.HandShape.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

  @Test
  public void gameWithoutRoundShouldResultInScoreOfZero() {
    var game = new Game();
    assertEquals(0, game.getGameScore().getValue());
  }

  @Test
  public void gameWithOneRockDrawRoundShouldResultInScoreOfFour() {
    var game = new Game().play(new Round(ROCK, ROCK));
    assertEquals(4, game.getGameScore().getValue());
  }

  @Test
  public void gameWithFiveRockDrawRoundShouldResultInScoreOfTwenty() {
    var game =
        new Game()
            .play(new Round(ROCK, ROCK))
            .play(new Round(ROCK, ROCK))
            .play(new Round(ROCK, ROCK))
            .play(new Round(ROCK, ROCK))
            .play(new Round(ROCK, ROCK));
    assertEquals(20, game.getGameScore().getValue());
  }

  @Test
  public void
      gameWithOneRockWinningRoundAndOnePaperWinningRoundAndOneScissorsWinningRoundShouldResultInScoreOfTwentyFour() {
    var game =
        new Game()
            .play(new Round(ROCK, SCISSORS))
            .play(new Round(PAPER, ROCK))
            .play(new Round(SCISSORS, PAPER));
    assertEquals(24, game.getGameScore().getValue());
  }
}
