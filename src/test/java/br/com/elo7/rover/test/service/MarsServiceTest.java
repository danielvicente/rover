package br.com.elo7.rover.test.service;

import br.com.elo7.rover.domain.model.Direction;
import br.com.elo7.rover.domain.model.Mars;
import br.com.elo7.rover.domain.model.Movement;
import br.com.elo7.rover.domain.model.Rover;
import br.com.elo7.rover.domain.service.MarsService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

/**
 * Unit testes for mars services.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class MarsServiceTest {

    @Test
    public void moveOneForwardFromLeftBottom() {
        final Rover initialRover = Rover.of(0, 0, Direction.NORTH);
        final MarsService service = new MarsService();
        service.loadMars(Mars.of(0, 5, 0, 5));
        service.loadRover(initialRover);
        Rover finalRover = service.move(0, Collections.singletonList(
                Movement.MOVE
        ));
        Assert.assertEquals(Rover.of(0, 1, Direction.NORTH), finalRover);
    }

}
