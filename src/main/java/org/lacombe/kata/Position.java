package org.lacombe.kata;

import java.util.Objects;

public class Position {
    final Integer x;
    final Integer y;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Position add(Position position) {
        return new Position(this.x + position.x, this.y + position.y);
    }

    @Override
    public String toString() {
        return "Position{" + x +
                "," + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) && Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}

