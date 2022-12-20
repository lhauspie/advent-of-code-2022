package com.lhauspie.adventofcode.day18.model;

import java.util.Objects;
import java.util.Set;

public class Point3D {
    private long x;
    private long y;
    private long z;

    public Point3D(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point3D of(long x, long y, long z) {
        return new Point3D(x, y, z);
    }

    public Point3D up() {
        return new Point3D(this.x, this.y - 1, this.z);
    }

    public Point3D down() {
        return new Point3D(this.x, this.y + 1, this.z);
    }

    public Point3D left() {
        return new Point3D(this.x - 1, this.y, this.z);
    }

    public Point3D right() {
        return new Point3D(this.x + 1, this.y, this.z);
    }

    public Point3D front() {
        return new Point3D(this.x, this.y, this.z - 1);
    }

    public Point3D back() {
        return new Point3D(this.x, this.y, this.z + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D that = (Point3D) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Point3D{x=" + x + ", y=" + y + ", z=" + z + "}";
    }

    public Set<Point3D> cardinalPoints() {
        return Set.of(
                this.up(),
                this.down(),
                this.left(),
                this.right(),
                this.front(),
                this.back()
        );
    }
}
