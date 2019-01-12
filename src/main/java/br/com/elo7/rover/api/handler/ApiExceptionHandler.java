package br.com.elo7.rover.api.handler;

import br.com.elo7.rover.domain.exception.InvalidMoveException;
import br.com.elo7.rover.domain.exception.InvalidPositionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Exception handler.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvalidMoveException.class)
    public ResponseEntity<String> handleUnrecognizedMovementException(InvalidMoveException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidPositionException.class)
    public ResponseEntity<String> handlePositionOutOfBoundsException(InvalidPositionException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public void handleNotFoundException() {
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void handleHttpRequestMethodNotSupportedException() {
    }
}
