package org.lacombe.kata;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MowerParser {

    public static final String VALUE_SPLITING_CHAR = " ";

    public List<Mower> parseMowerDefinition(File f) throws IOException {
        try (BufferedReader buf = new BufferedReader(new FileReader(f))) {
            Field field = parseField(buf.readLine());
            return buf.lines()
                      .map(line -> spawnMower(line, field))
                      .collect(Collectors.toList());
        } catch (IOException e) {
            throw e;
        }
    }

    private Mower spawnMower(String mowerDefinition, Field field) {
        String[] s = mowerDefinition.split(VALUE_SPLITING_CHAR);
        Integer initX = Integer.valueOf(s[0]);
        Integer initY = Integer.valueOf(s[1]);
        Direction initDirection = Direction.valueOf(s[2]);
        Location startingPos = new Location(new Position(initX, initY), initDirection);
        MowerCommand commands = new MowerCommand(Stream.of(s[3].split(""))
                                                       .map(ControlCommand::fromLabel)
                                                       .collect(Collectors.toList()));
        MowerContext ctx = new MowerContext(field, commands);
        return new Mower(ctx, startingPos);
    }

    private Field parseField(String fieldDescription) {
        String[] s = fieldDescription.split(VALUE_SPLITING_CHAR);
        Integer sizeX = Integer.valueOf(s[0]);
        Integer sizeY = Integer.valueOf(s[1]);
        return new Field(sizeX, sizeY);
    }

}
