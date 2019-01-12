package br.com.elo7.rover.domain.model;

import br.com.elo7.rover.domain.exception.InvalidMoveException;
import br.com.elo7.rover.domain.exception.InvalidPositionException;

import java.util.Arrays;
import java.util.Objects;

/**
 * Rover movementChar.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public enum Movement {

    LEFT('L') {
        @Override
        public Rover move(Rover position, Mars bounds) {
            return validatePosition(Rover.of(
                    position.getX(),
                    position.getY(),
                    position.getDirection().getLeft()),
                    bounds);
        }
    },
    RIGHT('R') {
        @Override
        public Rover move(Rover position, Mars bounds) {
            return validatePosition(Rover.of(
                    position.getX(),
                    position.getY(),
                    position.getDirection().getRight()),
                    bounds);
        }
    },
    MOVE('M') {
        @Override
        public Rover move(Rover position, Mars bounds) throws InvalidPositionException {
            return validatePosition(Rover.of(
                    position.getX() + position.getDirection().getX(),
                    position.getY() + position.getDirection().getY(),
                    position.getDirection()),
                    bounds);
        }
    };

    private final char movementChar;

    Movement(char movementChar) {
        this.movementChar = movementChar;
    }

    public static Movement of(char movementChar) throws InvalidMoveException {
        return Arrays.stream(Movement.values())
                .filter(movement -> Objects.equals(movementChar, movement.getMovementChar()))
                .findFirst()
                .orElseThrow(() -> new InvalidMoveException(movementChar));
    }

    private static Rover validatePosition(Rover position, Mars bounds) {
        if (position.getX() < bounds.getMinX()
                || position.getX() > bounds.getMaxX()
                || position.getY() < bounds.getMinY()
                || position.getY() > bounds.getMaxY()) {
            throw new InvalidPositionException(position, bounds);
        }

        return position;
    }

    public abstract Rover move(Rover position, Mars bounds) throws InvalidPositionException;

    public char getMovementChar() {
        return movementChar;
    }

    @Override
    public String toString() {
        return String.valueOf(movementChar);
    }
}
