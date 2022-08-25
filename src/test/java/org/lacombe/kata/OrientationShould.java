package org.lacombe.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.lacombe.kata.Orientation.*;
import static org.lacombe.kata.RotationDirection.LEFT;
import static org.lacombe.kata.RotationDirection.RIGHT;

public class OrientationShould {

    public static Stream<Arguments> rotationCases() {
        return Stream.of(Arguments.of(N, E, RIGHT),
                         Arguments.of(E, S, RIGHT),
                         Arguments.of(S, W, RIGHT),
                         Arguments.of(W, N, RIGHT),
                         Arguments.of(N, W, LEFT),
                         Arguments.of(W, S, LEFT),
                         Arguments.of(S, E, LEFT),
                         Arguments.of(E, N, LEFT)
        );
    }

    @ParameterizedTest
    @MethodSource("rotationCases")
    public void rotateToExpectedOrientation(Orientation begin, Orientation end, RotationDirection direction) {
        Orientation rightOutput = begin.rotate(direction);
        Assertions.assertEquals(end, rightOutput);
    }

}
