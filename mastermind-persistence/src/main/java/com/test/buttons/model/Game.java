package com.test.buttons.model;

import com.test.buttons.enums.Colour;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Game {

    @Id
    private String id;
    private List<Colour> colour;
    private Boolean resolved;

    public Game() {
        this.resolved = false;
    }

    public Game(List<Colour> colour) {
        this.colour = colour;
        this.resolved = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Colour> getColour() {
        return colour;
    }

    public void setColour(List<Colour> colour) {
        this.colour = colour;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
