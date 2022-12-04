package com.lhauspie.adventofcode.adapter;

import com.lhauspie.adventofcode.model.HandShape;

import static com.lhauspie.adventofcode.model.HandShape.*;

public class RightDecryptor {

    public static HandShape decryptOpponentEncryptedValue(String encryptedValue) {
        return switch (encryptedValue) {
            case "A" -> ROCK;
            case "B" -> PAPER;
            case "C" -> SCISSORS;
            default -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }

    public static HandShape decryptMyEncryptedValue(HandShape opponentHandShape, String encryptedValue) {
        if (opponentHandShape.equals(ROCK)) {
            return decryptMyEncryptedValueForOpponentRock(encryptedValue);
        } else if (opponentHandShape.equals(PAPER)) {
            return decryptMyEncryptedValueForOpponentPaper(encryptedValue);
        } else if (opponentHandShape.equals(SCISSORS)) {
            return decryptMyEncryptedValueForOpponentScissors(encryptedValue);
        }
        throw new IllegalArgumentException("opponentHandShape not supported : " + opponentHandShape);
    }

    private static HandShape decryptMyEncryptedValueForOpponentRock(String encryptedValue) {
        return switch (encryptedValue) {
            case "X" -> SCISSORS;
            case "Y" -> ROCK;
            case "Z" -> PAPER;
            default -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }

    private static HandShape decryptMyEncryptedValueForOpponentPaper(String encryptedValue) {
        return switch (encryptedValue) {
            case "X" -> ROCK;
            case "Y" -> PAPER;
            case "Z" -> SCISSORS;
            default -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }

    private static HandShape decryptMyEncryptedValueForOpponentScissors(String encryptedValue) {
        return switch (encryptedValue) {
            case "X" -> PAPER;
            case "Y" -> SCISSORS;
            case "Z" -> ROCK;
            default -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }
}
