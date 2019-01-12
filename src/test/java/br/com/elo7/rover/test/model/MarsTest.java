package br.com.elo7.rover.test.model;

import br.com.elo7.rover.domain.exception.InvalidPositionException;
import br.com.elo7.rover.domain.model.Direction;
import br.com.elo7.rover.domain.model.Mars;
import br.com.elo7.rover.domain.model.Rover;
import br.com.elo7.rover.domain.utils.RoverUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit testes for mars of area.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class MarsTest {

    @Test
    public void createMars() {
        final Mars mars = Mars.of(0, 20, 0, 25);
        Assert.assertEquals(0, mars.getMinX());
        Assert.assertEquals(20, mars.getMaxX());
        Assert.assertEquals(0, mars.getMinY());
        Assert.assertEquals(25, mars.getMaxY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryNegativeValuesForMars() {
        final Mars mars = Mars.of(-10, -2, -20, -10);
    }

    @Test
    public void marsToString() {
        final Mars mars = Mars.of(0, 5, 0, 5);
        Assert.assertEquals("(0 to 5, 0 to 5)", mars.toString());
    }

    @Test
    public void marsEqualsMars() {
        final Mars mars1 = Mars.of(0, 0, 0, 0);
        final Mars mars2 = Mars.of(0, 0, 0, 0);
        Assert.assertEquals(mars1, mars2);
        Assert.assertEquals(mars1.hashCode(), mars2.hashCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionToXMinMax() {
        Mars.of(1, 0, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionToYMinMax() {
        Mars.of(2, 2, 1, 0);
    }

    @Test(expected = InvalidPositionException.class)
    public void throwsInvalidPositionException() {
        final Mars mars = Mars.of(0, 5, 0, 5);
        final Rover rover = Rover.of(5, 7, Direction.NORTH);
        RoverUtils.validateLimits(rover, mars);
    }
}
