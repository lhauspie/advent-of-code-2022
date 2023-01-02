package com.lhauspie.adventofcode.day23.model;

import java.util.HashMap;

public class PositionFactory {
    private static final PositionFactory INSTANCE = new PositionFactory();

    public static PositionFactory getInstance() {
        return INSTANCE;
    }

    // Y -> X -> Position
    private HashMap<Long, HashMap<Long, Position>> cache = new HashMap<>();

    public Position create(long x, long y) {
        HashMap<Long, Position> yRow = cache.get(y);
        if (yRow == null) {
            yRow = new HashMap<>();
            cache.put(y, yRow);
        }
        Position position = yRow.get(x);
        if (position == null) {
            position = Position.of(x, y);
            yRow.put(x, position);
        }
        return position;
//        return Position.of(x, y);
    }

    public Position upLeft(Position position) {
        return create(position.getX() - 1, position.getY() - 1);
    }

    public Position up(Position position) {
        return create(position.getX(), position.getY() - 1);
    }

    public Position upRight(Position position) {
        return create(position.getX() + 1, position.getY() - 1);
    }

    public Position right(Position position) {
        return create(position.getX() + 1, position.getY());
    }

    public Position downRight(Position position) {
        return create(position.getX() + 1, position.getY() + 1);
    }

    public Position down(Position position) {
        return create(position.getX(), position.getY() + 1);
    }

    public Position downLeft(Position position) {
        return create(position.getX() - 1, position.getY() + 1);
    }

    public Position left(Position position) {
        return create(position.getX() - 1, position.getY());
    }
}
