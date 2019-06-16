package com.test.buttons.model;

import com.test.buttons.enums.Colour;
import org.springframework.data.annotation.Id;

public class Game {

    @Id
    private String id;
    private Colour[] colour;

    public Game() {
    }

    public Game(Colour[] colour) {
        this.colour = colour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Colour[] getColour() {
        return colour;
    }

    public void setColour(Colour[] colour) {
        this.colour = colour;
    }
}
