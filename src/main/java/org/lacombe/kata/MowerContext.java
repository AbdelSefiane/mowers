package org.lacombe.kata;

import java.util.Iterator;
import java.util.Objects;

public class MowerContext {
    Field context;
    MowerCommand routine;

    public MowerContext(int width, int length, MowerCommand routine) {
        this.context = new Field(width, length);
        this.routine = routine;
    }

    public MowerContext(Field field, MowerCommand routine) {
        this.context = field;
        this.routine = routine;
    }

    protected MowerContext(int width, int length) {
        this.context = new Field(width, length);
    }

    public Iterator<ControlCommand> commandIterator() {
        return routine.iterator();
    }

    public Boolean isAvailablePos(Position pos) {
        return context.contains(pos);
    }

}
