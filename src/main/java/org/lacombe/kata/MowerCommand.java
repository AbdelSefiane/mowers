package org.lacombe.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MowerCommand {
    final List<Command> commands;

    public MowerCommand(List<Command> commands) {
        this.commands = commands;
    }

    public MowerCommand() {
        this.commands = new ArrayList<>();
    }

    public Stream<Command> streamOf(){
        return this.commands.stream();
    }
}