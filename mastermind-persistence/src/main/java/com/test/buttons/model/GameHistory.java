package com.test.buttons.model;

import com.test.buttons.enums.Colour;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class GameHistory {

    @Id
    private String id;
    private String game;
    private List<Colour> attempt;
    private List<String> flag;
    private Date attemptDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public List<Colour> getAttempt() {
        return attempt;
    }

    public void setAttempt(List<Colour> attempt) {
        this.attempt = attempt;
    }

    public Date getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(Date attemptDate) {
        this.attemptDate = attemptDate;
    }

    public List<String> getFlag() {
        return flag;
    }

    public void setFlag(List<String> flag) {
        this.flag = flag;
    }
}
