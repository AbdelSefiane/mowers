package org.lacombe.kata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class MowerCommand {
    List<ControlCommand> commands;

    public MowerCommand(List<ControlCommand> commands) {
        this.commands = commands;
    }

    public MowerCommand() {
        this.commands = new ArrayList<>();
    }

    public Iterator<ControlCommand> iterator(){
        return commands.iterator();
    }
}