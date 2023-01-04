package com.lhauspie.adventofcode.day25.model;

public class SnafuToDecimalConverter {

    public static long convert(String snafu) {
        if (snafu.length() == 1) {
            return parseDigit(snafu.charAt(0));
        }
        return getPlaceValueOfFirstDigit(snafu) * parseDigit(snafu.charAt(0)) + convert(snafu.substring(1));
    }

    private static long getPlaceValueOfFirstDigit(String snafu) {
        return (long) Math.pow(5, snafu.length() - 1);
    }

    private static int parseDigit(char c) {
        return switch (c) {
            case '=' -> -2;
            case '-' -> -1;
            default -> c - '0';
        };
    }
}
