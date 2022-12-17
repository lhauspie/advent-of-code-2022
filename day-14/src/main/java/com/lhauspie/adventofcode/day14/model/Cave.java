package com.lhauspie.adventofcode.day14.model;

import java.util.HashSet;
import java.util.Set;

public class Cave {
    private SandSource sandSource;
    private Set<Position> rocks = new HashSet<>();
    private Set<Position> restingSandUnits = new HashSet<>();

    private Position minPosition;
    private Position maxPosition;

    public Cave(SandSource sandSource) {
        this.sandSource = sandSource;
        this.minPosition = sandSource.getPosition();
        this.maxPosition = sandSource.getPosition();
    }

    public void addRestingSandUnit(SandUnit restingSandUnit) {
        restingSandUnits.add(restingSandUnit.getPosition());
    }

    public void addRock(Position rock) {
        rocks.add(rock);
        refreshMinPosition(rock);
        refreshMaxPosition(rock);
    }

    private void refreshMinPosition(Position rock) {
        int minX = minPosition.getX();
        int minY = minPosition.getY();
        if (rock.getX() <= minPosition.getX()) {
            minX = rock.getX();
        }
        if (rock.getY() <= minPosition.getY()) {
            minY = rock.getY();
        }
        minPosition = Position.of(minX, minY);
    }

    private void refreshMaxPosition(Position rock) {
        int maxX = maxPosition.getX();
        int maxY = maxPosition.getY();
        if (rock.getX() >= maxPosition.getX()) {
            maxX = rock.getX();
        }
        if (rock.getY() >= maxPosition.getY()) {
            maxY = rock.getY();
        }
        maxPosition = Position.of(maxX, maxY);
    }

    public Position getMinPosition() {
        return minPosition;
    }

    public Position getMaxPosition() {
        return maxPosition;
    }

    public void render(SandUnit sandUnit) {
        for (int y = minPosition.getY(); y <= maxPosition.getY(); y++) {
            for (int x = minPosition.getX(); x <= maxPosition.getX(); x++) {
                Position position = Position.of(x, y);
                if (restingSandUnits.contains(position)) {
                    System.out.print('o');
                } else if (sandSource.getPosition().equals(position)) {
                    System.out.print('+');
                } else if (sandUnit.getPosition().equals(position)) {
                    System.out.print('~');
                } else if (isFree(position)) {
                    System.out.print('.');
                } else if (rocks.contains(position)) {
                    System.out.print('▓');
                }
            }
            System.out.println();
        }
        System.out.println("================================");
    }

    public boolean isFree(Position position) {
        return !(rocks.contains(position) || restingSandUnits.contains(position));
    }

    public int getNumberOfRestingSandUnits() {
        return restingSandUnits.size();
    }

    public boolean sandSourceIsBlockedBy(SandUnit sandUnit) {
        return sandSource.isBlockedBy(sandUnit);
    }

    private int getMinXToAvoidSandUnitsFlowingIntoTheAbyss() {
        return sandSource.getPosition().getX() - (getMaxPosition().getY() - getMinPosition().getY()) - 2;
    }

    private int getMaxXToAvoidSandUnitsFlowingIntoTheAbyss() {
        return sandSource.getPosition().getX() + (getMaxPosition().getY() - getMinPosition().getY()) + 2;
    }

    public SandSource getSandSource() {
        return sandSource;
    }

    public boolean sandUnitIsFallingIntoAbyss(SandUnit sandUnit) {
        return sandUnit.getPosition().getY() > getMaxPosition().getY();
    }

    public void addFloor() {
        int lastLineMaxY = getMaxPosition().getY() + 2;
        for (int x = getMinXToAvoidSandUnitsFlowingIntoTheAbyss(); x <= getMaxXToAvoidSandUnitsFlowingIntoTheAbyss(); x++) {
            addRock(new Position(x, lastLineMaxY));
        }
    }
}
