package com.lhauspie.adventofcode.model;

public class Divisible {
    private Long divisor;

    public Divisible(Long divisor) {
        this.divisor = divisor;
    }

    public boolean isDivisible(Long n) {
        return n % divisor == 0;
    }

    public Long getDivisor() {
        return divisor;
    }
}
