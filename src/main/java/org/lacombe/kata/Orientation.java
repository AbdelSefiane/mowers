package org.lacombe.kata;

import java.util.List;

import static org.lacombe.kata.RotationDirection.LEFT;
import static org.lacombe.kata.RotationDirection.RIGHT;

public enum Orientation {

    N(new Position(0, 1)),
    E(new Position(1, 0)),
    S(new Position(0, -1)),
    W(new Position(-1, 0));

    public static final List<Orientation> VALUES = List.of(values());
    final Position position;

    Orientation(Position pos) {
        this.position = pos;
    }

    public Orientation rotate(RotationDirection command) {
        int nextOrientation = VALUES.indexOf(this);
        if (RIGHT.equals(command)) {
            nextOrientation += 1;
        }
        if (LEFT.equals(command)) {
            nextOrientation -= 1;
        }
        return rotate(nextOrientation);
    }

    private Orientation rotate(int rotationIndex) {
        if (rotationIndex < 0) {
            return VALUES.get(VALUES.size() - 1);
        }
        if (rotationIndex >= VALUES.size()) {
            return VALUES.get(0);
        }
        return VALUES.get(rotationIndex);
    }

    public Position project(Position position) {
        return this.position.add(position);
    }

    @Override
    public String toString() {
        return this.name();
    }

}