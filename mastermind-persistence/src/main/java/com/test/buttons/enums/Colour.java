package com.test.buttons.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Colour
{
    BLUE("BLUE"),
    YELLOW("YELLOW"),
    GREEN("GREEN"),
    PINK("PINK"),
    WHITE("WHITE"),
    ORANGE("ORANGE");

    private String colour;

    Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    private static final List<Colour> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static List<Colour> randomColourList()  {

        return Arrays.asList(VALUES.get(RANDOM.nextInt(SIZE)),
                             VALUES.get(RANDOM.nextInt(SIZE)),
                             VALUES.get(RANDOM.nextInt(SIZE)),
                             VALUES.get(RANDOM.nextInt(SIZE)));

    }
}