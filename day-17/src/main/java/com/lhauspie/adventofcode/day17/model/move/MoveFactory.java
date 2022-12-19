package com.lhauspie.adventofcode.day17.model.move;

public class MoveFactory {
    private char[] moves;
    private int index = 0;

    public MoveFactory(String moves) {
        this.moves = moves.toCharArray();
    }

    public Move nextMove() {
        char nextMove = moves[index];
        incrementIndex();
        return nextMove == '>' ? Move.RIGHT : Move.LEFT;
    }

    private void incrementIndex() {
        index++;
        if (index >= moves.length) {
            index = 0;
        }
    }
}
