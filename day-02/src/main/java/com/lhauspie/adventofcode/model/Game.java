package com.lhauspie.adventofcode.model;

public class Game {

  private Score gameScore = Score.of(0);

  public Game play(Round round) {
    this.gameScore = this.gameScore.add(round.getScore());
    return this;
  }

  public Score getGameScore() {
    return gameScore;
  }
}
