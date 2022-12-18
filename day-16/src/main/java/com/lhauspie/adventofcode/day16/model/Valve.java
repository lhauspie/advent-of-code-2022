package com.lhauspie.adventofcode.day16.model;

import java.util.ArrayList;
import java.util.List;

public class Valve {
    private String name;
    private long flowRate;
    private List<Valve> neighbours = new ArrayList<>();

    public Valve(String name, long flowRate) {
        this.name = name;
        this.flowRate = flowRate;
    }

    public void addNeighbour(Valve v2) {
        neighbours.add(v2);
    }



    private boolean open = false;
    public void open() {
        this.open = true;
    }
    public void close() {
        this.open = false;
    }
    public boolean isClosed() {
        return !open;
    }

    public long getFlowRate() {
        return flowRate;
    }

    public List<Valve> getNeighbours() {
        return neighbours;
    }

    public boolean isOpen() {
        return open;
    }
//
//    public long getTotalPressureReleased(int currentTime) {
//        return open ? flowRate * (currentTime - openTime) : 0;
//    }
}
