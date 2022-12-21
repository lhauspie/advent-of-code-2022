package com.lhauspie.adventofcode.day19.model;

import java.util.stream.Stream;

public class Blueprint {
    private int id;
    private OreCollectingRobotRecipe oreCollectingRobotRecipe;
    private ClayCollectingRobotRecipe clayCollectingRobotRecipe;
    private ObsidianCollectingRobotRecipe obsidianCollectingRobotRecipe;
    private GeodeCrackingRobotRecipe geodeCrackingRobotRecipe;

    private int maxOresToBeProducedInOneMinuteToBuildAnyRobot;
    private int maxClaysToBeProducedInOneMinuteToBuildAnyRobot;
    private int maxObsidiansToBeProducedInOneMinuteToBuildAnyRobot;

    public Blueprint(int id, OreCollectingRobotRecipe oreCollectingRobotRecipe, ClayCollectingRobotRecipe clayCollectingRobotRecipe, ObsidianCollectingRobotRecipe obsidianCollectingRobotRecipe, GeodeCrackingRobotRecipe geodeCrackingRobotRecipe) {
        this.id = id;
        this.oreCollectingRobotRecipe = oreCollectingRobotRecipe;
        this.clayCollectingRobotRecipe = clayCollectingRobotRecipe;
        this.obsidianCollectingRobotRecipe = obsidianCollectingRobotRecipe;
        this.geodeCrackingRobotRecipe = geodeCrackingRobotRecipe;

        maxOresToBeProducedInOneMinuteToBuildAnyRobot = robotRecipes().map(recipe -> recipe.getOreCost()).max(Integer::compare).get();
        maxClaysToBeProducedInOneMinuteToBuildAnyRobot = robotRecipes().map(recipe -> recipe.getClayCost()).max(Integer::compare).get();
        maxObsidiansToBeProducedInOneMinuteToBuildAnyRobot = robotRecipes().map(recipe -> recipe.getObsidianCost()).max(Integer::compare).get();
    }

    private Stream<RobotRecipe> robotRecipes() {
        return Stream.of(
                oreCollectingRobotRecipe,
                clayCollectingRobotRecipe,
                obsidianCollectingRobotRecipe,
                geodeCrackingRobotRecipe
        );
    }

    public long getQualityLevel(int timeLeft) {
        return id * getLargestNumberOfGeodesThatCanBeOpened(timeLeft);
    }

    public long getLargestNumberOfGeodesThatCanBeOpened(int timeLeft) {
        return getLargestNumberOfGeodesThatCanBeOpenedAfter(new BlueprintSimulationState(this), timeLeft);
    }

    public RobotRecipe getOreCollectingRobotRecipe() {
        return oreCollectingRobotRecipe;
    }

    public RobotRecipe getClayCollectingRobotRecipe() {
        return clayCollectingRobotRecipe;
    }

    public RobotRecipe getObsidianCollectingRobotRecipe() {
        return obsidianCollectingRobotRecipe;
    }

    public RobotRecipe getGeodeCrackingRobotRecipe() {
        return geodeCrackingRobotRecipe;
    }

    private long getLargestNumberOfGeodesThatCanBeOpenedAfter(BlueprintSimulationState currentState, int timeLeft) {
        return currentState.nextUsefulStates(timeLeft).stream()
                .map(blueprintSimulationState -> getLargestNumberOfGeodesThatCanBeOpenedAfter(blueprintSimulationState, timeLeft))
                .mapToLong(aLong -> aLong)
                .max().orElse(currentState.getNumberOfCrackedGeodes());
    }

    public int getMaxOresToBeProducedInOneMinuteToBuildAnyRobot() {
        return maxOresToBeProducedInOneMinuteToBuildAnyRobot;
    }

    public int getMaxClaysToBeProducedInOneMinuteToBuildAnyRobot() {
        return maxClaysToBeProducedInOneMinuteToBuildAnyRobot;
    }

    public int getMaxObsidiansToBeProducedInOneMinuteToBuildAnyRobot() {
        return maxObsidiansToBeProducedInOneMinuteToBuildAnyRobot;
    }
}
