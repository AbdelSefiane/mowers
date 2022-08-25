package org.lacombe.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.lacombe.kata.MowerTestDataProvider.scenario1Ctx;
import static org.lacombe.kata.MowerTestDataProvider.scenario2Ctx;
import static org.lacombe.kata.Orientation.E;
import static org.lacombe.kata.Orientation.N;
class MowerParserShould {

    public static final MowerParser PARSER = new MowerParser();

    @Test
    public void parseSingleMowerDefinition() {
        File emptyFile = new File("src/test/resources/InputSingle");
        Mower expected = new Mower(scenario1Ctx, new Location(new Position(1, 2), N));

        List<Mower> mowers = PARSER.parseMowerDefinition(emptyFile);

        Assertions.assertEquals(1, mowers.size());
        Assertions.assertEquals(expected, mowers.get(0));
    }

    @Test
    public void parseMultipleMowerDefinition() {
        File emptyFile = new File("src/test/resources/InputMulti");
        Mower expected = new Mower(scenario1Ctx, new Location(new Position(1, 2), N));
        Mower expected2 = new Mower(scenario2Ctx, new Location(new Position(3, 3), E));

        List<Mower> mowers = PARSER.parseMowerDefinition(emptyFile);

        Assertions.assertEquals(2, mowers.size());
        Assertions.assertEquals(expected, mowers.get(0));
        Assertions.assertEquals(expected2, mowers.get(1));
    }
}