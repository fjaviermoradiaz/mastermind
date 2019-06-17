package com.test.buttons.converter;

import com.test.buttons.dto.GameHistoryDTO;
import com.test.buttons.model.GameHistory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GameHistoryConverter {

    public GameHistoryDTO toDto(GameHistory gameHistory) {
        GameHistoryDTO gameHistoryDTO = new GameHistoryDTO();
        BeanUtils.copyProperties(gameHistory,gameHistoryDTO);
        return gameHistoryDTO;
    }

    public GameHistory toEntity(GameHistoryDTO gameHistoryDTO) {
        GameHistory gameHistory = new GameHistory();
        BeanUtils.copyProperties(gameHistoryDTO,gameHistory);
        gameHistory.setAttemptDate(new Date());
        return gameHistory;
    }
}
