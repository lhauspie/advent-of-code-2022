package com.lhauspie.adventofcode.model;

public enum HandShape {
  ROCK(Score.of(1)),
  PAPER(Score.of(2)),
  SCISSORS(Score.of(3));

  private final Score score;

  HandShape(Score score) {
    this.score = score;
  }

  public Score getScore() {
    return score;
  }

  public boolean draw(HandShape handShape) {
    return this.equals(handShape);
  }

  public boolean defeats(HandShape handShape) {
    return this.equals(ROCK) && handShape.equals(SCISSORS)
        || this.equals(PAPER) && handShape.equals(ROCK)
        || this.equals(SCISSORS) && handShape.equals(PAPER);
  }
}
