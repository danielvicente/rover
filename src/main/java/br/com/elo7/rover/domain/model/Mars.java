package br.com.elo7.rover.domain.model;

import java.util.Objects;

/**
 * Mars min and max definitions.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class Mars {

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    private Mars(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public static Mars of(int minX, int maxX, int minY, int maxY) {
        if (minX > maxX || minY > maxY) {
            throw new IllegalArgumentException("Min cannot be greater than max.");
        }

        if (minX < 0 || minY < 0) {
            throw new IllegalArgumentException("Cannot set min values less than zero.");
        }

        return new Mars(minX, maxX, minY, maxY);
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Mars mars = (Mars) o;
        return Objects.equals(minX, mars.minX) && Objects.equals(maxX, mars.maxX) && Objects.equals(minY, mars.minY)
                && Objects.equals(maxY, mars.maxY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minX, maxX, minY, maxY);
    }

    @Override
    public String toString() {
        return String.format("(%d to %d, %d to %d)", minX, maxX, minY, maxY);
    }

}
