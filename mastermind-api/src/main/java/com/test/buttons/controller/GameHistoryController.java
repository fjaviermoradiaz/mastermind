package com.test.buttons.controller;

import com.test.buttons.dto.CheckCodeDTO;
import com.test.buttons.dto.FeedbackCodeDTO;
import com.test.buttons.dto.GameDTO;
import com.test.buttons.dto.GameHistoryDTO;
import com.test.buttons.exception.EntityNotFoundException;
import com.test.buttons.service.GameHistoryService;
import com.test.buttons.service.GameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "/game/history", description = "Get history games")
@RestController
@RequestMapping(value = "/game/history")
public class GameHistoryController {


    private GameHistoryService service;

    @Autowired
    public GameHistoryController(GameHistoryService gameHistoryService) {
        this.service = gameHistoryService;
    }


    @GetMapping(value = "/{game}")
    @ResponseBody
    public ResponseEntity<List<GameHistoryDTO>> getByID(@PathVariable String game) {
        return new ResponseEntity<>(service.getHistoryGame(game),HttpStatus.OK);
    }
}
