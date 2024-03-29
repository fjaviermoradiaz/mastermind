package com.test.buttons.controller;

import com.test.buttons.dto.GameDTO;
import com.test.buttons.dto.CheckCodeDTO;
import com.test.buttons.dto.FeedbackCodeDTO;
import com.test.buttons.exception.EntityNotFoundException;
import com.test.buttons.service.GameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "/game", description = "Operations about mastermind game")
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

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<GameDTO> getByID(@PathVariable String id) throws EntityNotFoundException {
        return new ResponseEntity<>(service.getGame(id),HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<GameDTO>> getList() {
        return new ResponseEntity<>(service.getGameList(),HttpStatus.OK);
    }

    @PostMapping(value = "/check")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FeedbackCodeDTO> validateCode(@RequestBody @Valid CheckCodeDTO checkCodeDTO)
            throws EntityNotFoundException {
        return new ResponseEntity<>(service.validateCode(checkCodeDTO), HttpStatus.OK);
    }
}
