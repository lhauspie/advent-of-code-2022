package com.lhauspie.adventofcode.day22.model;

public interface Explorer {
    void turnCounterclockwise();
    void turnClockwise();
    void move(int times);
    Tile getCurrentTile();
    Facing getFacing();
}
