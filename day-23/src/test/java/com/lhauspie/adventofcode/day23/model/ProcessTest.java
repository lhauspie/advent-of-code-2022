package com.lhauspie.adventofcode.day23.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProcessTest {

    @Test
    public void simulateOneRoundWithSmallExample() {
        // Simulated Start Situation
        //   12345
        // 1 .....
        // 2 ..12.
        // 3 ..3..
        // 4 .....
        // 5 ..45.
        // 6 .....
        Elf elf1 = new Elf(Position.of(3, 2));
        Elf elf2 = new Elf(Position.of(4, 2));
        Elf elf3 = new Elf(Position.of(3, 3));
        Elf elf4 = new Elf(Position.of(3, 5));
        Elf elf5 = new Elf(Position.of(4, 5));

        Process process = new Process();
        process.add(elf1);
        process.add(elf2);
        process.add(elf3);
        process.add(elf4);
        process.add(elf5);

        process.simulate(1);

        //   12345         12345
        // 1 .....       1 ..12.
        // 2 ..12.       2 .....
        // 3 ..3..  ==>  3 ..3..
        // 4 .....       4 ...5.
        // 5 ..45.       5 ..4..
        // 6 .....       6 .....

        Assertions.assertEquals(Position.of(3,1), elf1.getPosition());
        Assertions.assertEquals(Position.of(4,1), elf2.getPosition());
        Assertions.assertEquals(Position.of(3,3), elf3.getPosition());
        Assertions.assertEquals(Position.of(3,5), elf4.getPosition());
        Assertions.assertEquals(Position.of(4,4), elf5.getPosition());
    }

    @Test
    public void simulateTwoRoundsWithSmallExample() {
        // Simulated Start Situation
        //   12345
        // 1 .....
        // 2 ..12.
        // 3 ..3..
        // 4 .....
        // 5 ..45.
        // 6 .....
        Elf elf1 = new Elf(Position.of(3, 2));
        Elf elf2 = new Elf(Position.of(4, 2));
        Elf elf3 = new Elf(Position.of(3, 3));
        Elf elf4 = new Elf(Position.of(3, 5));
        Elf elf5 = new Elf(Position.of(4, 5));

        Process process = new Process();
        process.add(elf1);
        process.add(elf2);
        process.add(elf3);
        process.add(elf4);
        process.add(elf5);

        process.simulate(2);

        //   12345         12345         12345
        // 1 .....       1 ..12.       1 .....
        // 2 ..12.       2 .....       2 ..12.
        // 3 ..3..  ==>  3 ..3..  ==>  3 .3...
        // 4 .....       4 ...5.       4 ....5
        // 5 ..45.       5 ..4..       5 .....
        // 6 .....       6 .....       6 ..4..

        Assertions.assertEquals(Position.of(3,2), elf1.getPosition());
        Assertions.assertEquals(Position.of(4,2), elf2.getPosition());
        Assertions.assertEquals(Position.of(2,3), elf3.getPosition());
        Assertions.assertEquals(Position.of(3,6), elf4.getPosition());
        Assertions.assertEquals(Position.of(5,4), elf5.getPosition());
    }

    @Test
    public void simulateThreeRoundsWithSmallExample() {
        // Simulated Start Situation
        //   12345
        // 1 .....
        // 2 ..12.
        // 3 ..3..
        // 4 .....
        // 5 ..45.
        // 6 .....
        Elf elf1 = new Elf(Position.of(3, 2));
        Elf elf2 = new Elf(Position.of(4, 2));
        Elf elf3 = new Elf(Position.of(3, 3));
        Elf elf4 = new Elf(Position.of(3, 5));
        Elf elf5 = new Elf(Position.of(4, 5));

        Process process = new Process();
        process.add(elf1);
        process.add(elf2);
        process.add(elf3);
        process.add(elf4);
        process.add(elf5);

        process.simulate(3);

        //   12345         12345         12345         12345
        // 1 .....       1 ..12.       1 .....       1 ..1..
        // 2 ..12.       2 .....       2 ..12.       2 ....2
        // 3 ..3..  ==>  3 ..3..  ==>  3 .3...  ==>  3 3....
        // 4 .....       4 ...5.       4 ....5       4 ....5
        // 5 ..45.       5 ..4..       5 .....       5 .....
        // 6 .....       6 .....       6 ..4..       6 ..4..

        Assertions.assertEquals(Position.of(3,1), elf1.getPosition());
        Assertions.assertEquals(Position.of(5,2), elf2.getPosition());
        Assertions.assertEquals(Position.of(1,3), elf3.getPosition());
        Assertions.assertEquals(Position.of(3,6), elf4.getPosition());
        Assertions.assertEquals(Position.of(5,4), elf5.getPosition());
    }

    @Test
    public void simulateThreeRoundsWithLargerExample() {
        // Simulated Start Situation
        //             11111
        //    12345678901234
        //  1 ..............
        //  2 ..............
        //  3 .......#......
        //  4 .....###.#....
        //  5 ...#...#.#....
        //  6 ....#...##....
        //  7 ...#.###......
        //  8 ...##.#.##....
        //  9 ....#..#......
        // 10 ..............
        // 11 ..............
        // 12 ..............
        Elf elf1 = new Elf(Position.of(8, 3));
        Elf elf2 = new Elf(Position.of(6, 4));
        Elf elf3 = new Elf(Position.of(7, 4));
        Elf elf4 = new Elf(Position.of(8, 4));
        Elf elf5 = new Elf(Position.of(10, 4));
        Elf elf6 = new Elf(Position.of(4, 5));
        Elf elf7 = new Elf(Position.of(8, 5));
        Elf elf8 = new Elf(Position.of(10, 5));
        Elf elf9 = new Elf(Position.of(5, 6));
        Elf elf10 = new Elf(Position.of(9, 6));
        Elf elf11 = new Elf(Position.of(10, 6));
        Elf elf12 = new Elf(Position.of(4, 7));
        Elf elf13 = new Elf(Position.of(6, 7));
        Elf elf14 = new Elf(Position.of(7, 7));
        Elf elf15 = new Elf(Position.of(8, 7));
        Elf elf16 = new Elf(Position.of(4, 8));
        Elf elf17 = new Elf(Position.of(5, 8));
        Elf elf18 = new Elf(Position.of(7, 8));
        Elf elf19 = new Elf(Position.of(9, 8));
        Elf elf20 = new Elf(Position.of(10, 8));
        Elf elf21 = new Elf(Position.of(5, 9));
        Elf elf22 = new Elf(Position.of(8, 9));

        Process process = new Process();
        process.add(elf1);
        process.add(elf2);
        process.add(elf3);
        process.add(elf4);
        process.add(elf5);
        process.add(elf6);
        process.add(elf7);
        process.add(elf8);
        process.add(elf9);
        process.add(elf10);
        process.add(elf11);
        process.add(elf12);
        process.add(elf13);
        process.add(elf14);
        process.add(elf15);
        process.add(elf16);
        process.add(elf17);
        process.add(elf18);
        process.add(elf19);
        process.add(elf20);
        process.add(elf21);
        process.add(elf22);

        process.simulate(3);

        //             11111                   11111
        //    12345678901234          12345678901234
        //  1 ..............        1 ..............
        //  2 ..............        2 .......#......
        //  3 .......#......        3 .....#....#...
        //  4 .....###.#....        4 ..#..#...#....
        //  5 ...#...#.#....        5 .......#...#..
        //  6 ....#...##....  ==>   6 ...#..#.#.....
        //  7 ...#.###......        7 .#..#.....#...
        //  8 ...##.#.##....        8 .......##.....
        //  9 ....#..#......        9 ..##.#....#...
        // 10 ..............       10 ...#..........
        // 11 ..............       11 .......#......
        // 12 ..............       12 ..............
        //      INITIAL                  ROUND 3

        Assertions.assertEquals(Position.of(8,2), elf1.getPosition());
        Assertions.assertEquals(Position.of(6,3), elf2.getPosition());
        Assertions.assertEquals(Position.of(6,4), elf3.getPosition());
        Assertions.assertEquals(Position.of(10,4), elf4.getPosition());
        Assertions.assertEquals(Position.of(11,3), elf5.getPosition());
        Assertions.assertEquals(Position.of(3,4), elf6.getPosition());
        Assertions.assertEquals(Position.of(8,5), elf7.getPosition());
        Assertions.assertEquals(Position.of(12,5), elf8.getPosition());
        Assertions.assertEquals(Position.of(4,6), elf9.getPosition());
        Assertions.assertEquals(Position.of(9,6), elf10.getPosition());
        Assertions.assertEquals(Position.of(11,7), elf11.getPosition());
        Assertions.assertEquals(Position.of(2,7), elf12.getPosition());
        Assertions.assertEquals(Position.of(5,7), elf13.getPosition());
        Assertions.assertEquals(Position.of(7,6), elf14.getPosition());
        Assertions.assertEquals(Position.of(8,8), elf15.getPosition());
        Assertions.assertEquals(Position.of(3,9), elf16.getPosition());
        Assertions.assertEquals(Position.of(4,9), elf17.getPosition());
        Assertions.assertEquals(Position.of(6,9), elf18.getPosition());
        Assertions.assertEquals(Position.of(9,8), elf19.getPosition());
        Assertions.assertEquals(Position.of(11,9), elf20.getPosition());
        Assertions.assertEquals(Position.of(4,10), elf21.getPosition());
        Assertions.assertEquals(Position.of(8,11), elf22.getPosition());
    }

    @Test
    public void simulateFiveRoundsWithLargerExample() {
        // Simulated Start Situation
        //             11111
        //    12345678901234
        //  1 ..............
        //  2 ..............
        //  3 .......#......
        //  4 .....###.#....
        //  5 ...#...#.#....
        //  6 ....#...##....
        //  7 ...#.###......
        //  8 ...##.#.##....
        //  9 ....#..#......
        // 10 ..............
        // 11 ..............
        // 12 ..............
        Elf elf1 = new Elf(Position.of(8, 3));
        Elf elf2 = new Elf(Position.of(6, 4));
        Elf elf3 = new Elf(Position.of(7, 4));
        Elf elf4 = new Elf(Position.of(8, 4));
        Elf elf5 = new Elf(Position.of(10, 4));
        Elf elf6 = new Elf(Position.of(4, 5));
        Elf elf7 = new Elf(Position.of(8, 5));
        Elf elf8 = new Elf(Position.of(10, 5));
        Elf elf9 = new Elf(Position.of(5, 6));
        Elf elf10 = new Elf(Position.of(9, 6));
        Elf elf11 = new Elf(Position.of(10, 6));
        Elf elf12 = new Elf(Position.of(4, 7));
        Elf elf13 = new Elf(Position.of(6, 7));
        Elf elf14 = new Elf(Position.of(7, 7));
        Elf elf15 = new Elf(Position.of(8, 7));
        Elf elf16 = new Elf(Position.of(4, 8));
        Elf elf17 = new Elf(Position.of(5, 8));
        Elf elf18 = new Elf(Position.of(7, 8));
        Elf elf19 = new Elf(Position.of(9, 8));
        Elf elf20 = new Elf(Position.of(10, 8));
        Elf elf21 = new Elf(Position.of(5, 9));
        Elf elf22 = new Elf(Position.of(8, 9));

        Process process = new Process();
        process.add(elf1);
        process.add(elf2);
        process.add(elf3);
        process.add(elf4);
        process.add(elf5);
        process.add(elf6);
        process.add(elf7);
        process.add(elf8);
        process.add(elf9);
        process.add(elf10);
        process.add(elf11);
        process.add(elf12);
        process.add(elf13);
        process.add(elf14);
        process.add(elf15);
        process.add(elf16);
        process.add(elf17);
        process.add(elf18);
        process.add(elf19);
        process.add(elf20);
        process.add(elf21);
        process.add(elf22);

        process.simulate(5);

        //             11111                   11111
        //    12345678901234          12345678901234
        //  1 ..............        1 .......#......
        //  2 ..............        2 ..............
        //  3 .......#......        3 ..#..#.....#..
        //  4 .....###.#....        4 .........#....
        //  5 ...#...#.#....        5 ......##...#..
        //  6 ....#...##....  ==>   6 .#.#.####.....
        //  7 ...#.###......        7 ...........#..
        //  8 ...##.#.##....        8 ....##..#.....
        //  9 ....#..#......        9 ..#...........
        // 10 ..............       10 ..........#...
        // 11 ..............       11 ....#..#......
        // 12 ..............       12 ..............
        //      INITIAL                  ROUND 5

        Assertions.assertEquals(Position.of(8,1), elf1.getPosition());
        Assertions.assertEquals(Position.of(6,3), elf2.getPosition());
        Assertions.assertEquals(Position.of(7,5), elf3.getPosition());
        Assertions.assertEquals(Position.of(10,4), elf4.getPosition());
        Assertions.assertEquals(Position.of(12,3), elf5.getPosition());
        Assertions.assertEquals(Position.of(3,3), elf6.getPosition());
        Assertions.assertEquals(Position.of(8,5), elf7.getPosition());
        Assertions.assertEquals(Position.of(12,5), elf8.getPosition());
        Assertions.assertEquals(Position.of(4,6), elf9.getPosition());
        Assertions.assertEquals(Position.of(9,6), elf10.getPosition());
        Assertions.assertEquals(Position.of(12,7), elf11.getPosition());
        Assertions.assertEquals(Position.of(2,6), elf12.getPosition());
        Assertions.assertEquals(Position.of(6,6), elf13.getPosition());
        Assertions.assertEquals(Position.of(7,6), elf14.getPosition());
        Assertions.assertEquals(Position.of(8,6), elf15.getPosition());
        Assertions.assertEquals(Position.of(3,9), elf16.getPosition());
        Assertions.assertEquals(Position.of(5,8), elf17.getPosition());
        Assertions.assertEquals(Position.of(6,8), elf18.getPosition());
        Assertions.assertEquals(Position.of(9,8), elf19.getPosition());
        Assertions.assertEquals(Position.of(11,10), elf20.getPosition());
        Assertions.assertEquals(Position.of(5,11), elf21.getPosition());
        Assertions.assertEquals(Position.of(8,11), elf22.getPosition());
    }

    @Test
    public void simulateTenRoundsWithLargerExample() {
        // Simulated Start Situation
        //             11111
        //    12345678901234
        //  1 ..............
        //  2 ..............
        //  3 .......#......
        //  4 .....###.#....
        //  5 ...#...#.#....
        //  6 ....#...##....
        //  7 ...#.###......
        //  8 ...##.#.##....
        //  9 ....#..#......
        // 10 ..............
        // 11 ..............
        // 12 ..............
        Elf elf1 = new Elf(Position.of(8, 3));
        Elf elf2 = new Elf(Position.of(6, 4));
        Elf elf3 = new Elf(Position.of(7, 4));
        Elf elf4 = new Elf(Position.of(8, 4));
        Elf elf5 = new Elf(Position.of(10, 4));
        Elf elf6 = new Elf(Position.of(4, 5));
        Elf elf7 = new Elf(Position.of(8, 5));
        Elf elf8 = new Elf(Position.of(10, 5));
        Elf elf9 = new Elf(Position.of(5, 6));
        Elf elf10 = new Elf(Position.of(9, 6));
        Elf elf11 = new Elf(Position.of(10, 6));
        Elf elf12 = new Elf(Position.of(4, 7));
        Elf elf13 = new Elf(Position.of(6, 7));
        Elf elf14 = new Elf(Position.of(7, 7));
        Elf elf15 = new Elf(Position.of(8, 7));
        Elf elf16 = new Elf(Position.of(4, 8));
        Elf elf17 = new Elf(Position.of(5, 8));
        Elf elf18 = new Elf(Position.of(7, 8));
        Elf elf19 = new Elf(Position.of(9, 8));
        Elf elf20 = new Elf(Position.of(10, 8));
        Elf elf21 = new Elf(Position.of(5, 9));
        Elf elf22 = new Elf(Position.of(8, 9));

        Process process = new Process();
        process.add(elf1);
        process.add(elf2);
        process.add(elf3);
        process.add(elf4);
        process.add(elf5);
        process.add(elf6);
        process.add(elf7);
        process.add(elf8);
        process.add(elf9);
        process.add(elf10);
        process.add(elf11);
        process.add(elf12);
        process.add(elf13);
        process.add(elf14);
        process.add(elf15);
        process.add(elf16);
        process.add(elf17);
        process.add(elf18);
        process.add(elf19);
        process.add(elf20);
        process.add(elf21);
        process.add(elf22);

        process.simulate(10);

        //             11111                   11111
        //    12345678901234          12345678901234
        //  1 ..............        1 .......#......
        //  2 ..............        2 ...........#..
        //  3 .......#......        3 ..#.#..#......
        //  4 .....###.#....        4 ......#.......
        //  5 ...#...#.#....        5 ...#.....#..#.
        //  6 ....#...##....  ==>   6 .#......##....
        //  7 ...#.###......        7 .....##.......
        //  8 ...##.#.##....        8 ..#........#..
        //  9 ....#..#......        9 ....#.#..#....
        // 10 ..............       10 ..............
        // 11 ..............       11 ....#..#..#...
        // 12 ..............       12 ..............
        //      INITIAL                  ROUND 10

        Assertions.assertEquals(Position.of(8,1), elf1.getPosition());
        Assertions.assertEquals(Position.of(5,3), elf2.getPosition());
        Assertions.assertEquals(Position.of(7,4), elf3.getPosition());
        Assertions.assertEquals(Position.of(10,5), elf4.getPosition());
        Assertions.assertEquals(Position.of(12,2), elf5.getPosition());
        Assertions.assertEquals(Position.of(3,3), elf6.getPosition());
        Assertions.assertEquals(Position.of(8,3), elf7.getPosition());
        Assertions.assertEquals(Position.of(13,5), elf8.getPosition());
        Assertions.assertEquals(Position.of(4,5), elf9.getPosition());
        Assertions.assertEquals(Position.of(10,6), elf10.getPosition());
        Assertions.assertEquals(Position.of(12,8), elf11.getPosition());
        Assertions.assertEquals(Position.of(2,6), elf12.getPosition());
        Assertions.assertEquals(Position.of(6,7), elf13.getPosition());
        Assertions.assertEquals(Position.of(7,7), elf14.getPosition());
        Assertions.assertEquals(Position.of(9,6), elf15.getPosition());
        Assertions.assertEquals(Position.of(3,8), elf16.getPosition());
        Assertions.assertEquals(Position.of(5,9), elf17.getPosition());
        Assertions.assertEquals(Position.of(7,9), elf18.getPosition());
        Assertions.assertEquals(Position.of(10,9), elf19.getPosition());
        Assertions.assertEquals(Position.of(11,11), elf20.getPosition());
        Assertions.assertEquals(Position.of(5,11), elf21.getPosition());
        Assertions.assertEquals(Position.of(8,11), elf22.getPosition());
    }

    @Test
    public void simulateAllRoundsUntilNoElfMovesWithLargerExample() {
        // Simulated Start Situation
        //             11111
        //    12345678901234
        //  1 ..............
        //  2 ..............
        //  3 .......#......
        //  4 .....###.#....
        //  5 ...#...#.#....
        //  6 ....#...##....
        //  7 ...#.###......
        //  8 ...##.#.##....
        //  9 ....#..#......
        // 10 ..............
        // 11 ..............
        // 12 ..............
        Elf elf1 = new Elf(Position.of(8, 3));
        Elf elf2 = new Elf(Position.of(6, 4));
        Elf elf3 = new Elf(Position.of(7, 4));
        Elf elf4 = new Elf(Position.of(8, 4));
        Elf elf5 = new Elf(Position.of(10, 4));
        Elf elf6 = new Elf(Position.of(4, 5));
        Elf elf7 = new Elf(Position.of(8, 5));
        Elf elf8 = new Elf(Position.of(10, 5));
        Elf elf9 = new Elf(Position.of(5, 6));
        Elf elf10 = new Elf(Position.of(9, 6));
        Elf elf11 = new Elf(Position.of(10, 6));
        Elf elf12 = new Elf(Position.of(4, 7));
        Elf elf13 = new Elf(Position.of(6, 7));
        Elf elf14 = new Elf(Position.of(7, 7));
        Elf elf15 = new Elf(Position.of(8, 7));
        Elf elf16 = new Elf(Position.of(4, 8));
        Elf elf17 = new Elf(Position.of(5, 8));
        Elf elf18 = new Elf(Position.of(7, 8));
        Elf elf19 = new Elf(Position.of(9, 8));
        Elf elf20 = new Elf(Position.of(10, 8));
        Elf elf21 = new Elf(Position.of(5, 9));
        Elf elf22 = new Elf(Position.of(8, 9));

        Process process = new Process();
        process.add(elf1);
        process.add(elf2);
        process.add(elf3);
        process.add(elf4);
        process.add(elf5);
        process.add(elf6);
        process.add(elf7);
        process.add(elf8);
        process.add(elf9);
        process.add(elf10);
        process.add(elf11);
        process.add(elf12);
        process.add(elf13);
        process.add(elf14);
        process.add(elf15);
        process.add(elf16);
        process.add(elf17);
        process.add(elf18);
        process.add(elf19);
        process.add(elf20);
        process.add(elf21);
        process.add(elf22);

        //             11111                   11111
        //    12345678901234          12345678901234
        //  1 ..............        1 .......#......
        //  2 ..............        2 ....#......#..
        //  3 .......#......        3 ..#.....#.....
        //  4 .....###.#....        4 ......#.......
        //  5 ...#...#.#....        5 ...#....#.#..#
        //  6 ....#...##....  ==>   6 #.............
        //  7 ...#.###......        7 ....#.....#...
        //  8 ...##.#.##....        8 ..#.....#.....
        //  9 ....#..#......        9 ....#.#....#..
        // 10 ..............       10 .........#....
        // 11 ..............       11 ....#......#..
        // 12 ..............       12 .......#......
        //      INITIAL                  ROUND 20

        Assertions.assertEquals(20, process.simulateUntilNoElfMoves());
    }
}
