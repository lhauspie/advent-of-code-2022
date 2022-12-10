package com.lhauspie.adventofcode.model;

public interface Observer<T> {
    void update(T observableValue);
}
