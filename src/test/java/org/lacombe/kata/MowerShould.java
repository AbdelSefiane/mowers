package org.lacombe.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.lacombe.kata.MowerTestDataProvider.*;
import static org.lacombe.kata.Orientation.*;
import static org.lacombe.kata.RotationDirection.LEFT;
import static org.lacombe.kata.RotationDirection.RIGHT;


class MowerShould {

    @ParameterizedTest
    @MethodSource(value = "providerTranslation")
    void translateFromStartingOrientation(Position finalPos, Orientation beginOrientation) {
        MowerContext ctx = basicContextWithCommands(new MowerCommand(List.of(new Translate())));
        Location startLoc = new Location(safeStartingPosition, beginOrientation);
        Mower mower = new Mower(ctx, startLoc);
        Location expectedLocation = new Location(finalPos, beginOrientation);

        mower.move();

        Assertions.assertEquals(expectedLocation, mower.location);
    }

    @ParameterizedTest
    @MethodSource(value = "providerRotation")
    void rotateFromStartingOrientation(Orientation beginOrientation, Orientation endOrientation, List<Command> cmd) {
        MowerContext ctx = basicContextWithCommands(new MowerCommand(cmd));
        Location startLoc = new Location(safeStartingPosition, beginOrientation);
        Mower mower = new Mower(ctx, startLoc);
        Location expectedLocation = new Location(safeStartingPosition, endOrientation);

        mower.move();

        Assertions.assertEquals(expectedLocation, mower.location);
    }

    public static Stream<Arguments> providerTranslation() {
        return Stream.of(Arguments.of(new Position(1, 0), S),
                         Arguments.of(new Position(1, 2), N),
                         Arguments.of(new Position(2, 1), E),
                         Arguments.of(new Position(0, 1), W));
    }

    public static Stream<Arguments> providerRotation() {
        List<Command> right = List.of(Rotate.of(RIGHT));
        List<Command> left = List.of(Rotate.of(LEFT));
        return Stream.of(Arguments.of(S, E, left),
                         Arguments.of(N, W, left),
                         Arguments.of(E, N, left),
                         Arguments.of(W, S, left),
                         Arguments.of(S, W, right),
                         Arguments.of(N, E, right),
                         Arguments.of(E, S, right),
                         Arguments.of(W, N, right));
    }

    @Test
    void scenario1() {
        Mower mower = new Mower(scenario1Ctx, scenario1BeginLocation);
        System.out.print(mower + " - ");

        mower.move();

        System.out.println(mower);
        Assertions.assertEquals(scenario1ExpectedLocation, mower.location);
    }

    @Test
    void scenario2() {
        Mower mower = new Mower(scenario2Ctx, scenario2BeginLocation);
        System.out.print(mower + " - ");

        mower.move();

        System.out.println(mower);
        Assertions.assertEquals(scenario2ExpectedLocation, mower.location);
    }

    MowerContext basicContextWithCommands(MowerCommand cmds) {
        return new MowerContext(BASIC_WIDTH, BASIC_LENGTH, cmds);
    }

}