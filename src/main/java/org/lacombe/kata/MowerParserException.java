package org.lacombe.kata;

import java.io.IOException;

public class MowerParserException extends RuntimeException {
    public MowerParserException(IOException e) {
        super(e);
    }
}
