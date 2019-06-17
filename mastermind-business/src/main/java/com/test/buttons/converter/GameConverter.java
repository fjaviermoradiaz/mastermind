package com.test.buttons.converter;

import com.test.buttons.dto.GameDTO;
import com.test.buttons.model.Game;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GameConverter {

    public GameDTO toDto(Game game) {
        GameDTO gameDTO = new GameDTO();
        BeanUtils.copyProperties(game,gameDTO);
        return gameDTO;
    }

    public Game toEntity(GameDTO gameDTO) {
        Game game = new Game();
        BeanUtils.copyProperties(gameDTO,game);
        return game;
    }
}
