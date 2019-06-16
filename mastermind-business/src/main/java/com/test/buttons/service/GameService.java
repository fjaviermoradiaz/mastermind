package com.test.buttons.service;

import com.test.buttons.converter.GameConverter;
import com.test.buttons.dto.FeedbackCodeDTO;
import com.test.buttons.dto.GameDTO;
import com.test.buttons.dto.CheckCodeDTO;
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

        Game game = new Game(Colour.randomColourList());
        return converter.toDto(repository.save(game));
    }

    @Override
    public GameDTO getGame(String id) {
        return converter.toDto(repository.findOne(id));
    }

    @Override
    public FeedbackCodeDTO validateCode(CheckCodeDTO checkCodeDTO) {
        Game game = repository.findOne(checkCodeDTO.getId());
        FeedbackCodeDTO feedbackCodeDTO = new FeedbackCodeDTO(
                checkCodeDTO.getId(),
                Colour.checkParamList(
                        game.getColour(),
                        checkCodeDTO.getColour()
                ));
        return feedbackCodeDTO;
    }

    private void removeOldGame() {
        repository.deleteAll();
    }
}
