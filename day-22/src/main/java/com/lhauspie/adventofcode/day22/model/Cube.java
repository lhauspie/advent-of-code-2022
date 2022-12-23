package com.lhauspie.adventofcode.day22.model;

import java.util.HashMap;
import java.util.Map;

public class Cube {
    private Map<Position, Tile> tiles = new HashMap<>();
    private int size;
    private Tile startTile = null;

    public Cube(int size) {
        this.size = size;
    }

    public void addTile(Tile tile) {
        if (startTile == null) {
            startTile = tile;
        }
        tiles.put(tile.getPosition(), tile);
        linkToNorthPosition(tile);
        linkToWestPosition(tile);
    }

    private void linkToNorthPosition(Tile tile) {
        Tile northTile = tiles.get(tile.getPosition().up()); // northTile = c
        if (northTile != null) {
            //  a -> b -> c and I add a tile 'd'
            Tile southTileOfNorthTile = northTile.getSouth();  // southTileOfNorthTile = a
            tile.setNorth(northTile);                          // c <- d
            tile.setSouth(southTileOfNorthTile);               //      d -> a
            northTile.setSouth(tile);                          // c -> d
            if (southTileOfNorthTile != null) {
                southTileOfNorthTile.setNorth(tile);               //      d <- a
            }
        }
    }

    private void linkToWestPosition(Tile tile) {
        Tile westTile = tiles.get(tile.getPosition().left()); // westTile = c
        if (westTile != null) {
            //  a -> b -> c and I add a tile 'd'
            Tile eastTileOfWestTile = westTile.getEast();   // eastTileOfWestTile = a
            tile.setWest(westTile);                         // c <- d
            tile.setEast(eastTileOfWestTile);               //      d -> a
            westTile.setEast(tile);                         // c -> d
            if (eastTileOfWestTile != null) {
                eastTileOfWestTile.setWest(tile);               //      d <- a
            }
        }
    }

    public void consolidate() {
        for (Tile tile : tiles.values()) {
            Position tilePosition = tile.getPosition();


            if (tilePosition.getX()/size == 3 && tilePosition.getY()/size == 1) {
                // simulated input
                //  .x    12
                //  .     3
                // ..    45
                // .     6
                // West should already been set
                Tile westTile = tiles.get(Position.of(2, 1));
                Tile eastTile = tiles.get(Position.of(2, 3));
                Tile southTile = tiles.get(Position.of(2, 2));
                Tile northTile = tiles.get(Position.of(1, 4));

//                tile.setWest(westTile);
                tile.setEast(eastTile);
                tile.setSouth(southTile);
                tile.setNorth(northTile);
            }
            if (tilePosition.getX()/size == 2 && tilePosition.getY()/size == 2) {
                // simulated input
                //  ..    12
                //  x     3
                // ..    45
                // .     6
                // North should already been set
                // South should already been set
                Tile westTile = tiles.get(Position.of(1, 3));
                Tile eastTile = tiles.get(Position.of(3, 1));
                Tile southTile = tiles.get(Position.of(2, 3));
                Tile northTile = tiles.get(Position.of(2, 1));

                tile.setWest(westTile);
                tile.setEast(eastTile);
//                tile.setSouth(southTile);
//                tile.setNorth(northTile);
            }


            if (tilePosition.getX()/size == 1 && tilePosition.getY()/size == 3) {
                // simulated input
                //  ..    12
                //  .     3
                // x.    45
                // .     6
                // South should already been set
                // East should already been set
                Tile westTile = tiles.get(Position.of(2, 1));
                Tile eastTile = tiles.get(Position.of(2, 3));
                Tile southTile = tiles.get(Position.of(1, 4));
                Tile northTile = tiles.get(Position.of(2, 2));

                tile.setWest(westTile);
//                tile.setEast(eastTile);
//                tile.setSouth(southTile);
                tile.setNorth(northTile);
            }

            if (tilePosition.getX()/size == 1 && tilePosition.getY()/size == 4) {
                // simulated input
                //  ..    12
                //  .     3
                // ..    45
                // x     6
                // North should already been set
                Tile westTile = tiles.get(Position.of(2, 1));
                Tile eastTile = tiles.get(Position.of(2, 3));
                Tile southTile = tiles.get(Position.of(3, 1));
                Tile northTile = tiles.get(Position.of(1, 3));

                tile.setWest(westTile);
                tile.setEast(eastTile);
                tile.setSouth(southTile);
//                tile.setNorth(northTile);
            }



            // simulated input
            // SIZE = 1       |   SIZE = 2             |   SIZE = 3                    |   SIZE = 4
            //                |                        |                               |                111
            //    123         |      123456            |       123456789               |       123456789012
            // 1   ..    12   |   1    ....     1122   |    1     ......      111222   |    1      xxxxxxxx      11112222
            // 2   .     3    |   2    ....     1122   |    2     ......      111222   |    2      x......x      11112222
            // 3  ..    45    |   3    ..       33     |    3     ......      111222   |    3      x......x      11112222
            // 4  .     6     |   4    ..       33     |    4     ...         333      |    4      x...xxxx      11112222
            //                |   5  ....     4455     |    5     ...         333      |    5      x..x          3333
            //                |   6  ....     4455     |    6     ...         333      |    6      x..x          3333
            //                |   7  ..       66       |    7  ......      444555      |    7      x..x          3333
            //                |   8  ..       66       |    8  ......      444555      |    8      x..x          3333
            //                |                        |    9  ......      444555      |    9  xxxx...x      44445555
            //                |                        |   10  ...         666         |   10  x......x      44445555
            //                |                        |   11  ...         666         |   11  x......x      44445555
            //                |                        |   12  ...         666         |   12  x...xxxx      44445555
            //                |                        |                               |   13  x..x          6666
            //                |                        |                               |   14  x..x          6666
            //                |                        |                               |   15  x..x          6666
            //                |                        |                               |   16  xxxx          6666
            manageMovingFromFaceOneToNorth(tile);
            manageMovingFromFaceOneToWest(tile);
            manageMovingFromFaceTwoToNorth(tile);
            manageMovingFromFaceTwoToEast(tile);
            manageMovingFromFaceTwoToSouth(tile);
            manageMovingFromFaceFourToNorth(tile);
            manageMovingFromFaceFiveToSouth(tile);
        }
    }

    private void manageMovingFromFaceOneToNorth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 1 TO NORTH LEAD TO FACE 6
        // GOING FROM FACE 6 TO WEST LEAD TO FACE 1
        if (size < tilePosition.getX() && tilePosition.getX() <= size * 2
                && tilePosition.getY() == 1) {
            // simulated inputs
            // SIZE = 1       |   SIZE = 2             |   SIZE = 3                    |   SIZE = 4
            //                |                        |                               |                111
            //    123         |      123456            |       123456789               |       123456789012
            // 1   A.    12   |   1    AB..     1122   |    1     ABC...      111222   |    1      ABCD....      11112222
            // 2   .     3    |   2    ....     1122   |    2     ......      111222   |    2      ........      11112222
            // 3  A.    45    |   3    ..       33     |    3     ......      111222   |    3      ........      11112222
            // 4  .     6     |   4    ..       33     |    4     ...         333      |    4      ........      11112222
            //                |   5  B...     4455     |    5     ...         333      |    5      ....          3333
            //                |   6  A...     4455     |    6     ...         333      |    6      ....          3333
            //                |   7  ..       66       |    7  ......      444555      |    7      ....          3333
            //                |   8  ..       66       |    8  ......      444555      |    8      ....          3333
            //                |                        |    9  ......      444555      |    9  ........      44445555
            //                |                        |   10  A..         666         |   10  ........      44445555
            //                |                        |   11  B..         666         |   11  ........      44445555
            //                |                        |   12  C..         666         |   12  ........      44445555
            //                |                        |                               |   13  A...          6666
            //                |                        |                               |   14  B...          6666
            //                |                        |                               |   15  C...          6666
            //                |                        |                               |   16  D...          6666
            int newX = 1;
            int newY = 2 * size + tilePosition.getX();
            Position northPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setNorth(tiles.get(northPosition));
            tiles.get(northPosition).setWest(tile);
        }
    }

    private void manageMovingFromFaceOneToWest(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 1 TO WEST LEAD TO FACE 4
        // GOING FROM FACE 4 TO WEST LEAD TO FACE 1
        if (tilePosition.getX() == size + 1
                && 0 < tilePosition.getY() && tilePosition.getY() <= size) {
            // simulated inputs
            // SIZE = 1       |   SIZE = 2             |   SIZE = 3                    |   SIZE = 4
            //                |                        |                               |                111
            //    123         |      123456            |       123456789               |       123456789012
            // 1   A.    12   |   1    A...     1122   |    1     A.....      111222   |    1      A.......      11112222
            // 2   .     3    |   2    B...     1122   |    2     B.....      111222   |    2      B.......      11112222
            // 3  A.    45    |   3    ..       33     |    3     C.....      111222   |    3      C.......      11112222
            // 4  .     6     |   4    ..       33     |    4     ...         333      |    4      D.......      11112222
            //                |   5  B...     4455     |    5     ...         333      |    5      ....          3333
            //                |   6  A...     4455     |    6     ...         333      |    6      ....          3333
            //                |   7  ..       66       |    7  C.....      444555      |    7      ....          3333
            //                |   8  ..       66       |    8  B.....      444555      |    8      ....          3333
            //                |                        |    9  A.....      444555      |    9  D.......      44445555
            //                |                        |   10  ...         666         |   10  C.......      44445555
            //                |                        |   11  ...         666         |   11  B.......      44445555
            //                |                        |   12  ...         666         |   12  A.......      44445555
            //                |                        |                               |   13  ....          6666
            //                |                        |                               |   14  ....          6666
            //                |                        |                               |   15  ....          6666
            //                |                        |                               |   16  ....          6666
            int newX = tilePosition.getX() - size;
            int newY = 3 * size - (tilePosition.getY() - 1);
            Position westPosition = Position.of(newX,newY);
            // Both direction in one shot
            tile.setWest(tiles.get(westPosition));
            tiles.get(westPosition).setWest(tile);
        }
    }

    private void manageMovingFromFaceTwoToEast(Tile tile) {
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

    private void manageMovingFromFaceTwoToSouth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 2 TO SOUTH LEAD TO FACE 3
        // GOING FROM FACE 3 TO EAST LEAD TO FACE 2
        if (2 * size < tilePosition.getX() && tilePosition.getX() <= 3 * size
                && tilePosition.getY() == size - 1) {
            // simulated inputs
            // SIZE = 1       |   SIZE = 2             |   SIZE = 3                    |   SIZE = 4
            //                |                        |                               |                111
            //    123         |      123456            |       123456789               |       123456789012
            // 1   .A    12   |   1    ....     1122   |    1     ......      111222   |    1      ........      11112222
            // 2   A     3    |   2    ..AB     1122   |    2     ......      111222   |    2      ........      11112222
            // 3  ..    45    |   3    .A       33     |    3     ...ABC      111222   |    3      ........      11112222
            // 4  .     6     |   4    .B       33     |    4     ..A         333      |    4      ....ABCD      11112222
            //                |   5  ....     4455     |    5     ..B         333      |    5      ...A          3333
            //                |   6  ....     4455     |    6     ..C         333      |    6      ...B          3333
            //                |   7  ..       66       |    7  ......      444555      |    7      ...C          3333
            //                |   8  AB       66       |    8  ......      444555      |    8      ...D          3333
            //                |                        |    9  ......      444555      |    9  ........      44445555
            //                |                        |   10  ...         666         |   10  ........      44445555
            //                |                        |   11  ...         666         |   11  ........      44445555
            //                |                        |   12  ...         666         |   12  ........      44445555
            //                |                        |                               |   13  ....          6666
            //                |                        |                               |   14  ....          6666
            //                |                        |                               |   15  ....          6666
            //                |                        |                               |   16  ....          6666
            int newX = size * 2;
            int newY = tilePosition.getX() - size;
            Position southPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setNorth(tiles.get(southPosition));
            tiles.get(southPosition).setEast(tile);
        }
    }

    private void manageMovingFromFaceTwoToNorth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 2 TO NORTH LEAD TO FACE 6
        // GOING FROM FACE 6 TO SOUTH LEAD TO FACE 2
        if (2 * size < tilePosition.getX() && tilePosition.getX() <= 3 * size
                && tilePosition.getY() == 1) {
            // simulated inputs
            // SIZE = 1       |   SIZE = 2             |   SIZE = 3                    |   SIZE = 4
            //                |                        |                               |                111
            //    123         |      123456            |       123456789               |       123456789012
            // 1   .A    12   |   1    ..AB     1122   |    1     ...ABC      111222   |    1      ....ABCD      11112222
            // 2   .     3    |   2    ....     1122   |    2     ......      111222   |    2      ........      11112222
            // 3  ..    45    |   3    ..       33     |    3     ......      111222   |    3      ........      11112222
            // 4  A     6     |   4    ..       33     |    4     ...         333      |    4      ........      11112222
            //                |   5  ....     4455     |    5     ...         333      |    5      ....          3333
            //                |   6  ....     4455     |    6     ...         333      |    6      ....          3333
            //                |   7  ..       66       |    7  ......      444555      |    7      ....          3333
            //                |   8  AB       66       |    8  ......      444555      |    8      ....          3333
            //                |                        |    9  ......      444555      |    9  ........      44445555
            //                |                        |   10  ...         666         |   10  ........      44445555
            //                |                        |   11  ...         666         |   11  ........      44445555
            //                |                        |   12  ABC         666         |   12  ........      44445555
            //                |                        |                               |   13  ....          6666
            //                |                        |                               |   14  ....          6666
            //                |                        |                               |   15  ....          6666
            //                |                        |                               |   16  ABCD          6666
            int newX = tilePosition.getX() - 2 * size;
            int newY = 4 * size;
            Position northPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setNorth(tiles.get(northPosition));
            tiles.get(northPosition).setSouth(tile);
        }
    }

    private void manageMovingFromFaceFourToNorth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 4 TO NORTH LEAD TO FACE 3
        // GOING FROM FACE 3 TO WEST LEAD TO FACE 4
        if (0 < tilePosition.getX() && tilePosition.getX() <= size
                && tilePosition.getY() == size * 2 + 1) {
            // simulated inputs
            // SIZE = 1       |   SIZE = 2             |   SIZE = 3                    |   SIZE = 4
            //                |                        |                               |                111
            //    123         |      123456            |       123456789               |       123456789012
            // 1   ..    12   |   1    ....     1122   |    1     ......      111222   |    1      ........      11112222
            // 2   A     3    |   2    ....     1122   |    2     ......      111222   |    2      ........      11112222
            // 3  A.    45    |   3    A.       33     |    3     ......      111222   |    3      ........      11112222
            // 4  .     6     |   4    B.       33     |    4     A..         333      |    4      ........      11112222
            //                |   5  AB..     4455     |    5     B..         333      |    5      A...          3333
            //                |   6  ....     4455     |    6     C..         333      |    6      B...          3333
            //                |   7  ..       66       |    7  ABC...      444555      |    7      C...          3333
            //                |   8  ..       66       |    8  ......      444555      |    8      D...          3333
            //                |                        |    9  ......      444555      |    9  ABCD....      44445555
            //                |                        |   10  ...         666         |   10  ........      44445555
            //                |                        |   11  ...         666         |   11  ........      44445555
            //                |                        |   12  ...         666         |   12  ........      44445555
            //                |                        |                               |   13  ....          6666
            //                |                        |                               |   14  ....          6666
            //                |                        |                               |   15  ....          6666
            //                |                        |                               |   16  ....          6666
            int newX = size + 1;
            int newY = tilePosition.getX() + size;
            Position northPosition = Position.of(newX, newY);
            // Both direction in one shot
            tile.setNorth(tiles.get(northPosition));
            tiles.get(northPosition).setWest(tile);
        }
    }

    private void manageMovingFromFaceFiveToSouth(Tile tile) {
        Position tilePosition = tile.getPosition();
        // GOING FROM FACE 5 TO SOUTH LEAD TO FACE 6
        // GOING FROM FACE 6 TO EAST LEAD TO FACE 5
        if (size < tilePosition.getX() && tilePosition.getX() <= size * 2
                && tilePosition.getY() == size * 3) {
            // simulated input
            //    123456            |    123456789
            // 1    ....     1122   |       ......        111222
            // 2    ....     1122   |       ......        111222
            // 3    ..       33     |       ......        111222
            // 4    ..       33     |       ...           333
            // 5  ....     4455     |       ...           333
            // 6  ..AB     4455     |       ...           333
            // 7  .A       66       |    ......        444555
            // 8  .B       66       |    ......        444555
            //                      |    ...ABC        444555
            //                      |    ..A           666
            //                      |    ..B           666
            //                      |    ..C           666

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
}
