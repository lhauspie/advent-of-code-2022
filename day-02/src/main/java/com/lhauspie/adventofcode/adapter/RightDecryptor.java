package com.lhauspie.adventofcode.adapter;

import com.lhauspie.adventofcode.model.HandShape;

import static com.lhauspie.adventofcode.model.HandShape.*;

public class RightDecryptor {

    public static HandShape decryptOpponentEncryptedValue(String encryptedValue) {
        return switch (encryptedValue) {
            case "A" -> ROCK;
            case "B" -> PAPER;
            case "C" -> SCISSORS;
            default  -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }

    public static HandShape decryptMyEncryptedValue(HandShape opponentHandShape, String encryptedValue) {
        if (opponentHandShape.equals(ROCK)) {
            return decryptMyEncryptedValueForRock(encryptedValue);
        } else if(opponentHandShape.equals(PAPER)) {
            return decryptMyEncryptedValueForPaper(encryptedValue);
        } else if(opponentHandShape.equals(SCISSORS)) {
            return decryptMyEncryptedValueForScissors(encryptedValue);
        }
        throw new IllegalArgumentException("opponentHandShape not supported : " + opponentHandShape);
    }

    private static HandShape decryptMyEncryptedValueForRock(String encryptedValue) {
        return switch (encryptedValue) {
            case "X" -> SCISSORS;
            case "Y" -> ROCK;
            case "Z" -> PAPER;
            default  -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }

    private static HandShape decryptMyEncryptedValueForPaper(String encryptedValue) {
        return switch (encryptedValue) {
            case "X" -> ROCK;
            case "Y" -> PAPER;
            case "Z" -> SCISSORS;
            default  -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }

    private static HandShape decryptMyEncryptedValueForScissors(String encryptedValue) {
        return switch (encryptedValue) {
            case "X" -> PAPER;
            case "Y" -> SCISSORS;
            case "Z" -> ROCK;
            default  -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }
}
