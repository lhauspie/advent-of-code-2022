package com.lhauspie.adventofcode.day13.model;

public class SignalComparator {

    private static final int LEFT_SMALLER_THAN_RIGHT = -1;
    private static final int LEFT_EQUALS_RIGHT = 0;
    private static final int LEFT_HIGHER_THAN_RIGHT = 1;

    public static boolean pairIsInTheRightOrder(String left, String right) {
        return compareSignals(left, right) != LEFT_HIGHER_THAN_RIGHT;
    }

    public static int compareSignals(String left, String right) {
        Element leftElement = getNextElement(left);
        Element rightElement = getNextElement(right);

        if (signalsRunOutAtSameTime(leftElement, rightElement)) {
            return LEFT_EQUALS_RIGHT;
        } else if (signalRunsOut(leftElement)) {
            return LEFT_SMALLER_THAN_RIGHT;
        } else if (signalRunsOut(rightElement)) {
            return LEFT_HIGHER_THAN_RIGHT;
        }

        return compareElementsAndTheRestOfTheSignalsIfElementsAreEqual(
                leftElement,
                rightElement,
                getSignalTail(left, leftElement),
                getSignalTail(right, rightElement)
        );
    }

    private static int compareElementsAndTheRestOfTheSignalsIfElementsAreEqual(Element leftElement, Element rightElement, String leftSignalTail, String rightSignalTail) {
        if (leftElement.isList() && rightElement.isList()) {
            return compareElementListsAndTheRestOfTheSignalsIfListsAreEqual(leftElement, rightElement, leftSignalTail, rightSignalTail);
        }
        if (leftElement.isInteger() && rightElement.isInteger()) {
            return compareElementIntegersAndTheRestOfTheSignalsIfIntegersAreEqual(leftElement, rightElement, leftSignalTail, rightSignalTail);
        }
        if (leftElement.isList() && rightElement.isInteger()) {
            return compareSignals(leftElement.getSignal(), "[" + rightElement.getValue() + "]");
        }
        if (leftElement.isInteger() && rightElement.isList()) {
            return compareSignals("[" + leftElement.getValue() + "]", rightElement.getSignal());
        }

        throw new RuntimeException("leftElement and rightElement has another type from Integer or List. This should never arrive.");
    }

    private static int compareElementIntegersAndTheRestOfTheSignalsIfIntegersAreEqual(Element leftElement, Element rightElement, String leftSignalTail, String rightSignalTail) {
        if (leftElement.getValue() < rightElement.getValue()) {
            return LEFT_SMALLER_THAN_RIGHT;
        } else if (leftElement.getValue() > rightElement.getValue()) {
            return LEFT_HIGHER_THAN_RIGHT;
        } else if (leftElement.getValue() == rightElement.getValue()) {
            return compareSignals(leftSignalTail, rightSignalTail);
        }
        throw new RuntimeException("left value is nor higher, equal, smaller than right value. This should never arrive.");
    }

    private static int compareElementListsAndTheRestOfTheSignalsIfListsAreEqual(Element leftElement, Element rightElement, String leftSignalTail, String rightSignalTail) {
        int signalComparison = compareSignals(
                leftElement.getSignal().substring(1, leftElement.getSignal().length() - 1),
                rightElement.getSignal().substring(1, rightElement.getSignal().length() - 1));
        if (signalComparison == LEFT_EQUALS_RIGHT) {
            return compareSignals(leftSignalTail, rightSignalTail);
        }
        return signalComparison;
    }

    private static boolean signalRunsOut(Element leftElement) {
        return leftElement == null;
    }

    private static boolean signalsRunOutAtSameTime(Element leftElement, Element rightElement) {
        return signalRunsOut(leftElement) && signalRunsOut(rightElement);
    }

    private static String getSignalTail(String signal, Element element) {
        String signalTail = signal.substring(element.getSignal().length());
        return removeFirstCharIfItsComma(signalTail);
    }

    private static String removeFirstCharIfItsComma(String signalTail) {
        if (!signalTail.isEmpty() && startWithComma(signalTail)) {
            signalTail = signalTail.substring(1);
        }
        return signalTail;
    }

    private static boolean startWithComma(String signalTail) {
        return signalTail.charAt(0) == ',';
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
        if (signal.charAt(0) != '[') {
            throw new RuntimeException("getNextList asked on signal that is not a List");
        }
        return Element.ofList(getNextListAsString(signal));
    }

    private static Element getNextInteger(String signal) {
        return Element.ofInteger(getNextIntegerAsString(signal));
    }

    private static String getNextListAsString(String signal) {
        int endIndexOfNextList = getEndIndexOfNextList(signal.toCharArray());
        return signal.substring(0, endIndexOfNextList);
    }

    private static String getNextIntegerAsString(String signal) {
        int endIndexOfNextInteger = getEndIndexOfNextInteger(signal.toCharArray());
        return signal.substring(0, endIndexOfNextInteger);
    }

    private static int getEndIndexOfNextList(char[] signalChars) {
        int depth = 1;
        int signalCharsIndex = 1;
        while (depth != 0) {
            if (signalChars[signalCharsIndex] == '[') {
                depth++;
            }
            if (signalChars[signalCharsIndex] == ']') {
                depth--;
            }
            signalCharsIndex++;
        }
        return signalCharsIndex;
    }

    private static int getEndIndexOfNextInteger(char[] signalChars) {
        int signalCharsIndex = 0;
        while (endOfIntegerNotFound(signalChars, signalCharsIndex)) {
            signalCharsIndex++;
        }
        return signalCharsIndex;
    }

    private static boolean endOfIntegerNotFound(char[] signalChars, int signalCharsIndex) {
        return signalCharsIndex < signalChars.length && signalChars[signalCharsIndex] != ',';
    }
}
