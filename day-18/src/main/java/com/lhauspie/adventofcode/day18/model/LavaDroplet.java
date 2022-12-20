package com.lhauspie.adventofcode.day18.model;

import java.util.HashSet;
import java.util.Set;

public class LavaDroplet {
    private Set<Point3D> points = new HashSet<>();
    private Point3D minPoint = Point3D.of(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
    private Point3D maxPoint = Point3D.of(Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE);

    public void add(Point3D point) {
        minPoint = Point3D.of(
                Math.min(point.getX(), minPoint.getX()),
                Math.min(point.getY(), minPoint.getY()),
                Math.min(point.getZ(), minPoint.getZ()));
        maxPoint = Point3D.of(
                Math.max(point.getX(), maxPoint.getX()),
                Math.max(point.getY(), maxPoint.getY()),
                Math.max(point.getZ(), maxPoint.getZ()));
        points.add(point);
    }

    public long getTotalSurfaceAreaIncludingAirPockets() {
        return getTotalSurfaceArea(getPoints());
    }

    public long getTotalSurfaceAreaIgnoringAirPockets() {
        return getTotalSurfaceArea(getPointsWithAirPocketsFulfilled());
    }

    private static int getTotalSurfaceArea(Set<Point3D> points3D) {
        int totalSurfaceArea = 0;
        for (Point3D point3D : points3D) {
            int dropletSurfaceArea = 6;
            if (points3D.contains(point3D.up())) {
                dropletSurfaceArea--;
            }
            if (points3D.contains(point3D.down())) {
                dropletSurfaceArea--;
            }
            if (points3D.contains(point3D.left())) {
                dropletSurfaceArea--;
            }
            if (points3D.contains(point3D.right())) {
                dropletSurfaceArea--;
            }
            if (points3D.contains(point3D.front())) {
                dropletSurfaceArea--;
            }
            if (points3D.contains(point3D.back())) {
                dropletSurfaceArea--;
            }
            totalSurfaceArea += dropletSurfaceArea;
        }
        return totalSurfaceArea;
    }

    private Set<Point3D> getPoints() {
        return points;
    }

    private Set<Point3D> getPointsWithAirPocketsFulfilled() {
        Point3D startPoint = Point3D.of(minPoint.getX() - 1, minPoint.getY() - 1, minPoint.getZ() - 1);
        return negative(exploreFromStartPoint(startPoint));
    }

    private Set<Point3D> exploreFromStartPoint(Point3D point3D) {
        Set<Point3D> exploredPoints = new HashSet<>();
        Set<Point3D> pointsToBeExplored = new HashSet<>();
        pointsToBeExplored.add(point3D);
        while (!pointsToBeExplored.isEmpty()) {
            Set<Point3D> pointsToBeExploredAtNextStep = new HashSet<>();
            for (Point3D pointToBeExplored : pointsToBeExplored) {
                if (!points.contains(pointToBeExplored) && !outsideTheOuterBox(pointToBeExplored) && !exploredPoints.contains(pointToBeExplored)) {
                    pointsToBeExploredAtNextStep.addAll(pointToBeExplored.cardinalPoints());
                    exploredPoints.add(pointToBeExplored);
                }
            }
            pointsToBeExplored = pointsToBeExploredAtNextStep;
        }
        return exploredPoints;
    }

    private boolean outsideTheOuterBox(Point3D point3D) {
        return point3D.getX() > maxPoint.getX() + 1
                || point3D.getY() > maxPoint.getY() + 1
                || point3D.getZ() > maxPoint.getZ() + 1
                || point3D.getX() < minPoint.getX() - 1
                || point3D.getY() < minPoint.getY() - 1
                || point3D.getZ() < minPoint.getZ() - 1;
    }

    // This method get the negative of a set of Point3D
    // Points3D present will be missing and missing Point3D will be present
    private Set<Point3D> negative(Set<Point3D> toBeNegatived) {
        Set<Point3D> negative = new HashSet<>();
        for (long x = minPoint.getX() - 1; x < maxPoint.getX() + 1; x++) {
            for (long y = minPoint.getY() - 1; y < maxPoint.getY() + 1; y++) {
                for (long z = minPoint.getZ() - 1; z < maxPoint.getZ() + 1; z++) {
                    Point3D currentPoint3D = Point3D.of(x, y, z);
                    if (!toBeNegatived.contains(currentPoint3D)) {
                        negative.add(currentPoint3D);
                    }
                }
            }
        }
        return negative;
    }
}