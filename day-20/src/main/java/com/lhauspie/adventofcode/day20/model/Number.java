package com.lhauspie.adventofcode.day20.model;

public class Number {
    private long value;
    private long moveValue;

    private Number previousNumber;
    private Number nextNumber;

    Number(long value) {
        this.value = value;
        this.moveValue = value;
        this.nextNumber = this;
        this.previousNumber = this;
    }

    public void insertAfter(Number number) {
        this.previousNumber = number;
        this.nextNumber = number.nextNumber;
        this.nextNumber.previousNumber = this;
        this.previousNumber.nextNumber = this;
    }

    public void unlink() {
        Number myOldPrevious = this.previousNumber;
        Number myOldNext = this.nextNumber;
        this.nextNumber.previousNumber = myOldPrevious;
        this.previousNumber.nextNumber = myOldNext;
        this.previousNumber = null;
        this.nextNumber = null;
    }

    public long getValue() {
        return value;
    }

    public Number getPreviousNumber() {
        return previousNumber;
    }

    public Number getNextNumber() {
        return nextNumber;
    }

    public void applyDecryptionKey(long decryptionKey) {
        this.value = value * decryptionKey;
    }

    public void setMoveValue(long moveValue) {
        this.moveValue = moveValue;
    }

    public long getMoveValue() {
        return moveValue;
    }
}
