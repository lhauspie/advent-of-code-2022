package com.lhauspie.adventofcode.model;

public record Range(int start, int stop) {
    public boolean fullyContains(Range range) {
        return this.start <= range.start && this.stop >= range.stop;
    }

    public boolean overlap(Range range) {
        return this.start <= range.start && range.start <= this.stop
                || this.start <= range.stop && range.stop <= this.stop
                || range.start <= this.start && this.start <= range.stop
                || range.start <= this.stop && this.stop <= range.stop;
    }
}
