package br.com.elo7.rover.test.model;

import br.com.elo7.rover.domain.model.Direction;
import br.com.elo7.rover.domain.model.Rover;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit testes for rover rover.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class RoverTest {

    @Test
    public void setRover() {
        final Rover rover = Rover.of(5, 10, Direction.NORTH);
        Assert.assertEquals(5, rover.getX());
        Assert.assertEquals(10, rover.getY());
        Assert.assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIllegalArgumentException() {
        final Rover rover = Rover.of(-1, -1, Direction.EAST);
        rover.validate();
    }

    @Test
    public void RoverToString() {
        final Rover rover = Rover.of(0, 5, Direction.NORTH);
        Assert.assertEquals("(0, 5, N)", rover.toString().trim());
    }

    @Test
    public void roverEqualsRover() {
        final Rover rover1 = Rover.of(0, 0, Direction.NORTH);
        final Rover rover2 = Rover.of(0, 0, Direction.NORTH);
        Assert.assertEquals(rover1, rover2);
        Assert.assertEquals(rover1.hashCode(), rover2.hashCode());
    }
}
