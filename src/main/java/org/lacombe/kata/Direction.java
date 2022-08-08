package org.lacombe.kata;

import static org.lacombe.kata.ControlCommand.LEFT;
import static org.lacombe.kata.ControlCommand.RIGHT;

public enum Direction {

    N(new Position(0, 1)),
    E(new Position(1, 0)),
    S(new Position(0, -1)),
    W(new Position(-1, 0));

    Position vector;

    Direction(Position pos) {
        this.vector = pos;
    }

    public boolean isHorizontalMove() {
        return W.equals(this) || E.equals(this);
    }

    public boolean isVerticalMove() {
        return N.equals(this) || S.equals(this);
    }


    public Direction rotate(ControlCommand command) {
        if (RIGHT.equals(command)) {
            return this.rotateRight();
        }
        if (LEFT.equals(command)) {
            return this.rotateLeft();
        }
        throw new RuntimeException("Tried rotation with wrong commmand");
    }

    private Direction rotateRight() {
        Direction rotationResult = N;
        if (N.equals(this)) {
            rotationResult = E;
        } else if (Direction.E.equals(this)) {
            rotationResult = S;
        } else if (S.equals(this)) {
            rotationResult = W;
        } else if (W.equals(this)) {
            rotationResult = N;
        }
        return rotationResult;
    }

    private Direction rotateLeft() {
        Direction rotationResult = N;
        if (N.equals(this)) {
            rotationResult = W;
        } else if (Direction.W.equals(this)) {
            rotationResult = S;
        } else if (S.equals(this)) {
            rotationResult = E;
        } else if (E.equals(this)) {
            rotationResult = N;
        }
        return rotationResult;
    }

    @Override
    public String toString() {
        return this.name();
    }
}