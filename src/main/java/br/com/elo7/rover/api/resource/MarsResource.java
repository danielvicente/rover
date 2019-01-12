package br.com.elo7.rover.api.resource;

import br.com.elo7.rover.domain.model.Direction;
import br.com.elo7.rover.domain.model.Mars;
import br.com.elo7.rover.domain.model.Movement;
import br.com.elo7.rover.domain.model.Rover;
import br.com.elo7.rover.domain.service.MarsService;
import br.com.elo7.rover.domain.utils.RoverUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mars resources.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
@RestController
@RequestMapping("/")
public class MarsResource {

    private final MarsService marsService;

    @Autowired
    public MarsResource(MarsService marsService) {
        this.marsService = marsService;
    }

    @PostMapping(path = "/mars/load/maxX={maxX}/maxY={maxY}")
    public ResponseEntity<String> loadMars(@PathVariable("maxX") int maxX, @PathVariable("maxY") int maxY) {
        Mars mars = Mars.of(0, maxX, 0, maxY);
        return ResponseEntity.ok(String.valueOf(marsService.loadMars(mars)));
    }

    @PostMapping(path = "/rover/load/coordinateX={coordinateX}/coordinateY={coordinateY}/direction={direction}")
    public ResponseEntity<String> loadRover(@PathVariable("coordinateX") int x, @PathVariable("coordinateY") int y,
                                            @PathVariable("direction") char direction) {
        Rover rover = Rover.of(x, y, Direction.of(direction));
        RoverUtils.validateLimits(rover, marsService.getMars());
        return ResponseEntity.ok(String.valueOf(marsService.loadRover(rover)));
    }

    @PostMapping(path = "/rover/move/{roverId}={command}")
    public ResponseEntity<String> moveRover(@PathVariable("roverId") Integer roverId,
                                            @PathVariable("command") String command) {
        final List<Movement> movements = command.chars().mapToObj(character -> (char) character).map(Movement::of)
                .collect(Collectors.toList());
        return ResponseEntity.ok(String.valueOf(marsService.move(roverId, movements)));
    }

    @GetMapping(path = "/rover/findAllRovers")
    public ResponseEntity<String> findAllRovers() {
        return ResponseEntity.ok(marsService.getAllRovers());
    }

    @GetMapping(path = "/rover/findRover={roverId}")
    public ResponseEntity<String> findRover(@PathVariable("roverId") int roverId) {
        return ResponseEntity.ok(marsService.getRover(roverId));
    }

}
