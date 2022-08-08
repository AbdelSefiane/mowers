package org.lacombe.kata;

import java.util.Objects;

public
class Location {
    Position pos;
    Direction facingDirection;

    public Location(Position pos, Direction facingDirection) {
        this.pos = pos;
        this.facingDirection = facingDirection;
    }

    public Location(Location location) {
        this.pos = new Position(location.pos);
        this.facingDirection = location.facingDirection;
    }

    /**
     * Given a context, project the current Position using
     * the facing direction.
     * The projection is bounded by the given context
     * If the projection result in an unavailable position
     * return the current position
     *
     * @param context
     * @return the projected Position if reachable otherwise the plotted position
     *          is the current one.
     */
    public Position plotNextPosition(MowerContext context) {
        int newX = this.pos.x;
        int newY = this.pos.y;
        if (facingDirection.isVerticalMove()) {
            newY = this.pos.y + this.facingDirection.vector.y;
        }
        if (facingDirection.isHorizontalMove()) {
            newX = this.pos.x + this.facingDirection.vector.x;
        }
        Position output = new Position(newX, newY);
        if (!context.isAvailablePos(output)) {
            return this.pos;
        }
        return output;
    }

    /**
     * Apply a rotation to the current direction.
     * The rotation may be clockwise or counterclockwise
     * depending on the passed command.
     *
     * @param command
     * @return the resulting direction
     */
    public Direction rotate(ControlCommand command) {
        return facingDirection.rotate(command);
    }

    public Position currentPos() {
        return pos;
    }

    public Direction currentDir() {
        return facingDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(pos, location.pos) && facingDirection == location.facingDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, facingDirection);
    }
}
