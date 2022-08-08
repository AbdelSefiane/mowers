package org.lacombe.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.lacombe.kata.Direction.*;

class LocationTest {

    MowerContext context = new MowerContext(5, 5);
    static final Position bottomLeftCorner = new Position(0, 0);
    static final Position topRightCorner = new Position(5, 5);

    public static Stream<Arguments> sourcePlotNextPositionNotBlocked() {
        return Stream.of(Arguments.of(N, new Position(1, 2)),
                Arguments.of(S, new Position(1, 0)),
                Arguments.of(E, new Position(2, 1)),
                Arguments.of(W, new Position(0, 1)));
    }

    public static Stream<Arguments> sourcePlotNextPositionBlocked() {
        return Stream.of(Arguments.of(S, bottomLeftCorner),
                Arguments.of(W, bottomLeftCorner),
                Arguments.of(N, topRightCorner),
                Arguments.of(E, topRightCorner));
    }

    @ParameterizedTest
    @MethodSource(value = "sourcePlotNextPositionNotBlocked")
    void plotNextPositionShouldApplyDirectionVectorToCurrentPositionNotBlocked(Direction direction, Position expected) {
        Position begin = new Position(1, 1);
        Location loc = new Location(begin, direction);
        Position nextPosition = loc.plotNextPosition(context);
        Assertions.assertEquals(expected, nextPosition);
        Assertions.assertNotEquals(begin, expected);
    }

    @ParameterizedTest
    @MethodSource(value = "sourcePlotNextPositionBlocked")
    void plotNextPositionShouldBeBoundByTheMowerContextSize(Direction direction, Position pos) {
        Location loc = new Location(pos, direction);
        Position nextPosition = loc.plotNextPosition(context);
        Assertions.assertEquals(pos, nextPosition);
    }

}