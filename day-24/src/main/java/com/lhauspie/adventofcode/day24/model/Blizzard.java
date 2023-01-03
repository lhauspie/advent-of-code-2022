package com.lhauspie.adventofcode.day24.model;

import static com.lhauspie.adventofcode.day24.model.Direction.*;

public class Blizzard {
    private Position position;
    private final Direction direction;

    public Blizzard(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position moveAndGetNewPosition(Position minPosition, Position maxPosition) {
        position = getNextPosition(minPosition, maxPosition);
        return position;
    }

    private Position getNextPosition(Position minPosition, Position maxPosition) {
        if (NORTH.equals(direction) && position.getY() == minPosition.getY()) {
            return Position.of(position.getX(), maxPosition.getY());
        } else if (SOUTH.equals(direction) && position.getY() == maxPosition.getY()) {
            return Position.of(position.getX(), minPosition.getY());
        } else if (WEST.equals(direction) && position.getX() == minPosition.getX()) {
            return Position.of(maxPosition.getX(), position.getY());
        } else if (EAST.equals(direction) && position.getX() == maxPosition.getX()) {
            return Position.of(minPosition.getX(), position.getY());
        } else {
            return position.add(direction.getMove());
        }
    }

    public Position getPosition() {
        return position;
    }
}
