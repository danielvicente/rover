package br.com.elo7.rover.domain.exception;

/**
 * Invalid move exception.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class InvalidMoveException extends RuntimeException {

    private final char movement;

    public InvalidMoveException(char movement) {
        this.movement = movement;
    }

    public char getMovement() {
        return movement;
    }

    @Override
    public String getMessage() {
        return String.format("'%c' is not a valid movement. Consider using 'L','R' and 'M'.", movement);
    }
}
