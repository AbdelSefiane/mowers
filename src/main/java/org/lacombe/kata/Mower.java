package org.lacombe.kata;

import java.util.Objects;

public class Mower {

    Location location;

    final MowerContext context;

    public Mower(MowerContext context, Location loc) {
        this.location = loc;
        this.context = context;
    }

    public void move() {
        context.command()
               .forEach(command1 -> command1.apply(this));
    }

    protected void translate() {
        this.location = this.location.plotNextLocation(context);
    }

    protected void rotate(RotationDirection direction) {
        this.location = this.location.rotate(direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(location, mower.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, context);
    }

    @Override
    public String toString() {
        return "Mower{" + this.location.position + "," + this.location.orientation + "}";
    }
}
