package com.lhauspie.adventofcode.day22.model;

public class Cube extends Board {
    private int size;

    public Cube(int size) {
        this.size = size;
    }

    public void consolidate() {
        for (Tile tile : tiles.values()) {
            linkTilesToBeAbleMovingFromFaceOneToNorth(tile);
            linkTilesToBeAbleMovingFromFaceOneToWest(tile);
            linkTilesToBeAbleMovingFromFaceTwoToNorth(tile);
            linkTilesToBeAbleMovingFromFaceTwoToEast(tile);
            linkTilesToBeAbleMovingFromFaceTwoToSouth(tile);
            linkTilesToBeAbleMovingFromFaceFourToNorth(tile);
            linkTilesToBeAbleMovingFromFaceFiveToSouth(tile);
        }
    }

    private void linkTilesToBeAbleMovingFromFaceOneToNorth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 1 TO NORTH LEAD TO FACE 6
        // GOING FROM FACE 6 TO WEST LEAD TO FACE 1
        if (size < tilePosition.getX() && tilePosition.getX() <= size * 2 && tilePosition.getY() == 1) {
            int newX = 1;
            int newY = 2 * size + tilePosition.getX();
            Position northPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setNorth(tiles.get(northPosition));
            tiles.get(northPosition).setWest(tile);
        }
    }

    private void linkTilesToBeAbleMovingFromFaceOneToWest(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 1 TO WEST LEAD TO FACE 4
        // GOING FROM FACE 4 TO WEST LEAD TO FACE 1
        if (tilePosition.getX() == size + 1 && 0 < tilePosition.getY() && tilePosition.getY() <= size) {
            int newX = tilePosition.getX() - size;
            int newY = 3 * size - (tilePosition.getY() - 1);
            Position westPosition = Position.of(newX,newY);
            // Both direction in one shot
            tile.setWest(tiles.get(westPosition));
            tiles.get(westPosition).setWest(tile);
        }
    }

    private void linkTilesToBeAbleMovingFromFaceTwoToEast(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 2 TO EAST LEAD TO FACE 5
        // GOING FROM FACE 5 TO EAST LEAD TO FACE 2
        if (tilePosition.getX() == size * 3
                && 0 < tilePosition.getY() && tilePosition.getY() <= size) {
            // simulated inputs
            // SIZE = 1       |   SIZE = 2             |   SIZE = 3                    |   SIZE = 4
            //                |                        |                               |                111
            //    123         |      123456            |       123456789               |       123456789012
            // 1   .A    12   |   1    ...A     1122   |    1     .....A      111222   |    1      .......A      11112222
            // 2   .     3    |   2    ...B     1122   |    2     .....B      111222   |    2      .......B      11112222
            // 3  .A    45    |   3    ..       33     |    3     .....C      111222   |    3      .......C      11112222
            // 4  .     6     |   4    ..       33     |    4     ...         333      |    4      .......D      11112222
            //                |   5  ...B     4455     |    5     ...         333      |    5      ....          3333
            //                |   6  ...A     4455     |    6     ...         333      |    6      ....          3333
            //                |   7  ..       66       |    7  .....C      444555      |    7      ....          3333
            //                |   8  ..       66       |    8  .....B      444555      |    8      ....          3333
            //                |                        |    9  .....A      444555      |    9  .......D      44445555
            //                |                        |   10  ...         666         |   10  .......C      44445555
            //                |                        |   11  ...         666         |   11  .......B      44445555
            //                |                        |   12  ...         666         |   12  .......A      44445555
            //                |                        |                               |   13  ....          6666
            //                |                        |                               |   14  ....          6666
            //                |                        |                               |   15  ....          6666
            //                |                        |                               |   16  ....          6666
            int newX = tilePosition.getX() - size;
            int newY = 3 * size - (tilePosition.getY() - 1);
            Position eastPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setEast(tiles.get(eastPosition));
            tiles.get(eastPosition).setEast(tile);
        }
    }

    private void linkTilesToBeAbleMovingFromFaceTwoToSouth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 2 TO SOUTH LEAD TO FACE 3
        // GOING FROM FACE 3 TO EAST LEAD TO FACE 2
        if (2 * size < tilePosition.getX() && tilePosition.getX() <= 3 * size && tilePosition.getY() == size) {
            int newX = size * 2;
            int newY = tilePosition.getX() - size;
            Position southPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setSouth(tiles.get(southPosition));
            tiles.get(southPosition).setEast(tile);
        }
    }

    private void linkTilesToBeAbleMovingFromFaceTwoToNorth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 2 TO NORTH LEAD TO FACE 6
        // GOING FROM FACE 6 TO SOUTH LEAD TO FACE 2
        if (2 * size < tilePosition.getX() && tilePosition.getX() <= 3 * size && tilePosition.getY() == 1) {
            int newX = tilePosition.getX() - 2 * size;
            int newY = 4 * size;
            Position northPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setNorth(tiles.get(northPosition));
            tiles.get(northPosition).setSouth(tile);
        }
    }

    private void linkTilesToBeAbleMovingFromFaceFourToNorth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 4 TO NORTH LEAD TO FACE 3
        // GOING FROM FACE 3 TO WEST LEAD TO FACE 4
        if (0 < tilePosition.getX() && tilePosition.getX() <= size
                && tilePosition.getY() == size * 2 + 1) {
            int newX = size + 1;
            int newY = tilePosition.getX() + size;
            Position northPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setNorth(tiles.get(northPosition));
            tiles.get(northPosition).setWest(tile);
        }
    }

    private void linkTilesToBeAbleMovingFromFaceFiveToSouth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 5 TO SOUTH LEAD TO FACE 6
        // GOING FROM FACE 6 TO EAST LEAD TO FACE 5
        if (size < tilePosition.getX() && tilePosition.getX() <= size * 2
                && tilePosition.getY() == size * 3) {
            int southX = tilePosition.getX() - (tilePosition.getX() - size);
            int southY = tilePosition.getY() + (tilePosition.getX() - size);
            Position southPosition = Position.of(southX, southY);
            // Both direction in one shot
            tile.setSouth(tiles.get(southPosition));
            tiles.get(southPosition).setEast(tile);
        }
    }

    public Tile getStartTile() {
        return startTile;
    }

    public Facing calculateNewFacingAfterLeavingTileMovingToEast(Tile previousTile, Facing facing) {
        if (previousTile.getPosition().getX() == size * 2 && size < previousTile.getPosition().getY() && previousTile.getPosition().getY() <= size * 2) {
            return facing.getCounterclockwiseNextFacing();
        }
        if (previousTile.getPosition().getX() == size && size * 3 < previousTile.getPosition().getY() && previousTile.getPosition().getY() <= size * 4) {
            return facing.getCounterclockwiseNextFacing();
        }
        if (previousTile.getPosition().getX() == size * 3 && 0 < previousTile.getPosition().getY() && previousTile.getPosition().getY() <= size) {
            return facing.getClockwiseNextFacing().getClockwiseNextFacing();
        }
        if (previousTile.getPosition().getX() == size * 2 && size * 2 < previousTile.getPosition().getY() && previousTile.getPosition().getY() <= size * 3) {
            return facing.getClockwiseNextFacing().getClockwiseNextFacing();
        }
        return facing;
    }

    public Facing calculateNewFacingAfterLeavingTileMovingToWest(Tile previousTile, Facing facing) {
        if (previousTile.getPosition().getX() == size +1 && size < previousTile.getPosition().getY() && previousTile.getPosition().getY() <= size * 2) {
            return facing.getCounterclockwiseNextFacing();
        }
        if (previousTile.getPosition().getX() == 1 && size * 3 < previousTile.getPosition().getY() && previousTile.getPosition().getY() <= size * 4) {
            return facing.getCounterclockwiseNextFacing();
        }
        if (previousTile.getPosition().getX() == size + 1 && 0 < previousTile.getPosition().getY() && previousTile.getPosition().getY() <= size) {
            return facing.getClockwiseNextFacing().getClockwiseNextFacing();
        }
        if (previousTile.getPosition().getX() == 1 && size * 2 < previousTile.getPosition().getY() && previousTile.getPosition().getY() <= size * 3) {
            return facing.getClockwiseNextFacing().getClockwiseNextFacing();
        }
        return facing;
    }

    public Facing calculateNewFacingAfterLeavingTileMovingToSouth(Tile previousTile, Facing facing) {
        if (size * 2 < previousTile.getPosition().getX() && previousTile.getPosition().getX() <= size * 3 && previousTile.getPosition().getY() == size) {
            return facing.getClockwiseNextFacing();
        }
        if (size < previousTile.getPosition().getX() && previousTile.getPosition().getX() <= size * 2 && previousTile.getPosition().getY() == size * 3 ) {
            return facing.getClockwiseNextFacing();
        }
        return facing;
    }

    public Facing calculateNewFacingAfterLeavingTileMovingToNorth(Tile previousTile, Facing facing) {
        if (0 < previousTile.getPosition().getX() && previousTile.getPosition().getX() <= size && previousTile.getPosition().getY() == size * 2 + 1) {
            return facing.getClockwiseNextFacing();
        }
        if (size < previousTile.getPosition().getX() && previousTile.getPosition().getX() <= size * 2 && previousTile.getPosition().getY() == 1 ) {
            return facing.getClockwiseNextFacing();
        }
        return facing;
    }

    public Facing calculateNewFacingAfterLeavingTile(Tile previousTile, Facing facing) {
        return switch (facing) {
            case EAST  -> calculateNewFacingAfterLeavingTileMovingToEast(previousTile, facing);
            case WEST  -> calculateNewFacingAfterLeavingTileMovingToWest(previousTile, facing);
            case SOUTH -> calculateNewFacingAfterLeavingTileMovingToSouth(previousTile, facing);
            case NORTH -> calculateNewFacingAfterLeavingTileMovingToNorth(previousTile, facing);
        };
    }
}
