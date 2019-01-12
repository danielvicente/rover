package br.com.elo7.rover.domain.exception;

/**
 * Rover not found exception.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class RoverNotFoundException extends RuntimeException {

    private final Integer roverId;

    public RoverNotFoundException(Integer roverId) {
        this.roverId = roverId;
    }

    public Integer getRoverId() {
        return roverId;
    }

    @Override
    public String getMessage() {
        return String.format("'%s' Rover not found.", roverId);
    }
}
