package br.com.elo7.rover.domain.model;

import java.util.Objects;

/**
 * Define the Rover position.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class Rover {

    private final int x;
    private final int y;
    private final Direction direction;

    private Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static Rover of(int x, int y, Direction direction) {
        return new Rover(x, y, direction);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(x, rover.x)
                && Objects.equals(y, rover.y)
                && Objects.equals(direction, rover.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %s) ", x, y, direction);
    }

    public void validate() {
        if (this.getX() < 0 || this.getY() < 0)
            throw new IllegalArgumentException("Rover cannot be moved to negative positions.");
    }
}
