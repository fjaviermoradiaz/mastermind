package com.test.buttons.dto;

import com.test.buttons.enums.Colour;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class GameDTO {

    @NotNull
    private String id;

    @NotNull
    @Size(min = 4, max = 4)
    private List<Colour> colour;

    public List<Colour> getColour() {
        return colour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setColour(List<Colour> colour) {
        this.colour = colour;
    }

}
