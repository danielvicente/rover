package br.com.elo7.rover.domain.service;

import br.com.elo7.rover.domain.exception.NoMarsCreatedException;
import br.com.elo7.rover.domain.exception.RoverNotFoundException;
import br.com.elo7.rover.domain.model.Mars;
import br.com.elo7.rover.domain.model.Movement;
import br.com.elo7.rover.domain.model.Rover;
import br.com.elo7.rover.domain.utils.RoverUtils;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Mars services.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
public class MarsService {

    private Mars mars;
    private TreeMap<Integer, Rover> roverMap;

    public MarsService() {
        this.roverMap = new TreeMap<>();
    }

    public Rover move(Integer roverId, List<Movement> movements) {

        if (!this.roverMap.containsKey(roverId)) {
            throw new RoverNotFoundException(roverId);
        }

        Rover rover = this.roverMap.get(roverId);

        for (Movement movement : movements) {
            rover = movement.move(rover, mars);
            rover.validate();
            this.roverMap.put(roverId, rover);
        }

        return rover;
    }

    public Rover loadRover(Rover rover) {

        if (this.roverMap == null) {
            this.roverMap = new TreeMap<>();
        }

        this.roverMap.put(RoverUtils.findNextRoverId(this.roverMap), rover);
        return rover;
    }

    public Mars loadMars(Mars mars) {
        return this.mars = mars;
    }

    public String getAllRovers() {
        StringBuilder sb = new StringBuilder();
        if (this.roverMap.isEmpty()) {
            return "No rovers set yet.";
        }
        this.roverMap.entrySet().forEach(rover -> appendRoverEntry(sb, rover));
        return sb.toString();
    }

    public String getRover(Integer roverId) {
        StringBuilder sb = new StringBuilder();
        if (this.roverMap.isEmpty()) {
            return "Rover not found.";
        }
        Rover rover = this.roverMap.get(roverId);
        sb.append("Rover Id: ").append(roverId).append(" - Current Position and Direction: ").append(rover.toString());
        return sb.toString();
    }

    private StringBuilder appendRoverEntry(StringBuilder sb, Entry<Integer, Rover> rover) {
        return sb.append("Rover Id: ").append(rover.getKey()).append(" - Current Position and Direction: ").append(rover.getValue().toString()).append("<br>");
    }

    public Mars getMars() {
        if (this.mars == null) {
            throw new NoMarsCreatedException();
        }
        return this.mars;
    }
}
