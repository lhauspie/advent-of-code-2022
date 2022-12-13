package com.lhauspie.adventofcode.model;

public class SignalAnalyzer {

    private static final int LEFT_SMALLER_THAN_RIGHT = -1;
    private static final int LEFT_EQUALS_RIGHT = 0;
    private static final int LEFT_HIGHER_THAN_RIGHT = 1;


    public static boolean pairIsInTheRightOrder(String left, String right) {
        return compareSignals(left, right) != LEFT_HIGHER_THAN_RIGHT;
    }

    public static int compareSignals(String left, String right) {
        Element leftElement = getNextElement(left);
        Element rightElement = getNextElement(right);

        if (leftElement == null && rightElement == null) {
            return LEFT_EQUALS_RIGHT;
        } else if (leftElement == null) {
//            System.out.println("- Left side ran out of items, so inputs are in the right order");
            return LEFT_SMALLER_THAN_RIGHT;
        } else if (rightElement == null) {
//            System.out.println("- Right side ran out of items, so inputs are *not* in the right order");
            return LEFT_HIGHER_THAN_RIGHT;
        }

        if (leftElement.isList() && rightElement.isList()) {
//            System.out.println("- Compare " + leftElement.getSignal() + " vs " + rightElement.getSignal());
            int signalComparison = compareSignals(
                    leftElement.getSignal().substring(1, leftElement.getSignal().length() - 1),
                    rightElement.getSignal().substring(1, rightElement.getSignal().length() - 1));
            if (signalComparison == LEFT_EQUALS_RIGHT) {
                return compareSignals(getSignalTail(left, leftElement), getSignalTail(right, rightElement));
            }
            return signalComparison;
        }

        if (leftElement.isInteger() && rightElement.isInteger()) {
//            System.out.println("- Compare " + leftElement.getValue() + " vs " + rightElement.getValue());
            if (leftElement.getValue() < rightElement.getValue()) {
//                System.out.println("- Left side is smaller, so inputs are in the right order");
                return LEFT_SMALLER_THAN_RIGHT;
            } else if (leftElement.getValue() == rightElement.getValue()) {
                return compareSignals(getSignalTail(left, leftElement), getSignalTail(right, rightElement));
            } else if (leftElement.getValue() > rightElement.getValue()) {
//                System.out.println("- Right side is smaller, so inputs are not in the right order");
                return LEFT_HIGHER_THAN_RIGHT;
            }
        }

        if (leftElement.isList() && rightElement.isInteger()) {
//            System.out.println("- Mixed types; convert right to [" + rightElement.getValue() + "] and retry comparison");
            return compareSignals(leftElement.getSignal(), "[" + rightElement.getValue() + "]");
        }
        if (leftElement.isInteger() && rightElement.isList()) {
//            System.out.println("- Mixed types; convert left to [" + leftElement.getValue() + "] and retry comparison");
            return compareSignals("[" + leftElement.getValue() + "]", rightElement.getSignal());
        }

        return LEFT_EQUALS_RIGHT;
    }


    private static String getSignalTail(String signal, Element element) {
        String tail = signal.substring(element.getSignal().length());
        if (tail.length() > 0 && tail.charAt(0) == ',') {
            tail = tail.substring(1);
        }
        return tail;
    }

    private static Element getNextElement(String signal) {
        if (signal.isEmpty()) {
            return null;
        }
        if (signal.startsWith("[")) {
            return getNextList(signal);
        } else {
            return getNextInteger(signal);
        }
    }

    private static Element getNextList(String signal) {
        char[] signalChars = signal.toCharArray();
        if (signalChars[0] != '[') {
            // We ask to get the Next List so we know the first char is '['
            throw new RuntimeException("getNextList asked on signal that is not a List");
        }
        int depth = 1;
        int signalCharsIndex = 1;
        // Where is the corresponding ']' ?
        while (depth != 0) {
            if (signalChars[signalCharsIndex] == '[') {
                depth++;
            }
            if (signalChars[signalCharsIndex] == ']') {
                depth--;
            }
            signalCharsIndex++;
        }

        return Element.ofList(signal.substring(0, signalCharsIndex));
    }

    private static Element getNextInteger(String signal) {
        char[] signalChars = signal.toCharArray();
        int signalCharsIndex = 0;

        // Where is the ',' to find the integer value?
        while (signalCharsIndex < signalChars.length
                && signalChars[signalCharsIndex] != ',') {
            signalCharsIndex++;
        }
        return Element.ofInteger(signal.substring(0, signalCharsIndex));
    }
}
