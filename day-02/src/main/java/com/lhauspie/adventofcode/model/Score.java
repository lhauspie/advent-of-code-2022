package com.lhauspie.adventofcode.model;

public class Score {

    private final int value;

    public Score(int value) {
        this.value = value;
    }

    public static Score of(int value) {
        return new Score(value);
    }

    public Score add(Score score) {
        return Score.of(getValue() + score.getValue());
    }

    public int getValue() {
        return value;
    }
}
