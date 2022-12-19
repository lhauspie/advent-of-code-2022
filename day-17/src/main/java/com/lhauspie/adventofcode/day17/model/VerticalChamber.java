package com.lhauspie.adventofcode.day17.model;

import com.lhauspie.adventofcode.day17.model.rock.Rock;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class VerticalChamber {
    private final int width;
    private Set<MutablePosition> restingRocksPositions = new HashSet<>();
    private MutablePosition highestPosition = MutablePosition.of(0,-1);

    public VerticalChamber() {
        this(7);
    }

    public VerticalChamber(int width) {
        this.width = width;
    }

    public long getTowerTall() {
        return highestPosition.getY() + 1;
    }

    public void restRock(Rock rock) {
        Set<MutablePosition> rockRocksPositions = rock.getRocksPositions();
        MutablePosition highestPosition = rockRocksPositions.stream().max(Comparator.comparingLong(MutablePosition::getY)).orElseThrow(() -> new RuntimeException("No higher Position found for rock"));
        if (highestPosition.getY() > this.highestPosition.getY()) {
            this.highestPosition = highestPosition;
        }
        this.restingRocksPositions.addAll(rockRocksPositions);
    }

    public MutablePosition getHighestPosition() {
        return highestPosition;
    }

    private boolean rockCanBeMovedRight(Rock rock) {
        return rockPositionsWillNotCollideWithRightRestingRocks(rock) && rockIsNotAdjacentToRightWall(rock);
    }

    private boolean rockCanBeMovedDown(Rock rock) {
        return rockPositionsWillNotCollideWithDownRestingRocks(rock) && rockIsNotAdjacentToFlour(rock);
    }

    private boolean rockCanBeMovedLeft(Rock rock) {
        return rockPositionsWillNotCollideWithLeftRestingRocks(rock) && rockIsNotAdjacentToLeftWall(rock);
    }

    private boolean rockPositionsWillNotCollideWithRightRestingRocks(Rock rock) {
        return rock.getRocksPositions().stream().noneMatch(
                rockPosition -> restingRocksPositions.contains(MutablePosition.of(rockPosition.getX() + 1, rockPosition.getY()))
        );
    }

    private boolean rockPositionsWillNotCollideWithDownRestingRocks(Rock rock) {
        return rock.getRocksPositions().stream().noneMatch(
                rockPosition -> restingRocksPositions.contains(MutablePosition.of(rockPosition.getX(), rockPosition.getY() - 1))
        );
    }

    private boolean rockPositionsWillNotCollideWithLeftRestingRocks(Rock rock) {
        return rock.getRocksPositions().stream().noneMatch(
                rockPosition -> restingRocksPositions.contains(MutablePosition.of(rockPosition.getX() - 1, rockPosition.getY()))
        );
    }

    private boolean rockIsNotAdjacentToRightWall(Rock rock) {
        return rock.getBottomLeftCornerPosition().getX() + rock.getWidth() < this.width;
    }

    private boolean rockIsNotAdjacentToFlour(Rock rock) {
        return rock.getBottomLeftCornerPosition().getY() > 0;
    }

    private boolean rockIsNotAdjacentToLeftWall(Rock rock) {
        return rock.getBottomLeftCornerPosition().getX() > 0;
    }

    public Set<MutablePosition> getRestingRocksPositions() {
        return restingRocksPositions;
    }

    public int getWidth() {
        return width;
    }

    public boolean moveDownIfPossible(Rock rock) {
        if (rockCanBeMovedDown(rock)) {
            rock.moveDown();
            return true;
        } else {
            restRock(rock);
            return false;
        }
    }

    public boolean moveLeftIfPossible(Rock rock) {
        if (rockCanBeMovedLeft(rock)) {
            rock.moveLeft();
            return true;
        } else {
            return false;
        }
    }

    public boolean moveRightIfPossible(Rock rock) {
        if (rockCanBeMovedRight(rock)) {
            rock.moveRight();
            return true;
        } else {
            return false;
        }
    }
}
