package com.lhauspie.adventofcode.day22.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Position, Tile> tiles = new HashMap<>();
    private Tile startTile = null;

    public void addTile(Tile tile) {
        if (startTile == null) {
            startTile = tile;
        }
        tiles.put(tile.getPosition(), tile);
        tile.setNorth(tile);
        tile.setSouth(tile);
        tile.setWest(tile);
        tile.setEast(tile);
        linkToNorthPosition(tile);
        linkToWestPosition(tile);
    }

    private void linkToNorthPosition(Tile tile) {
        Tile northTile = tiles.get(tile.getPosition().up()); // northTile = c
        if (northTile == null) {
            tile.setNorth(tile);
        } else {
            //  a -> b -> c and I add a tile 'd'
            Tile southTileOfNorthTile = northTile.getSouth();  // southTileOfNorthTile = a
            tile.setNorth(northTile);                          // c <- d
            tile.setSouth(southTileOfNorthTile);               //      d -> a
            northTile.setSouth(tile);                          // c -> d
            southTileOfNorthTile.setNorth(tile);               //      d <- a
        }
    }

    private void linkToWestPosition(Tile tile) {
        Tile westTile = tiles.get(tile.getPosition().left()); // westTile = c
        if (westTile == null) {
            tile.setWest(tile);
        } else {
            //  a -> b -> c and I add a tile 'd'
            Tile eastTileOfWestTile = westTile.getEast();   // eastTileOfWestTile = a
            tile.setWest(westTile);                         // c <- d
            tile.setEast(eastTileOfWestTile);               //      d -> a
            westTile.setEast(tile);                         // c -> d
            eastTileOfWestTile.setWest(tile);               //      d <- a
        }
    }

    public Tile getStartTile() {
        return startTile;
    }
}
