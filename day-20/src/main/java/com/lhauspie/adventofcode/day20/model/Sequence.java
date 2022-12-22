package com.lhauspie.adventofcode.day20.model;

import java.util.LinkedList;
import java.util.List;

public class Sequence {
    private List<Number> numbersInTheOrderTheyWasAdded = new LinkedList<>();
    private Number lastAddedNumber;
    private Number zero;
    int sequenceLength = 0;

    public void add(long value) {
        Number numberToBeInserted = new Number(value);
        numbersInTheOrderTheyWasAdded.add(numberToBeInserted);
        if (lastAddedNumber != null) {
            numberToBeInserted.insertAfter(lastAddedNumber);
        }
        lastAddedNumber = numberToBeInserted;
        if (value == 0) {
            zero = numberToBeInserted;
        }
        sequenceLength++;
    }

    public Number decryptAndGetZeroNumber() {
        for (Number number : numbersInTheOrderTheyWasAdded) {
            if (number.getMoveValue() > 0) {
                this.moveForward(number);
            }
            if (number.getMoveValue() < 0) {
                this.moveBackward(number);
            }
        }
        return zero;
    }

    public Number decryptAndGetZeroNumber(long decryptionKey) {
        applyDecryptionKey(decryptionKey);
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            decryptAndGetZeroNumber();
        }
        return zero;
    }

    private void applyDecryptionKey(long decryptionKey) {
        numbersInTheOrderTheyWasAdded.forEach(number -> {
            number.applyDecryptionKey(decryptionKey);
            // little optimisation to avoid looping 811589153 times
            // - 1 because we're looping without the element to be moved
            number.setMoveValue((number.getMoveValue() * decryptionKey) % (sequenceLength - 1));
        });
    }

    private void moveForward(Number numberToBeMoved) {
        Number numberAfterWhichWeWantToInsertTheNumberToBeMoved = numberToBeMoved.getNextNumber();
        numberToBeMoved.unlink();
        for (int i = 1; i < numberToBeMoved.getMoveValue(); i++) {
            numberAfterWhichWeWantToInsertTheNumberToBeMoved = numberAfterWhichWeWantToInsertTheNumberToBeMoved.getNextNumber();
        }
        numberToBeMoved.insertAfter(numberAfterWhichWeWantToInsertTheNumberToBeMoved);
    }

    private void moveBackward(Number numberToBeMoved) {
        Number numberAfterWhichWeWantToInsertTheNumberToBeMoved = numberToBeMoved.getPreviousNumber();
        numberToBeMoved.unlink();
        for (int i = 0; i > numberToBeMoved.getMoveValue(); i--) {
            numberAfterWhichWeWantToInsertTheNumberToBeMoved = numberAfterWhichWeWantToInsertTheNumberToBeMoved.getPreviousNumber();
        }
        numberToBeMoved.insertAfter(numberAfterWhichWeWantToInsertTheNumberToBeMoved);
    }
}
