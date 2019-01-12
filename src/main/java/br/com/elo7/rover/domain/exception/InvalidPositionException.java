package br.com.elo7.rover.domain.exception;

import br.com.elo7.rover.domain.model.Mars;
import br.com.elo7.rover.domain.model.Rover;

/**
 * Invalid position exception.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class InvalidPositionException extends RuntimeException {

    private final Rover rover;
    private final Mars mars;

    public InvalidPositionException(Rover rover, Mars mars) {
        this.rover = rover;
        this.mars = mars;
    }

    public Rover getRover() {
        return rover;
    }

    public Mars getMars() {
        return mars;
    }

    @Override
    public String getMessage() {
        return String.format("The %s position is invalid for %s Mars area.", rover, mars);
    }
}
