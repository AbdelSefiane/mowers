package org.lacombe.kata;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class CommandFactory {

    private static CommandFactory instance;

    private CommandFactory() {

    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Optional<Command> off(String cmd) {
        if (cmd.equals("A")) {
            return ofNullable(new Translate());
        }
        if (cmd.equals("G") || cmd.equals("D")) {
            return ofNullable(new Rotate(RotationDirection.fromLabel(cmd)));
        }
        return empty();
    }
    public Command of(String cmd) {
        Command output = null;
        if (cmd.equals("A")) {
            output = new Translate();
        }
        if (cmd.equals("G") || cmd.equals("D")) {
            output = new Rotate(RotationDirection.fromLabel(cmd));
        }
        return output;
    }
}
