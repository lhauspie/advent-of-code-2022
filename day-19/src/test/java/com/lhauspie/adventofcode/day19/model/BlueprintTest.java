package com.lhauspie.adventofcode.day19.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlueprintTest {

    @Test
    public void testOne() {
        // Blueprint 1:
        //     Each ore robot costs 4 ore.
        //     Each clay robot costs 2 ore.
        //     Each obsidian robot costs 3 ore and 14 clay.
        //     Each geode robot costs 2 ore and 7 obsidian.
        Blueprint blueprint = new Blueprint(
                1,
                new OreCollectingRobotRecipe(4),
                new ClayCollectingRobotRecipe(2),
                new ObsidianCollectingRobotRecipe(3, 14),
                new GeodeCrackingRobotRecipe(2, 0, 7)
        );

        assertEquals(9, blueprint.getQualityLevel(24));
    }

    @Test
    public void testTwo() {
        // Blueprint 2:
        //     Each ore robot costs 2 ore.
        //     Each clay robot costs 3 ore.
        //     Each obsidian robot costs 3 ore and 8 clay.
        //     Each geode robot costs 3 ore and 12 obsidian.
        Blueprint blueprint = new Blueprint(
                2,
                new OreCollectingRobotRecipe(2),
                new ClayCollectingRobotRecipe(3),
                new ObsidianCollectingRobotRecipe(3, 8),
                new GeodeCrackingRobotRecipe(3, 0, 12)
        );

        assertEquals(24, blueprint.getQualityLevel(24));
    }
}
