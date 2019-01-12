package br.com.elo7.rover.domain.model;

import br.com.elo7.rover.domain.exception.InvalidDirectionException;

import java.util.Arrays;
import java.util.Objects;

/**
 * Rover direction.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public enum Direction {

    NORTH('N', 0, 1) {
        @Override
        public Direction getLeft() {
            return WEST;
        }

        @Override
        public Direction getRight() {
            return EAST;
        }
    },
    EAST('E', 1, 0) {
        @Override
        public Direction getLeft() {
            return NORTH;
        }

        @Override
        public Direction getRight() {
            return SOUTH;
        }
    },
    SOUTH('S', 0, -1) {
        @Override
        public Direction getLeft() {
            return EAST;
        }

        @Override
        public Direction getRight() {
            return WEST;
        }
    },
    WEST('W', -1, 0) {
        @Override
        public Direction getLeft() {
            return SOUTH;
        }

        @Override
        public Direction getRight() {
            return NORTH;
        }
    };

    private final char directionChar;
    private final int x;
    private final int y;

    Direction(char directionChar, int x, int y) {
        this.directionChar = directionChar;
        this.x = x;
        this.y = y;
    }

    public static Direction of(char directionChar) throws InvalidDirectionException {
        return Arrays.stream(Direction.values())
                .filter(direction -> Objects.equals(directionChar, direction.getDirectionChar()))
                .findFirst()
                .orElseThrow(() -> new InvalidDirectionException(directionChar));
    }

    public abstract Direction getLeft();

    public abstract Direction getRight();

    public char getDirectionChar() {
        return directionChar;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.valueOf(directionChar);
    }
}
