package org.lacombe.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lacombe.kata.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.lacombe.kata.ControlCommand.*;
import static org.lacombe.kata.Direction.E;
import static org.lacombe.kata.Direction.N;

class MowerParserTest {

    @Test
    public void toto() throws IOException, URISyntaxException {
        //GIVEN
        File emptyFile = new File("src/test/resources/InputSingle");
        MowerParser parser = new MowerParser();
        MowerContext ctx = new MowerContext(5, 5, new MowerCommand(List.of(LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, FORWARD)));
        Mower expected = new Mower(ctx, new Location(new Position(1, 2), N));
        //WHEN
        List<Mower> mowers = parser.parseMowerDefinition(emptyFile);
        //THEN
        Assertions.assertEquals(1, mowers.size());
        Assertions.assertEquals(expected, mowers.get(0));
    }

    @Test
    public void titi() throws IOException, URISyntaxException {
        //GIVEN
        File emptyFile = new File("src/test/resources/InputMulti");
        MowerParser parser = new MowerParser();
        MowerContext ctx = new MowerContext(5, 5, new MowerCommand(List.of(LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, FORWARD)));
        MowerContext ctx2 = new MowerContext(5, 5, new MowerCommand(List.of(FORWARD, FORWARD, RIGHT, FORWARD, FORWARD, RIGHT, FORWARD, RIGHT, RIGHT, FORWARD)));
        Mower expected = new Mower(ctx, new Location(new Position(1, 2), N));
        Mower expected2 = new Mower(ctx2, new Location(new Position(3, 3), E));
        //WHEN
        List<Mower> mowers = parser.parseMowerDefinition(emptyFile);
        //THEN
        Assertions.assertEquals(2, mowers.size());
        Assertions.assertEquals(expected, mowers.get(0));
        Assertions.assertEquals(expected2, mowers.get(1));
    }
}