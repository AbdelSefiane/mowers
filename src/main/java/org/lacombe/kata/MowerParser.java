package org.lacombe.kata;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MowerParser {

    public static final String SPLITTER = " ";

    private final CommandFactory commandFactory;

    public MowerParser() {
        this.commandFactory = CommandFactory.getInstance();
    }

    public List<Mower> parseMowerDefinition(File f) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(f))) {
            Field field = parseField(buffer.readLine());
            return buffer.lines()
                         .map(line -> spawnMower(line, field))
                         .collect(Collectors.toList());
        } catch (IOException e) {
            throw new MowerParserException(e);
        }
    }

    private Mower spawnMower(String mowerDefinition, Field field) {
        String[] splittedDefinition = mowerDefinition.split(SPLITTER);
        Location startingPos = locationOf(splittedDefinition);
        MowerContext ctx = contextOf(field, splittedDefinition);
        return new Mower(ctx, startingPos);
    }

    private Location locationOf(String[] splittedDefinition) {
        Integer startingX = Integer.valueOf(splittedDefinition[0]);
        Integer startingY = Integer.valueOf(splittedDefinition[1]);
        Orientation startingOrientation = Orientation.valueOf(splittedDefinition[2]);
        return new Location(new Position(startingX, startingY), startingOrientation);
    }

    private MowerContext contextOf(Field field, String[] splittedDefinition) {
        MowerCommand commands = new MowerCommand(commandListOf(splittedDefinition));
        return new MowerContext(field, commands);
    }

    private List<Command> commandListOf(String[] splittedDefinition) {
        return Stream.of(splittedDefinition[3].split(""))
                     .map(commandFactory::off)
                     .filter(optCmd -> optCmd.isPresent())
                     .map(cmd -> cmd.get())
                     .toList();
    }

    private Field parseField(String fieldDescription) {
        String[] s = fieldDescription.split(SPLITTER);
        Integer sizeX = Integer.valueOf(s[0]);
        Integer sizeY = Integer.valueOf(s[1]);
        return new Field(sizeX, sizeY);
    }

}
