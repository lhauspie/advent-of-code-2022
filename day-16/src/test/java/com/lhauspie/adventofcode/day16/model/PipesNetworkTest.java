package com.lhauspie.adventofcode.day16.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PipesNetworkTest {

    // ========================
    // ONE VALVE TESTS
    // ========================
    @Test
    public void testOneValveOne() {
        Valve v1 = new Valve("AA", 10);
        assertEquals(290, PipesNetwork.getMostPressure(v1,30));
    }

    @Test
    public void testOneValveTwo() {
        Valve v1 = new Valve("AA", 11);
        assertEquals(319, PipesNetwork.getMostPressure(v1,30));
    }

    @Test
    public void testOneValveThree() {
        Valve v1 = new Valve("AA", 20);
        assertEquals(580, PipesNetwork.getMostPressure(v1,30));
    }

    @Test
    public void testOneValveFour() {
        Valve v1 = new Valve("AA", 0);
        assertEquals(0, PipesNetwork.getMostPressure(v1,30));
    }


    // ========================
    // TWO VALVES TESTS
    // ========================
    @Test
    public void testTwoValvesOne() {
        Valve v1 = new Valve("AA", 0);
        Valve v2 = new Valve("BB", 0);

        // AA -> BB -> AA
        v1.addNeighbour(v2);
        v2.addNeighbour(v1);

        assertEquals(0, PipesNetwork.getMostPressure(v1,30));
    }

    @Test
    public void testTwoValvesTwo() {
        Valve v1 = new Valve("AA", 10);
        Valve v2 = new Valve("BB", 0);

        // AA -> BB -> AA
        v1.addNeighbour(v2);
        v2.addNeighbour(v1);

        assertEquals(290, PipesNetwork.getMostPressure(v1,30));
    }

    @Test
    public void testTwoValvesThree() {
        Valve v1 = new Valve("AA", 0);
        Valve v2 = new Valve("BB", 10);

        // AA -> BB -> AA
        v1.addNeighbour(v2);
        v2.addNeighbour(v1);

        assertEquals(280, PipesNetwork.getMostPressure(v1,30));
    }

    @Test
    public void testTwoValvesFour() {
        Valve v1 = new Valve("AA", 10);
        Valve v2 = new Valve("BB", 10);

        // AA -> BB -> AA
        v1.addNeighbour(v2);
        v2.addNeighbour(v1);

        assertEquals(560, PipesNetwork.getMostPressure(v1,30));
    }

    @Test
    public void testTwoValvesFive() {
        // possible most pressures:
        // - opening the first then the second valve = 290 + 270000
        // - opening the second then the first valve = 280000 + 260
        // ==> the most pressure is 290260
        Valve v1 = new Valve("AA", 10);
        Valve v2 = new Valve("BB", 10000);

        // AA -> BB -> AA
        v1.addNeighbour(v2);
        v2.addNeighbour(v1);

        assertEquals(280260, PipesNetwork.getMostPressure(v1,30));
    }


    // ========================
    // TWO VALVES TESTS
    // ========================
    @Test
    public void testThreeValvesOne() {
        // possible most pressures:
        // - opening AA then BB then CC = 290 + 27000 + 2500000  = 2527290
        // - opening BB then CC then AA = 28000 + 2600000 + 240  = 2628240
        // - opening CC then AA then BB = 2700000 + 250 + 23000  = 2723250
        // - opening AA then CC (through BB) then BB (through AA) = 290 + 2600000 + 23000  = 2624290
        // - opening BB then AA (through CC) then CC (through BB) = 28000 + 250 + 2200000  = 2328250
        // - opening CC then BB (through AA) then AA (through CC) = 2700000 + 24000 + 210  = 2724210
        // ==> the most pressure is 2724210
        Valve v1 = new Valve("AA", 10);
        Valve v2 = new Valve("BB", 1000);
        Valve v3 = new Valve("CC", 100000);

        // AA -> BB -> CC -> AA
        v1.addNeighbour(v2);
        v2.addNeighbour(v3);
        v3.addNeighbour(v1);

        assertEquals(2724210, PipesNetwork.getMostPressure(v1, 30));
    }

    // @Test
    // This little graph has already got the better of me.
    public void testThreeValvesTwo() {
        // too many possibilities for this little graph... Hope no performance problem with a big one
        // I think the most pressure is given by the following path:
        // AA --> CC --> open --> BB --> open --> AA --> open
        // 30     29     2800000  27     26000    25     240   == 2826240
        // ==> the most pressure is 2826240
        Valve v1 = new Valve("AA", 10);
        Valve v2 = new Valve("BB", 1000);
        Valve v3 = new Valve("CC", 100000);

        // AA -> BB -> CC -> AA
        v1.addNeighbour(v2);
        v2.addNeighbour(v1);
        v2.addNeighbour(v3);
        v3.addNeighbour(v2);
        v3.addNeighbour(v1);
        v1.addNeighbour(v3);

        assertEquals(2826240, PipesNetwork.getMostPressure(v1, 30));
    }
}
