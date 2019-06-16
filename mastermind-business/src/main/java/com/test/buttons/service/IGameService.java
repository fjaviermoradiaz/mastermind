package com.test.buttons.service;

import com.test.buttons.dto.GameDTO;

public interface IGameService {

    /**
     * Create new Mastermind game
     * @return GameDTO
     */
    GameDTO createGame();

}
