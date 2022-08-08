package org.lacombe.kata;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Field {
    final Integer width;
    final Integer height;

    public Field(Integer width, Integer height) {
        //include-in bounds
        this.width = width+1;
        this.height = height+1;
    }

    public Boolean contains(Position p) {
        return p.x >= 0 && p.x < width && p.y >= 0 && p.y < height;
    }

}