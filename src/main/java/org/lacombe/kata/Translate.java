package org.lacombe.kata;

public class Translate implements Command {
    public void apply(Mower delegate) {
        delegate.translate();
    }

}
