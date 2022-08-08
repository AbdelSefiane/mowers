package org.lacombe.kata;

import java.util.List;

import static org.lacombe.kata.ControlCommand.*;
import static org.lacombe.kata.Direction.E;
import static org.lacombe.kata.Direction.N;

class MowerTestDataProvider{
    public static final int BASIC_WIDTH = 5;
    public static final int BASIC_LENGTH = 5;

    //scneario 1
    public static final MowerContext scenario1Ctx = new MowerContext(BASIC_WIDTH, BASIC_LENGTH, new MowerCommand(
            List.of(LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, FORWARD)));
    public static final Location scenario1BeginLocation = new Location(new Position(1, 2), N);
    public static final Location scenario1ExpectedLocation = new Location(new Position(1, 3), N);

    //scenario 2
    public static final MowerContext scenario2Ctx = new MowerContext(BASIC_WIDTH, BASIC_LENGTH, new MowerCommand(
            List.of(FORWARD, FORWARD, RIGHT, FORWARD, FORWARD, RIGHT, FORWARD, RIGHT, RIGHT, FORWARD)));
    public static final Location scenario2BeginLocation = new Location(new Position(3, 3), E);
    public static final Location scenario2ExpectedLocation = new Location(new Position(5, 1), E);
    public static final Position safeStartingPosition = new Position(1, 1);
}
