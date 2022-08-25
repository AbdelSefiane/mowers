package org.lacombe.kata;

public class Rotate implements Command {
    private final RotationDirection direction;

    public Rotate(RotationDirection direction) {
        this.direction = direction;
    }

    public void apply(Mower delegate) {
        delegate.rotate(this.direction);
    }

    public static Command of(RotationDirection direction){
        return new Rotate(direction);
    }
}
