package com.lhauspie.adventofcode.day22.model;

public class CubeExplorer implements Explorer {
    private Facing facing;
    private Cube cube;
    private Tile currentTile;

    public CubeExplorer(Cube cube) {
        this.facing = Facing.EAST;
        this.cube = cube;
        this.currentTile = cube.getStartTile();
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
            facing = cube.calculateNewFacingAfterLeavingTile(currentTile, facing);
            currentTile = nextTile;
            nextTile = facing.getNextTile(currentTile);
        }
    }

    public Tile getCurrentTile() {
        return currentTile;
    }
}
