package org.lacombe.kata;

public enum RotationDirection {

    RIGHT("D"),
    LEFT("G");

    private final String label;

    RotationDirection(String label) {
        this.label = label;
    }

    public static RotationDirection fromLabel(String label) {
        RotationDirection[] values = values();
        for (RotationDirection value : values) {
            if (value.label.equals(label)) {
                return value;
            }
        }
        return null;
    }
}
