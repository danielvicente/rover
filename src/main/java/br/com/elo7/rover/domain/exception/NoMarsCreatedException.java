package br.com.elo7.rover.domain.exception;

public class NoMarsCreatedException extends RuntimeException {

    public NoMarsCreatedException() {
    }

    @Override
    public String getMessage() {
        return "No mars territory was created so far. You should create one using load service '/mars/load/maxX={maxX}/maxY={maxY}'.";
    }
}
