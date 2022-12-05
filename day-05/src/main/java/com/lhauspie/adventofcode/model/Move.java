package com.lhauspie.adventofcode.model;

public class Move {

    private Quantity quantity;
    private Position source;
    private Position target;

    public Move(Quantity quantity, Position source, Position target) {
        this.quantity = quantity;
        this.source = source;
        this.target = target;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Position getSource() {
        return source;
    }

    public Position getTarget() {
        return target;
    }
}
