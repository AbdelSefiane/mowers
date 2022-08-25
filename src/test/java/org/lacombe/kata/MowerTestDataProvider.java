package org.lacombe.kata;

import java.util.List;

import static org.lacombe.kata.Orientation.E;
import static org.lacombe.kata.Orientation.N;
import static org.lacombe.kata.RotationDirection.LEFT;
import static org.lacombe.kata.RotationDirection.RIGHT;

class MowerTestDataProvider {
    public static final int BASIC_WIDTH = 5;
    public static final int BASIC_LENGTH = 5;

    //scenario 1
    public static final MowerContext scenario1Ctx = new MowerContext(BASIC_WIDTH, BASIC_LENGTH, new MowerCommand(
            List.of(Rotate.of(LEFT), new Translate(), Rotate.of(LEFT), new Translate(), Rotate.of(LEFT),
                    new Translate(), Rotate.of(LEFT), new Translate(), new Translate())));
    public static final Location scenario1BeginLocation = new Location(new Position(1, 2), N);
    public static final Location scenario1ExpectedLocation = new Location(new Position(1, 3), N);

    //scenario 2
    public static final MowerContext scenario2Ctx = new MowerContext(BASIC_WIDTH, BASIC_LENGTH, new MowerCommand(
            List.of(new Translate(), new Translate(), Rotate.of(RIGHT), new Translate(), new Translate(),
                    Rotate.of(RIGHT), new Translate(), Rotate.of(RIGHT), Rotate.of(RIGHT), new Translate())));
    public static final Location scenario2BeginLocation = new Location(new Position(3, 3), E);
    public static final Location scenario2ExpectedLocation = new Location(new Position(5, 1), E);
    public static final Position safeStartingPosition = new Position(1, 1);
}
