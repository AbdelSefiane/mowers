package org.lacombe.kata;

import java.util.Objects;

public class Position {
    Integer x;
    Integer y;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position p) {
        this.x = p.x.intValue();
        this.y = p.y.intValue();
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

