package org.lacombe.kata;

public interface Command {

    void apply(Mower delegate);
}
