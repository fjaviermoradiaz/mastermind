package com.test.buttons.service;

import com.test.buttons.converter.GameConverter;
import com.test.buttons.dto.FeedbackCodeDTO;
import com.test.buttons.dto.GameDTO;
import com.test.buttons.dto.CheckCodeDTO;
import com.test.buttons.enums.Colour;
import com.test.buttons.exception.EntityNotFoundException;
import com.test.buttons.model.Game;
import com.test.buttons.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

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
        Game game = new Game(Colour.randomColourList());
        return converter.toDto(repository.save(game));
    }

    @Override
    public GameDTO getGame(String id) throws EntityNotFoundException {
        Optional<Game> game = repository.findByIdAndResolved(id,false);
        if(game.isPresent())
            return converter.toDto(game.get());
        else throw new EntityNotFoundException(id);

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

        if(Colour.isResolved(feedbackCodeDTO.getFlags())) {
            game.setResolved(true);
            repository.save(game);
        }
        return feedbackCodeDTO;
    }

}
