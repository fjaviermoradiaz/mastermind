package com.test.buttons.dto;

import com.test.buttons.enums.Colour;

public class GameDTO {

    private String id;
    private Colour[] colour;
    private String[] key;

    public Colour[] getColour() {
        return colour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setColour(Colour[] colour) {
        this.colour = colour;
    }

    public String[] getKey() {
        return key;
    }

    public void setKey(String[] key) {
        this.key = key;
    }
}
