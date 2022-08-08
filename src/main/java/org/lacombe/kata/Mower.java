package org.lacombe.kata;

import java.util.Iterator;
import java.util.Objects;

public class Mower {

    Location location;

    MowerContext context;

    public Mower(MowerContext context, Location loc) {
        this.location = loc;
        this.context = context;
    }

    /**
     * Side effect function, consumes the tasks described in the MowerContext
     * If any command result in an unexpected behavior, apply none
     * returns the final destination reached by the mower after all transformations applied
     *
     * @return
     */
    public void mow() {
        Location finalLocation = new Location(location);
        Iterator<ControlCommand> iterator = context.commandIterator();
        while (iterator.hasNext()) {
            finalLocation = consumeCommand(iterator.next(), finalLocation);
        }
        this.location = finalLocation;
    }

    /**
     * Apply the given command to the given location
     * The applied transformation is bounded by the Mowers context
     * Returns the new location reached.
     *
     * @param currentCommand
     * @param loc
     * @return
     */
    private Location consumeCommand(ControlCommand currentCommand, Location loc) {
        Position finalPosition = loc.currentPos();
        Direction finalDirection = loc.currentDir();
        if (currentCommand.isTranslation()) {
            finalPosition = loc.plotNextPosition(context);
        } else {
            finalDirection = loc.rotate(currentCommand);
        }
        return new Location(finalPosition, finalDirection);
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
        return "Mower{" + this.location.pos + "," + this.location.facingDirection + "}";
    }
}
