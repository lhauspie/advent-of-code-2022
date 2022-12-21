package com.lhauspie.adventofcode.day19.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BlueprintSimulationState {
    private Blueprint blueprint;

    private int time = 1;

    private int numberOfCollectedOres = 1;
    private int numberOfOreCollectingRobots = 1;

    private int numberOfCollectedClays = 0;
    private int numberOfClayCollectingRobots = 0;

    private int numberOfCollectedObsidians = 0;
    private int numberOfObsidianCollectingRobots = 0;

    private int numberOfCrackedGeodes = 0;
    private int numberOfGeodeCrackingRobots = 0;

    public BlueprintSimulationState(Blueprint blueprint) {
        this.blueprint = blueprint;
    }

    public List<BlueprintSimulationState> nextUsefulStates(int timeLeft) {
        List<BlueprintSimulationState> nextUsefulStates = new ArrayList<>();

        if (time < timeLeft) {
            // doing nothing doesn't lead to a useful state change
            if (blueprint.getMaxOresToBeProducedInOneMinuteToBuildAnyRobot() > numberOfOreCollectingRobots && numberOfOreCollectingRobots > 0) {
                nextUsefulStates.add(jumpToStateAfterRobotBuilding(blueprint.getOreCollectingRobotRecipe()));
            }
            if (blueprint.getMaxClaysToBeProducedInOneMinuteToBuildAnyRobot() > numberOfClayCollectingRobots && numberOfOreCollectingRobots > 0) {
                nextUsefulStates.add(jumpToStateAfterRobotBuilding(blueprint.getClayCollectingRobotRecipe()));
            }
            if (blueprint.getMaxObsidiansToBeProducedInOneMinuteToBuildAnyRobot() > numberOfObsidianCollectingRobots && numberOfOreCollectingRobots > 0 && numberOfClayCollectingRobots > 0) {
                nextUsefulStates.add(jumpToStateAfterRobotBuilding(blueprint.getObsidianCollectingRobotRecipe()));
            }
            if (numberOfOreCollectingRobots > 0 && numberOfObsidianCollectingRobots > 0) {
                nextUsefulStates.add(jumpToStateAfterRobotBuilding(blueprint.getGeodeCrackingRobotRecipe()));
            }
        }

        // remove the states that are too late to be reached
        nextUsefulStates = nextUsefulStates.stream()
                .filter(nextUsefulState -> nextUsefulState.time <= timeLeft)
                .collect(Collectors.toList());

        return nextUsefulStates;
    }

    private BlueprintSimulationState jumpToStateAfterRobotBuilding(RobotRecipe robotRecipe) {
        BlueprintSimulationState stateAfterRobotBuilding = new BlueprintSimulationState(blueprint);

        int timeRequestedToBuildNextRobot = IntStream.of(
                     numberOfCollectedOres >= robotRecipe.getOreCost() ?      0 : (int) Math.ceil(     (robotRecipe.getOreCost() - numberOfCollectedOres)      / (double) numberOfOreCollectingRobots),
                    numberOfCollectedClays >= robotRecipe.getClayCost() ?     0 : (int) Math.ceil(    (robotRecipe.getClayCost() - numberOfCollectedClays)     / (double) numberOfClayCollectingRobots),
                numberOfCollectedObsidians >= robotRecipe.getObsidianCost() ? 0 : (int) Math.ceil((robotRecipe.getObsidianCost() - numberOfCollectedObsidians) / (double) numberOfObsidianCollectingRobots)
        ).max().getAsInt() + 1;
        stateAfterRobotBuilding.time = time + timeRequestedToBuildNextRobot;
        stateAfterRobotBuilding.numberOfCollectedOres       = numberOfCollectedOres      +      (numberOfOreCollectingRobots * timeRequestedToBuildNextRobot) - robotRecipe.getOreCost();
        stateAfterRobotBuilding.numberOfCollectedClays      = numberOfCollectedClays     +     (numberOfClayCollectingRobots * timeRequestedToBuildNextRobot) - robotRecipe.getClayCost();
        stateAfterRobotBuilding.numberOfCollectedObsidians  = numberOfCollectedObsidians + (numberOfObsidianCollectingRobots * timeRequestedToBuildNextRobot) - robotRecipe.getObsidianCost();
        stateAfterRobotBuilding.numberOfCrackedGeodes       = numberOfCrackedGeodes      +      (numberOfGeodeCrackingRobots * timeRequestedToBuildNextRobot);
        stateAfterRobotBuilding.numberOfOreCollectingRobots      = numberOfOreCollectingRobots      + robotRecipe.getNewOreCollectingRobot();
        stateAfterRobotBuilding.numberOfClayCollectingRobots     = numberOfClayCollectingRobots     + robotRecipe.getNewClayCollectingRobot();
        stateAfterRobotBuilding.numberOfObsidianCollectingRobots = numberOfObsidianCollectingRobots + robotRecipe.getNewObsidianCollectingRobot();
        stateAfterRobotBuilding.numberOfGeodeCrackingRobots      = numberOfGeodeCrackingRobots      + robotRecipe.getNewGeodeCrackingRobot();

        return stateAfterRobotBuilding;
    }

    public int getNumberOfCrackedGeodes() {
        return numberOfCrackedGeodes;
    }
}
