package org.lacombe.kata;

import java.util.stream.Stream;

public enum ControlCommand {
    FORWARD("A"),
    LEFT("G"),
    RIGHT("D"),

    UNKNOWN("");

    final String label;

    ControlCommand(String label) {
        this.label = label;
    }

    public boolean isTranslation(){
        return FORWARD.equals(this);
    }

    static ControlCommand fromLabel(String label) {
        return Stream.of(values())
                     .filter(e -> e.label.equals(label))
                     .findFirst()
                     .orElseThrow();
    }
}