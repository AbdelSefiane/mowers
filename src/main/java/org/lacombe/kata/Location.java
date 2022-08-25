package org.lacombe.kata;

import java.util.Objects;

public class Location {
    final Position position;
    final Orientation orientation;

    public Location(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Location plotNextLocation(MowerContext context) {
        Position newPosition = context.bound(this.orientation.project(position));
        return new Location(newPosition, orientation);
    }

    public Location rotate(RotationDirection command) {
        return new Location(position, orientation.rotate(command));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(position, location.position) && orientation == location.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }
}
