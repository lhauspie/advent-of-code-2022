package com.lhauspie.adventofcode.day25.model;

public class DecimalToSnafuConverter {

    public static String convert(long decimal) {
        return convert(getSnafuLengthCorrespondingToDecimal(decimal), decimal);
    }

    private static int getSnafuLengthCorrespondingToDecimal(long decimal) {
        long placeValue = 1; // 1, 5, 25, 125, 625, ...
        int length = 0;
        while (!(-placeValue/2 <= decimal && decimal <= placeValue/2)) {
            length++;
            placeValue *= 5;
        }
        return length;
    }

    private static String convert(int length, long decimal) {
        if (length == 1) {
            return "" + toDigit(decimal);
        } else {
            long placeValue = pow(5, length - 1); // 1, 5, 25, 125, 625, ...
            if (decimal >= (placeValue / 2 + 1) + placeValue) {
                return "2" + convert(length - 1, decimal - (placeValue * 2));
            }
            if (decimal >= (placeValue / 2 + 1)) {
                return "1" + convert(length - 1, decimal - (placeValue * 1));
            }
            if (decimal <= -(placeValue / 2 + 1) - placeValue) {
                return "=" + convert(length - 1, decimal - (placeValue * -2));
            }
            if (decimal <= -(placeValue / 2 + 1)) {
                return "-" + convert(length - 1, decimal - (placeValue * -1));
            }
            return "0" + convert(length - 1, decimal);
        }
    }

    private static char toDigit(long i) {
        if (i == -2) {
            return '=';
        }
        if (i == -1) {
            return '-';
        }
        if (i == 0) {
            return '0';
        }
        if (i == 1) {
            return '1';
        }
        if (i == 2) {
            return '2';
        }
        return ' ';
    }

    private static long pow(long base, long exponent) {
        return (long) Math.pow(base, exponent);
    }
}
