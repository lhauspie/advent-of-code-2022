package com.lhauspie.adventofcode.day16.model;

import java.util.ArrayList;
import java.util.List;

public class PipesNetwork {

    private static List<Valve> allValves;

    public static long getMostPressure(Valve from, int timeLeft) {
        allValves = new ArrayList<>();
        exploreAllNeighbours(from, allValves);
        return internalGetMostPressure(from, timeLeft);
    }

    private static boolean allValvesHasBeenOpened() {
        return allValves.stream().allMatch(valve -> valve.isOpen());
    }

    private static void exploreAllNeighbours(Valve from, List<Valve> allValves) {
        if (!allValves.contains(from)) {
            allValves.add(from);
            for (Valve neighbour : from.getNeighbours()) {
                exploreAllNeighbours(neighbour, allValves);
            }
        }
    }

    public static long internalGetMostPressure(Valve from, int timeLeft) {
        if (allValvesHasBeenOpened()) {
            return 0;
        }
        if (timeLeft <= 1) {
            return 0;
        }

        Valve currentValve = from;

        long mostPressureAfterOpeningCurrentValve = 0;
        if (currentValve.isClosed()) {
            // If the valve is already opened, it means I already opened it,
            // so don't touch it, and only explore the path without touching the valve
            currentValve.open();
            mostPressureAfterOpeningCurrentValve = getMostPressureAfterCurrentValve(from, timeLeft - 1)  + currentValve.getFlowRate() * (timeLeft - 1);
            currentValve.close();
        }

        // evaluate most pressure without touching the valve
        long mostPressureWithoutTouchingCurrentValve = getMostPressureAfterCurrentValve(from, timeLeft);

        // if I have a better score without touching the valve, lets continue
        if (mostPressureWithoutTouchingCurrentValve > mostPressureAfterOpeningCurrentValve) {
            return mostPressureWithoutTouchingCurrentValve;
        } else {
            return mostPressureAfterOpeningCurrentValve;
        }

//        for (int currentTime = 1; currentTime <= duration; currentTime++) {
//            if (currentValve.isClosed() && currentValve.getFlowRate() != 0) {
//                currentValve.open();
//                timeLeft--;
//                pressure += currentValve.getFlowRate() * timeLeft;
//            }
//            for (Valve valve : currentValve.getNeighbours()) {
//                currentValve = valve;
//            }
//            timeLeft--;
//        }
//        return pressure;
    }

    private static long getMostPressureAfterCurrentValve(Valve currentValve, int timeLeft) {
        int pressure = 0;
        for (Valve nextValve : currentValve.getNeighbours()) {
            pressure += getMostPressure(nextValve, timeLeft - 1);
        }
        return pressure;
    }
}
