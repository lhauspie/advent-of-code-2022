package com.lhauspie.adventofcode.day12.model;

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
        while (!positionAlreadyExplored(destination)) {
            exploreNeighboursOfAlreadyExploredPositions();
        }
        return getNumberOfStepsBeforeReachingThePosition(destination);
    }

    private void exploreNeighboursOfAlreadyExploredPositions() {
        getAlreadyExploredPositions().forEach(currentPosition ->
                markNeighboursPositionsAsExploredIfReachableFrom(currentPosition)
        );
    }

    private void markNeighboursPositionsAsExploredIfReachableFrom(Position currentPosition) {
        markNextPositionAsExploredIfReachableFromCurrentPosition(currentPosition.up(), currentPosition);
        markNextPositionAsExploredIfReachableFromCurrentPosition(currentPosition.down(), currentPosition);
        markNextPositionAsExploredIfReachableFromCurrentPosition(currentPosition.left(), currentPosition);
        markNextPositionAsExploredIfReachableFromCurrentPosition(currentPosition.right(), currentPosition);
    }

    private Integer getNumberOfStepsBeforeReachingThePosition(Position currentPosition) {
        return explorationMap.get(currentPosition);
    }

    private HashSet<Position> getAlreadyExploredPositions() {
        return new HashSet<>(explorationMap.keySet());
    }

    private void markNextPositionAsExploredIfReachableFromCurrentPosition(Position nextPosition, Position currentPosition) {
        if (positionReachableFromCurrentPosition(nextPosition, currentPosition)) {
            markPositionAsExplored(nextPosition, getNumberOfStepsBeforeReachingThePosition(currentPosition) + 1);
        }
    }

    private boolean positionReachableFromCurrentPosition(Position positionToReach, Position startPosition) {
        return positionIsOnTheMap(positionToReach)
                && !positionAlreadyExplored(positionToReach)
                && positionIsNotTooHighFromCurrentPosition(positionToReach, startPosition);
    }

    private boolean positionAlreadyExplored(Position nextPosition) {
        return explorationMap.containsKey(nextPosition);
    }

    private boolean positionIsOnTheMap(Position nextPosition) {
        return heightmap.containsKey(nextPosition);
    }

    private boolean positionIsNotTooHighFromCurrentPosition(Position positionToReach, Position startPosition) {
        return heightmap.get(positionToReach) <= heightmap.get(startPosition) + 1;
    }

    private Integer markPositionAsExplored(Position position, int numberOfStepsBeforeReachingThePosition) {
        return explorationMap.put(position, numberOfStepsBeforeReachingThePosition);
    }

    private void markEveryZeroAltitudePositionsAsExplored(Integer numberOfStepsBeforeReachingThePosition) {
        for (var position : heightmap.keySet()) {
            if (heightmap.get(position) == ZERO_ALTITUDE) {
                markPositionAsExplored(position, numberOfStepsBeforeReachingThePosition);
            }
        }
    }
}
