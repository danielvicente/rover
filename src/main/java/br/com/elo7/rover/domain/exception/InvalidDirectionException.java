package br.com.elo7.rover.domain.exception;

/**
 * Invalid direction exception.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class InvalidDirectionException extends RuntimeException {

    private final char direction;

    public InvalidDirectionException(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    @Override
    public String getMessage() {
        return String.format("'%c' is not a valid direction. Consider using these directions: 'N', 'E', 'W', 'S'", direction);
    }
}
