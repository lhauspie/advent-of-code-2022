package com.lhauspie.adventofcode.model;

import java.util.*;

public class Ship {

    private Map<Position, Stack<MarkedCrate>> stacks = new HashMap<>();

    public void store(MarkedCrate crate, Position position) {
        getStack(position).push(crate);
    }

    public MarkedCrate take(Position from) {
        return getStack(from).pop();
    }

    private Stack<MarkedCrate> getStack(Position position) {
        Stack<MarkedCrate> stack = stacks.get(position);
        if (stack == null) {
            stack = new Stack<>();
            stacks.put(position, stack);
        }
        return stack;
    }

    public List<MarkedCrate> getCratesOnTopOfEachStack() {
        List<MarkedCrate> crates = new ArrayList<>();
        for (int i = 1; i <= stacks.size(); i++) {
            crates.add(stacks.get(Position.of(i)).peek());
        }
        return crates;
    }
}
