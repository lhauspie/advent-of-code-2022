package com.lhauspie.adventofcode.model;

import java.util.ArrayList;
import java.util.List;

public class RopeNode implements Observer<RopeNode> {
    private Position position;
    private List<Observer> observers = new ArrayList<Observer>();

    public RopeNode(Position position) {
        this.position = position;
    }

    public void addObserver(RopeNode node) {
        observers.add(node);
    }

    private void updateObservers() {
        observers.stream().forEach(observer -> observer.update(this));
    }

    public Position getPosition() {
        return position;
    }

    public void moveUp() {
        position = position.up();
        updateObservers();
    }

    public void moveDown() {
        position = position.down();
        updateObservers();
    }

    public void moveRight() {
        position = position.right();
        updateObservers();
    }

    public void moveLeft() {
        position = position.left();
        updateObservers();
    }

    @Override
    // This method is called from the observed node (the relative head)
    public void update(RopeNode observedNode) {
        if (tooFarDownFromMe(observedNode) && toFarLeftFromMe(observedNode)) {
            this.position = observedNode.getPosition().up().right();
        } else if (tooFarDownFromMe(observedNode) && tooFarRightFromMe(observedNode)) {
            this.position = observedNode.getPosition().up().left();
        } else if (tooFarUpFromMe(observedNode) && tooFarRightFromMe(observedNode)) {
            this.position = observedNode.getPosition().down().left();
        } else if (tooFarUpFromMe(observedNode) && toFarLeftFromMe(observedNode)) {
            this.position = observedNode.getPosition().down().right();
        } else if (tooFarDownFromMe(observedNode)) {
            this.position = observedNode.getPosition().up();
        } else if (tooFarUpFromMe(observedNode)) {
            this.position = observedNode.getPosition().down();
        } else if (toFarLeftFromMe(observedNode)) {
            this.position = observedNode.getPosition().right();
        } else if (tooFarRightFromMe(observedNode)) {
            this.position = observedNode.getPosition().left();
        }
        updateObservers();
    }

    private boolean tooFarDownFromMe(RopeNode observedNode) {
        return position.getY() == observedNode.getPosition().getY() + 2;
    }

    private boolean tooFarUpFromMe(RopeNode observedNode) {
        return position.getY() == observedNode.getPosition().getY() - 2;
    }

    private boolean toFarLeftFromMe(RopeNode observedNode) {
        return position.getX() == observedNode.getPosition().getX() + 2;
    }

    private boolean tooFarRightFromMe(RopeNode observedNode) {
        return position.getX() == observedNode.getPosition().getX() - 2;
    }
}
