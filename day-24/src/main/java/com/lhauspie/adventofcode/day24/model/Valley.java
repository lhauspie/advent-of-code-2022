package com.lhauspie.adventofcode.day24.model;

import java.time.Duration;
import java.util.*;

public class Valley {
    private final List<Blizzard> blizzards = new ArrayList<>();
    private final Set<Position> blizzardsPositions = new HashSet<>();
    private final Set<Position> walls = new HashSet<>();

    private Position wallsMinPosition = Position.of(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private Position wallsMaxPosition = Position.of(Integer.MIN_VALUE, Integer.MIN_VALUE);
    private Position groundMinPosition;
    private Position groundMaxPosition;

    public void addWall(Position wall) {
        walls.add(wall);
        wallsMaxPosition = Position.of(Math.max(wall.getX(), wallsMaxPosition.getX()), Math.max(wall.getY(), wallsMaxPosition.getY()));
        wallsMinPosition = Position.of(Math.min(wall.getX(), wallsMinPosition.getX()), Math.min(wall.getY(), wallsMinPosition.getY()));
        groundMaxPosition = Position.of(wallsMaxPosition.getX() - 1, wallsMaxPosition.getY() - 1);
        groundMinPosition = Position.of(wallsMinPosition.getX() + 1, wallsMinPosition.getY() + 1);
    }

    public void addBlizzard(Blizzard blizzard) {
        blizzards.add(blizzard);
        blizzardsPositions.add(blizzard.getPosition());
    }

    public Duration reachPositionFromStartPositionAndGetTravelDuration(Position startPosition, Position positionToReach) {
        Set<Position> possibleExpeditionPositionsAccordingToWallsAndBlizzards = new HashSet<>();
        possibleExpeditionPositionsAccordingToWallsAndBlizzards.add(startPosition);
        Duration travelDurationInMinute = Duration.ofMinutes(0);
        while (!possibleExpeditionPositionsAccordingToWallsAndBlizzards.contains(positionToReach)) {
            moveBlizzardsAndCalculateNewBlizzardsPositions();
            possibleExpeditionPositionsAccordingToWallsAndBlizzards = getPossibleExpeditionPositionsForNextMinute(possibleExpeditionPositionsAccordingToWallsAndBlizzards);
            travelDurationInMinute = travelDurationInMinute.plusMinutes(1);
        }

        return travelDurationInMinute;
    }

    private void moveBlizzardsAndCalculateNewBlizzardsPositions() {
        blizzardsPositions.clear();
        for (Blizzard blizzard : blizzards) {
            blizzardsPositions.add(blizzard.moveAndGetNewPosition(groundMinPosition, groundMaxPosition));
        }
    }

    private Set<Position> getPossibleExpeditionPositionsForNextMinute(Set<Position> expeditionPositions) {
        Set<Position> possibleExpeditionPositionsForNextMinute = new HashSet<>();
        for (Position expedition : expeditionPositions) {
            tryGoingFromPositionToDirection(expedition, Direction.STAY) .ifPresent(position -> possibleExpeditionPositionsForNextMinute.add(position));
            tryGoingFromPositionToDirection(expedition, Direction.NORTH).ifPresent(position -> possibleExpeditionPositionsForNextMinute.add(position));
            tryGoingFromPositionToDirection(expedition, Direction.SOUTH).ifPresent(position -> possibleExpeditionPositionsForNextMinute.add(position));
            tryGoingFromPositionToDirection(expedition, Direction.WEST) .ifPresent(position -> possibleExpeditionPositionsForNextMinute.add(position));
            tryGoingFromPositionToDirection(expedition, Direction.EAST) .ifPresent(position -> possibleExpeditionPositionsForNextMinute.add(position));
        }
        expeditionPositions = possibleExpeditionPositionsForNextMinute;
        return expeditionPositions;
    }

    private Optional<Position> tryGoingFromPositionToDirection(Position position, Direction direction) {
        Position nextPositionAccordingToDirection = position.add(direction.getMove());
        if (!blizzardsPositions.contains(nextPositionAccordingToDirection) && positionIsAllowed(nextPositionAccordingToDirection)) {
            return Optional.of(nextPositionAccordingToDirection);
        }
        return Optional.empty();
    }

    private boolean positionIsAllowed(Position position) {
        return !walls.contains(position)
                && position.getX() >= wallsMinPosition.getX()
                && position.getX() <= wallsMaxPosition.getX()
                && position.getY() >= wallsMinPosition.getY()
                && position.getY() <= wallsMaxPosition.getY();
    }

    public void render() {
        Set<Position> blizzardsPositions = new HashSet<>();
        for (Blizzard blizzard : blizzards) {
            blizzardsPositions.add(blizzard.getPosition());
        }

        for (int y = wallsMinPosition.getY(); y <= wallsMaxPosition.getY(); y++) {
            for (int x = wallsMinPosition.getX(); x <= wallsMaxPosition.getX(); x++) {
                if (walls.contains(Position.of(x, y))) {
                    System.out.print('#');
                } else if (blizzardsPositions.contains(Position.of(x, y))) {
                    System.out.print('*');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }

    public Position getWallsMinPosition() {
        return wallsMinPosition;
    }

    public Position getWallsMaxPosition() {
        return wallsMaxPosition;
    }
}