package org.lacombe.kata;

import java.util.stream.Stream;

public class MowerContext {
    final Field field;
    final MowerCommand tasks;

    public MowerContext(int width, int length, MowerCommand tasks) {
        this.field = new Field(width, length);
        this.tasks = tasks;
    }

    public MowerContext(Field field, MowerCommand tasks) {
        this.field = field;
        this.tasks = tasks;
    }

    public MowerContext(int width, int height) {
        this.field = new Field(width, height);
        this.tasks = new MowerCommand();
    }

    public Stream<Command> command() {
        return tasks.streamOf();
    }

    public Position bound(Position newPosition) {
        int newX = newPosition.x;
        int newY = newPosition.y;
        if (newX < 0) {
            newX = 0;
        }
        if (newX >= field.width) {
            newX = field.width;
        }
        if (newY >= field.height) {
            newY = field.height;
        }
        if (newY < 0) {
            newY = 0;
        }
        return new Position(newX, newY);
    }

}
