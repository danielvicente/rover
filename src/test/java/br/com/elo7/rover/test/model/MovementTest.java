package br.com.elo7.rover.test.model;

import br.com.elo7.rover.domain.exception.InvalidMoveException;
import br.com.elo7.rover.domain.exception.InvalidPositionException;
import br.com.elo7.rover.domain.model.Direction;
import br.com.elo7.rover.domain.model.Mars;
import br.com.elo7.rover.domain.model.Movement;
import br.com.elo7.rover.domain.model.Rover;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit testes for rover movement.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class MovementTest {

    @Test
    public void movementsToString() {
        Assert.assertEquals('L', Movement.LEFT.getMovementChar());
        Assert.assertEquals("L", Movement.LEFT.toString());
        Assert.assertEquals('R', Movement.RIGHT.getMovementChar());
        Assert.assertEquals("R", Movement.RIGHT.toString());
        Assert.assertEquals('M', Movement.MOVE.getMovementChar());
        Assert.assertEquals("M", Movement.MOVE.toString());
    }

    @Test(expected = InvalidMoveException.class)
    public void shouldThrowsUnrecognizedMovementException() {
        Movement.of('A');
    }

    @Test
    public void shouldMoveToLeftFromNorth() {
        final Rover rover = Movement.LEFT.move(Rover.of(0, 0, Direction.NORTH), Mars.of(0, 1, 0, 1));
        Assert.assertEquals(Rover.of(0, 0, Direction.WEST), rover);
    }

    @Test
    public void shouldMoveToRightFromEast() {
        final Rover rover = Movement.RIGHT.move(Rover.of(7, 9, Direction.EAST), Mars.of(0, 7, 0, 9));
        Assert.assertEquals(Rover.of(7, 9, Direction.SOUTH), rover);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryMoveForwardFromEastWithNegativeCoordinates() {
        final Rover rover = Movement.MOVE.move(Rover.of(-5, -10, Direction.EAST), Mars.of(-5, 0, -10, 0));
        Assert.assertEquals(Rover.of(-4, -10, Direction.EAST), rover);
    }

    @Test(expected = InvalidPositionException.class)
    public void shouldThrowsroverOutOfBoundsExceptionWhenMoveToLeftFromNorth() {
        final Mars mars = Mars.of(0, 5, 0, 5);
        Movement.LEFT.move(Rover.of(0, 6, Direction.NORTH), mars);
    }
}
