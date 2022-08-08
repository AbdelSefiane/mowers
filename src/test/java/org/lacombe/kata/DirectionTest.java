package org.lacombe.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.lacombe.kata.ControlCommand;
import org.lacombe.kata.Direction;
import org.lacombe.kata.Position;

import java.util.stream.Stream;

import static org.lacombe.kata.ControlCommand.LEFT;
import static org.lacombe.kata.ControlCommand.RIGHT;
import static org.lacombe.kata.Direction.*;

public class DirectionTest {

    public static Stream<Arguments> rightRotationCases() {
        return Stream.of(Arguments.of(N, E),
                Arguments.of(E, S),
                Arguments.of(S, W),
                Arguments.of(W, N)
        );
    }

    public static Stream<Arguments> leftRotationCases() {
        return Stream.of(Arguments.of(N, W),
                Arguments.of(W, S),
                Arguments.of(S, E),
                Arguments.of(E, N)
        );
    }

    //ROTATE RIGHT
    @ParameterizedTest
    @MethodSource("rightRotationCases")
    public void rightRotationShouldTurnMowerToExpectedDirection(Direction begin, Direction end) {
        Direction output = begin.rotate(RIGHT);
        Assertions.assertEquals(end, output);
    }

    //ROTATE LEFT
    @ParameterizedTest
    @MethodSource("leftRotationCases")
    public void leftRotationShouldTurnMowerToExpectedDirection(Direction begin, Direction end) {
        Direction output = begin.rotate(LEFT);
        Assertions.assertEquals(end, output);
    }
}
