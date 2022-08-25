package org.lacombe.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.lacombe.kata.Orientation.*;

class LocationTest {

    MowerContext context = new MowerContext(5, 5);
    static final Position bottomLeftCorner = new Position(0, 0);
    static final Position topRightCorner = new Position(5, 5);

    public static Stream<Arguments> sourcePlotNextPositionNotBlocked() {
        return Stream.of(Arguments.of(N, new Location(new Position(1, 2), N)),
                         Arguments.of(S, new Location(new Position(1, 0), S)),
                         Arguments.of(E, new Location(new Position(2, 1), E)),
                         Arguments.of(W, new Location(new Position(0, 1), W)));
    }

    public static Stream<Arguments> sourcePlotNextPositionBlocked() {
        return Stream.of(Arguments.of(new Location(bottomLeftCorner, S)),
                         Arguments.of(new Location(bottomLeftCorner, W)),
                         Arguments.of(new Location(topRightCorner, N)),
                         Arguments.of(new Location(topRightCorner, E)));
    }

    @ParameterizedTest
    @MethodSource(value = "sourcePlotNextPositionNotBlocked")
    void plotNextPositionShouldApplyOrientationVectorToCurrentPositionNotBlocked(Orientation orientation, Location expected) {
        Position begin = new Position(1, 1);
        Location loc = new Location(begin, orientation);
        Location nextLocaction = loc.plotNextLocation(context);
        Assertions.assertEquals(expected, nextLocaction);
    }

    @ParameterizedTest
    @MethodSource(value = "sourcePlotNextPositionBlocked")
    void plotNextPositionShouldBeBoundByTheMowerContextSize(Location location) {
        Location nextPosition = location.plotNextLocation(context);
        Assertions.assertEquals(location, nextPosition);
    }

}