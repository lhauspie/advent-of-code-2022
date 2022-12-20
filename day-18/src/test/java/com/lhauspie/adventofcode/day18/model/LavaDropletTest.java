package com.lhauspie.adventofcode.day18.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LavaDropletTest {

    @Test
    public void testOne() {
        LavaDroplet lavaDroplet = new LavaDroplet();
        // This lavaDroplet have an air pocket trapped at the center point (x=1, y=1, z=1)
        lavaDroplet.add(Point3D.of(1, 1, 0));
        lavaDroplet.add(Point3D.of(1, 0, 1));
        lavaDroplet.add(Point3D.of(0, 1, 1));
        lavaDroplet.add(Point3D.of(2, 1, 1));
        lavaDroplet.add(Point3D.of(1, 2, 1));
        lavaDroplet.add(Point3D.of(1, 1, 2));

        assertEquals(36, lavaDroplet.getTotalSurfaceAreaIncludingAirPockets());
        assertEquals(30, lavaDroplet.getTotalSurfaceAreaIgnoringAirPockets());
    }
}
