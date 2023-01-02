package com.lhauspie.adventofcode.day23.model;

import java.util.List;

public class Elf {
    private static PositionFactory positionFactory = PositionFactory.getInstance();

    private Position position;
    private Position nextPosition;
    private boolean nextPositionFound = false;
    private boolean moveConfirmed = false;

    public Elf(Position position) {
        this.position = position;
    }

    public boolean chooseNextPosition(List<Elf> neighbours, Direction firstDirectionToConsider) {
        if (neighbours.size() != 0) {
            Direction directionToConsider = firstDirectionToConsider;
            for (int i = 0; i < 4; i++) {
                if (possibleToMoveToDirectionAccordingToNeighbours(directionToConsider, neighbours)) {
                    nextPosition = nextPositionAccordingToDirection(directionToConsider);
                    nextPositionFound = true;
                    return true;
                }
                directionToConsider = directionToConsider.next();
            }
        }
        nextPositionFound = false;
        return false;
    }

    public void cancelMoveIfCollision(List<Elf> elvesWhoCanChooseSameNextPositionThanMe) {
        if (nextPositionFound) {
            moveConfirmed = elvesWhoCanChooseSameNextPositionThanMe.stream().noneMatch(elf -> this.getNextPosition().equals(elf.getNextPosition()));
        }
    }

    public boolean move() {
        boolean moveSuccess = false;
        if (nextPositionFound && moveConfirmed) {
            position = nextPosition;
            moveSuccess = true;
        }
        nextPosition = null;
        nextPositionFound = false;
        moveConfirmed = false;
        return moveSuccess;
    }

    private boolean possibleToMoveToDirectionAccordingToNeighbours(Direction direction, List<Elf> neighbours) {
        return switch (direction) {
            case NORTH -> noElfPresentToNorth(neighbours);
            case SOUTH -> noElfPresentToSouth(neighbours);
            case WEST  -> noElfPresentToWest(neighbours);
            case EAST  -> noElfPresentToEast(neighbours);
        };
    }

    private boolean noElfPresentToNorth(List<Elf> neighbours) {
        return neighbours.stream().noneMatch(elf -> elf.getPosition().getY() == position.getY() - 1);
    }

    private boolean noElfPresentToSouth(List<Elf> neighbours) {
        return neighbours.stream().noneMatch(elf -> elf.getPosition().getY() == position.getY() + 1);
    }

    private boolean noElfPresentToEast(List<Elf> neighbours) {
        return neighbours.stream().noneMatch(elf -> elf.getPosition().getX() == position.getX() + 1);
    }

    private boolean noElfPresentToWest(List<Elf> neighbours) {
        return neighbours.stream().noneMatch(elf -> elf.getPosition().getX() == position.getX() - 1);
    }

    private Position nextPositionAccordingToDirection(Direction direction) {
        return switch (direction) {
            case NORTH -> positionFactory.up(position);
            case SOUTH -> positionFactory.down(position);
            case WEST  -> positionFactory.left(position);
            case EAST  -> positionFactory.right(position);
        };
    }

    public Position getPosition() {
        return position;
    }

    public Position getNextPosition() {
        return nextPosition;
    }
}
