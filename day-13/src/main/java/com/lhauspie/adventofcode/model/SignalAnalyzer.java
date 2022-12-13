package com.lhauspie.adventofcode.model;

public class SignalAnalyzer {

    public static boolean pairIsInTheRightOrder(String left, String right) {
        Element leftElement = getNextElement(left);
        Element rightElement = getNextElement(right);

        if (leftElement == null) {
            return true;
        }
        if (rightElement == null) {
            return false;
        }

        if (leftElement.isInteger() && rightElement.isInteger()) {
            return leftElement.getValue() <= rightElement.getValue()
                    && pairIsInTheRightOrder(getSignalTail(left, leftElement), getSignalTail(right, leftElement));
        }
        if (leftElement.isList() && rightElement.isInteger()) {
            return pairIsInTheRightOrder(leftElement.getSignal(), "[" + rightElement.getValue() + "]");
        }
        if (leftElement.isInteger() && rightElement.isList()) {
            return pairIsInTheRightOrder("[" + leftElement.getValue() + "]", rightElement.getSignal());
        }
        if (leftElement.isList() && rightElement.isList()) {
            return pairIsInTheRightOrder(
                    leftElement.getSignal().substring(1, leftElement.getSignal().length() - 1),
                    rightElement.getSignal().substring(1, rightElement.getSignal().length() - 1)
            );
        }

        return true;
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
