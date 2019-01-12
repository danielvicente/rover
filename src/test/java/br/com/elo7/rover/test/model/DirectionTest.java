package br.com.elo7.rover.test.model;

import br.com.elo7.rover.domain.exception.InvalidDirectionException;
import br.com.elo7.rover.domain.model.Direction;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit testes for rover direction.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class DirectionTest {

    @Test
    public void directionsToString() {
        Assert.assertEquals('N', Direction.NORTH.getDirectionChar());
        Assert.assertEquals("N", Direction.NORTH.toString());
        Assert.assertEquals('E', Direction.EAST.getDirectionChar());
        Assert.assertEquals("E", Direction.EAST.toString());
        Assert.assertEquals('S', Direction.SOUTH.getDirectionChar());
        Assert.assertEquals("S", Direction.SOUTH.toString());
        Assert.assertEquals('W', Direction.WEST.getDirectionChar());
        Assert.assertEquals("W", Direction.WEST.toString());
    }

    @Test
    public void northCoordinatesShouldBe0And1() {
        Assert.assertEquals(0, Direction.NORTH.getX());
        Assert.assertEquals(1, Direction.NORTH.getY());
    }

    @Test
    public void eastCoordinatesShouldBe1And0() {
        Assert.assertEquals(1, Direction.EAST.getX());
        Assert.assertEquals(0, Direction.EAST.getY());
    }

    @Test
    public void northLeftShouldBeWest() {
        Assert.assertEquals(Direction.WEST, Direction.NORTH.getLeft());
    }

    @Test
    public void northRightShouldBeEast() {
        Assert.assertEquals(Direction.EAST, Direction.NORTH.getRight());
    }

    @Test
    public void eastLeftShouldBeNorth() {
        Assert.assertEquals(Direction.NORTH, Direction.EAST.getLeft());
    }

    @Test
    public void eastRightShouldBeSouth() {
        Assert.assertEquals(Direction.SOUTH, Direction.EAST.getRight());
    }

    @Test
    public void southLeftShouldBeEast() {
        Assert.assertEquals(Direction.EAST, Direction.SOUTH.getLeft());
    }

    @Test
    public void southRightShouldBeWest() {
        Assert.assertEquals(Direction.WEST, Direction.SOUTH.getRight());
    }

    @Test
    public void westLeftShouldBeSouth() {
        Assert.assertEquals(Direction.SOUTH, Direction.WEST.getLeft());
    }

    @Test
    public void westRightShouldBeNorth() {
        Assert.assertEquals(Direction.NORTH, Direction.WEST.getRight());
    }

    @Test(expected = InvalidDirectionException.class)
    public void shouldThrowsUnrecognizedDirectionException() {
        Direction.of('A');
    }
}
