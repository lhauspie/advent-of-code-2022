package com.lhauspie.adventofcode.day19.model;

// Each Robot has cost and a build results to a new Robot
public class RobotRecipe {
    private int oreCost;
    private int clayCost;
    private int obsidianCost;
    private int newOreCollectingRobot;
    private int newClayCollectingRobot;
    private int newObsidianCollectingRobot;
    private int newGeodeCrackingRobot;

    public RobotRecipe(int oreCost, int clayCost, int obsidianCost, int newOreCollectingRobot, int newClayCollectingRobot, int newObsidianCollectingRobot, int newGeodeCrackingRobot) {
        this.oreCost = oreCost;
        this.clayCost = clayCost;
        this.obsidianCost = obsidianCost;
        this.newOreCollectingRobot = newOreCollectingRobot;
        this.newClayCollectingRobot = newClayCollectingRobot;
        this.newObsidianCollectingRobot = newObsidianCollectingRobot;
        this.newGeodeCrackingRobot = newGeodeCrackingRobot;
    }

    public int getNewOreCollectingRobot() {
        return newOreCollectingRobot;
    }

    public int getNewClayCollectingRobot() {
        return newClayCollectingRobot;
    }

    public int getNewObsidianCollectingRobot() {
        return newObsidianCollectingRobot;
    }

    public int getNewGeodeCrackingRobot() {
        return newGeodeCrackingRobot;
    }

    public int getOreCost() {
        return oreCost;
    }

    public int getClayCost() {
        return clayCost;
    }

    public int getObsidianCost() {
        return obsidianCost;
    }
}
