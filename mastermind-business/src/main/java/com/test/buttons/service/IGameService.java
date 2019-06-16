package com.test.buttons.service;

import com.test.buttons.dto.FeedbackCodeDTO;
import com.test.buttons.dto.GameDTO;
import com.test.buttons.dto.CheckCodeDTO;
import com.test.buttons.exception.EntityNotFoundException;

public interface IGameService {

    /**
     * Create new Mastermind game
     * @return GameDTO
     */
    GameDTO createGame();


    /**
     * Get game by id
     * @param id
     * @return GameDTO
     */
    GameDTO getGame(String id) throws EntityNotFoundException;


    /**
     * Validate code with game color list
     * @param gameId
     * @param code
     * @return FeedbackCodeDTO
     */
    FeedbackCodeDTO validateCode(CheckCodeDTO checkCodeDTO);

}
