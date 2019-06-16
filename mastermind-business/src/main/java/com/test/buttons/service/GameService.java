package com.test.buttons.service;

import com.test.buttons.converter.GameConverter;
import com.test.buttons.dto.GameDTO;
import com.test.buttons.enums.Colour;
import com.test.buttons.model.Game;
import com.test.buttons.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService {

    private GameRepository repository;
    private GameConverter converter;

    @Autowired
    public GameService(GameRepository gameRepository, GameConverter gameConverter) {
        this.repository = gameRepository;
        this.converter = gameConverter;
    }

    @Override
    public GameDTO createGame() {
        removeOldGame();

        Game game = new Game((Colour[]) Colour.randomColourList().toArray());
        return converter.toDto(repository.save(game));
    }

    private void removeOldGame() {
        repository.deleteAll();
    }
}
