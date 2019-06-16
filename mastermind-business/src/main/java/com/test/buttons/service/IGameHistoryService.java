package com.test.buttons.service;

import com.test.buttons.dto.GameHistoryDTO;

import java.util.List;

public interface IGameHistoryService {

    /**
     * Get game history
     * @param game
     * @return List of GameHistoryDTO
     */
    List<GameHistoryDTO> getHistoryGame(String game);

}
