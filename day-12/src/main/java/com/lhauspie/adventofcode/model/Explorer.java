package com.lhauspie.adventofcode.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Explorer {
    private static Integer ZERO_ALTITUDE = 0;
    private Map<Position, Integer> heightmap;
    private Map<Position, Integer> explorationMap = new HashMap<>();

    public Explorer(Map<Position, Integer> heightmap) {
        this.heightmap = heightmap;
    }

    public Integer findTheShortestPath(Position from, Position to) {
        markPositionAsExplored(from, 0);
        return findTheShortestPathTo(to);
    }

    public Integer findTheShortestPathFromAnyZeroAltitudePosition(Position to) {
        markEveryZeroAltitudePositionsAsExplored(0);
        return findTheShortestPathTo(to);
    }

    private Integer findTheShortestPathTo(Position destination) {
        while (!destinationReached(destination)) {
            exploreNeighboursOfAlreadyExploredPositions();
        }
        return explorationMap.get(destination);
    }

    private boolean destinationReached(Position destination) {
        return explorationMap.containsKey(destination);
    }

    private void exploreNeighboursOfAlreadyExploredPositions() {
        // for each already explored Position, we'll calculate the Neighbours' number of steps
        for (var currentPosition : new HashSet<>(explorationMap.keySet())) {
            var nextExplorationStep = explorationMap.get(currentPosition) + 1;
            markNextPositionAsExploredIfPossible(currentPosition.up(), nextExplorationStep, currentPosition);
            markNextPositionAsExploredIfPossible(currentPosition.down(), nextExplorationStep, currentPosition);
            markNextPositionAsExploredIfPossible(currentPosition.left(), nextExplorationStep, currentPosition);
            markNextPositionAsExploredIfPossible(currentPosition.right(), nextExplorationStep, currentPosition);
        }
    }

    private void markNextPositionAsExploredIfPossible(Position nextPosition, int nextExplorationStep, Position currentPosition) {
        if (heightmap.containsKey(nextPosition)                                           // nextPosition is not outside the map
                && heightmap.get(nextPosition) <= heightmap.get(currentPosition) + 1      // nextPosition is not too high
                && !explorationMap.containsKey(nextPosition)) {                           // nextPosition is never explored
            markPositionAsExplored(nextPosition, nextExplorationStep);
        }
    }

    private Integer markPositionAsExplored(Position from, int numberOfSteps) {
        return explorationMap.put(from, numberOfSteps);
    }

    private void markEveryZeroAltitudePositionsAsExplored(Integer numberOfSteps) {
        for (var position : heightmap.keySet()) {
            if (heightmap.get(position) == ZERO_ALTITUDE) {
                markPositionAsExplored(position, numberOfSteps);
            }
        }
    }
}
