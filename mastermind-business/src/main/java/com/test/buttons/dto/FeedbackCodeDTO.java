package com.test.buttons.dto;

import com.test.buttons.enums.Colour;

import java.util.List;

public class FeedbackCodeDTO {

    private String gameId;
    private List<String> flags;

    public FeedbackCodeDTO(String gameId, List<String> flags) {
        this.gameId = gameId;
        this.flags = flags;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }
}
