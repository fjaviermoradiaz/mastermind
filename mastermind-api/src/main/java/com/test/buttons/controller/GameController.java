package com.test.buttons.controller;

import com.test.buttons.converter.GameConverter;
import com.test.buttons.dto.GameDTO;
import com.test.buttons.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {


    private GameService service;

    @Autowired
    public GameController(GameService gameService) {
        this.service = gameService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GameDTO> createGame() {
        return new ResponseEntity<>(service.createGame(), HttpStatus.CREATED);
    }
}
