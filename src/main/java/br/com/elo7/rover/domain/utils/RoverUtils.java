package br.com.elo7.rover.domain.utils;

import br.com.elo7.rover.domain.exception.InvalidPositionException;
import br.com.elo7.rover.domain.model.Mars;
import br.com.elo7.rover.domain.model.Rover;

import java.util.TreeMap;

public class RoverUtils {

    private RoverUtils() {
        // Empty
    }

    public static Integer findNextRoverId(TreeMap<Integer, Rover> roverMap) {
        return roverMap.isEmpty() ? 0 : roverMap.lastKey() + 1;
    }

    public static void validateLimits(Rover rover, Mars mars) {
        if (rover.getX() < mars.getMinX() || rover.getX() > mars.getMaxX()
                || rover.getY() < mars.getMinY() || rover.getY() > mars.getMaxY()) {
            throw new InvalidPositionException(rover, mars);
        }
    }

}
