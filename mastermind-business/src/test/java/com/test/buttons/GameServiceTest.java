package com.test.buttons;

import com.test.buttons.converter.GameConverter;
import com.test.buttons.dto.GameDTO;
import com.test.buttons.enums.Colour;
import com.test.buttons.model.Game;
import com.test.buttons.repository.GameRepository;
import com.test.buttons.service.GameService;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Mock
    private GameRepository repository;
    @Mock
    private GameConverter converter;
    private GameService gameService;
    private Game game;
    private GameDTO gameDTO;

    @Before
    public void setUp() {
        gameService = new GameService(repository,converter);
        game = new Game((Colour[]) Colour.randomColourList().toArray());

        gameDTO = new GameDTO();
        gameDTO.setColour(game.getColour());
    }

    @Test
    public void createNewGame() {
        when(gameService.createGame()).thenReturn(gameDTO);

        GameDTO gameDTO = gameService.createGame();

        Assert.assertNotNull(gameDTO);
        Assert.assertThat(gameDTO.getColour(), IsEqual.equalTo(this.game.getColour()));
    }
}
