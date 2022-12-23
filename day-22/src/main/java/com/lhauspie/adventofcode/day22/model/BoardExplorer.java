package com.lhauspie.adventofcode.day22.model;

public class BoardExplorer implements Explorer {
    private Facing facing;
    private Tile currentTile;

    public BoardExplorer() {
        this.facing = Facing.EAST;
    }

    public BoardExplorer(Board board) {
        this();
        this.currentTile = board.getStartTile();
    }

    public Facing getFacing() {
        return facing;
    }

    public void turnCounterclockwise() {
        facing = facing.getCounterclockwiseNextFacing();
    }

    public void turnClockwise() {
        facing = facing.getClockwiseNextFacing();
    }

    public void move(int times) {
        Tile nextTile = facing.getNextTile(currentTile);
        for (int n = 0; nextTile.isEmpty() && n < times; n++) {
            currentTile = nextTile;
            nextTile = facing.getNextTile(currentTile);
        }
    }

    public Tile getCurrentTile() {
        return currentTile;
    }
}
