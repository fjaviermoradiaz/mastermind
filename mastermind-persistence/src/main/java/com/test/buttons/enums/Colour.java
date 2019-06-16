package com.test.buttons.enums;

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
}