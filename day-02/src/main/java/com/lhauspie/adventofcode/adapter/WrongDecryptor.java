package com.lhauspie.adventofcode.adapter;

import com.lhauspie.adventofcode.model.HandShape;

import static com.lhauspie.adventofcode.model.HandShape.*;

public class WrongDecryptor {

    public static HandShape decryptOpponentEncryptedValue(String encryptedValue) {
        return switch (encryptedValue) {
            case "A" -> ROCK;
            case "B" -> PAPER;
            case "C" -> SCISSORS;
            default -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }

    public static HandShape decryptMyEncryptedValue(String encryptedValue) {
        return switch (encryptedValue) {
            case "X" -> ROCK;
            case "Y" -> PAPER;
            case "Z" -> SCISSORS;
            default -> throw new IllegalArgumentException("encryptedValue not supported : " + encryptedValue);
        };
    }
}
