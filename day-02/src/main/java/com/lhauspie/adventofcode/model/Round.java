package com.lhauspie.adventofcode.model;

public class Round {

    private HandShape playerOneHandShape;
    private HandShape playerTwoHandShape;

    public Round(HandShape playerOneHandShape, HandShape playerTwoHandShape) {
        this.playerOneHandShape = playerOneHandShape;
        this.playerTwoHandShape = playerTwoHandShape;
    }

    public Score getScore() {
        return playerOneHandShape.getScore().add(getRoundScore());
    }

    private Score getRoundScore() {
        var roundScore = 0;
        if (playerOneHandShape.defeats(playerTwoHandShape)) {
            roundScore = 6;
        } else if (playerOneHandShape.draw(playerTwoHandShape)) {
            roundScore = 3;
        }
        return Score.of(roundScore);
    }
}
