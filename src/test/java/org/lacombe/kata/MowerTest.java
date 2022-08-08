package org.lacombe.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.lacombe.kata.ControlCommand.*;
import static org.lacombe.kata.Direction.*;
import static org.lacombe.kata.MowerTestDataProvider.*;


class MowerTest {

    @ParameterizedTest
    @MethodSource(value = "providerTranlastion")
    void mowShouldTranslateMowerForwardInStartingDirection(Position finalPos, Direction startDir) {
        MowerContext ctx = basicContextWithCommands(new MowerCommand(List.of(FORWARD)));
        Location startLoc = new Location(safeStartingPosition, startDir);
        Mower mower = new Mower(ctx, startLoc);
        Location expectedLocation = new Location(finalPos, startDir);

        mower.mow();

        Assertions.assertEquals(expectedLocation, mower.location);
    }

    public static Stream<Arguments> providerTranlastion() {
        return Stream.of(Arguments.of(new Position(1, 0), S),
                         Arguments.of(new Position(1, 2), N),
                         Arguments.of(new Position(2, 1), E),
                         Arguments.of(new Position(0, 1), W));
    }

    @ParameterizedTest
    @MethodSource(value = "providerRotationCounterclockwise")
    void mowShouldRotateLeftFromStartingDirection(Direction startDir, Direction endDir) {
        MowerContext ctx = basicContextWithCommands(new MowerCommand(List.of(LEFT)));
        Location startLoc = new Location(safeStartingPosition, startDir);
        Mower mower = new Mower(ctx, startLoc);
        Location expectedLocation = new Location(safeStartingPosition, endDir);


        mower.mow();

        Assertions.assertEquals(expectedLocation, mower.location);
    }

    public static Stream<Arguments> providerRotationCounterclockwise() {
        return Stream.of(Arguments.of(S, E),
                         Arguments.of(N, W),
                         Arguments.of(E, N),
                         Arguments.of(W, S));
    }

    @ParameterizedTest
    @MethodSource(value = "providerRotationClockwise")
    void mowShouldRotateRightFromStartingDirection(Direction startDir, Direction endDir) {
        Location startLoc = new Location(safeStartingPosition, startDir);
        MowerContext ctx = basicContextWithCommands(new MowerCommand(List.of(RIGHT)));
        Mower mower = new Mower(ctx, startLoc);
        Location expectedLocation = new Location(safeStartingPosition, endDir);

        mower.mow();

        Assertions.assertEquals(expectedLocation, mower.location);
    }

    public static Stream<Arguments> providerRotationClockwise() {
        return Stream.of(Arguments.of(S, W),
                         Arguments.of(N, E),
                         Arguments.of(E, S),
                         Arguments.of(W, N));
    }

    @Test
    void scenario1() {
        Mower mower = new Mower(scenario1Ctx, scenario1BeginLocation);
        System.out.print(mower + " - ");

        mower.mow();

        System.out.println(mower);
        Assertions.assertEquals(scenario1ExpectedLocation, mower.location);
    }

    @Test
    void scenario2() {
        Mower mower = new Mower(scenario2Ctx, scenario2BeginLocation);
        System.out.print(mower + " - ");

        mower.mow();

        System.out.println(mower);
        Assertions.assertEquals(scenario2ExpectedLocation, mower.location);
    }

    MowerContext basicContextWithCommands(MowerCommand cmds) {
        return new MowerContext(BASIC_WIDTH, BASIC_LENGTH, cmds);
    }

}