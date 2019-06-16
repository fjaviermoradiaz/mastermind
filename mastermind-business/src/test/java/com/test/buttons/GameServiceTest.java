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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
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
    private String ID = "MASTERMINDID";
    private static String RED_FLAG = "RED";
    private static String WHITE_FLAG = "WHITE";

    @Before
    public void setUp() {
        gameService = new GameService(repository,converter);
        game = new Game(Colour.randomColourList());
        game.setId(ID);
        gameDTO = new GameDTO();
        gameDTO.setColour(game.getColour());
        gameDTO.setId(ID);
    }

    @Test
    public void createNewGame() {
        when(gameService.createGame()).thenReturn(gameDTO);

        GameDTO gameDTO = gameService.createGame();

        Assert.assertNotNull(gameDTO);
        Assert.assertThat(gameDTO.getColour(), IsEqual.equalTo(this.game.getColour()));
    }

    @Test
    public void getGame() {
        when(gameService.getGame(anyString())).thenReturn(gameDTO);

        GameDTO gameDTO = gameService.getGame(ID);

        Assert.assertNotNull(gameDTO);
        Assert.assertThat(gameDTO.getId(), IsEqual.equalTo(this.game.getId()));
    }

    @Test
    public void checkValues() {

        List<Colour> originalList = Arrays.asList(Colour.RED,Colour.BLUE, Colour.GREEN, Colour.RED);
        List<Colour> paramList = Arrays.asList(Colour.RED,Colour.GREEN,Colour.RED,Colour.YELLOW);

        List<String> flags = Colour.checkParamList(originalList,paramList);

        Assert.assertEquals(flags.size(),3);
        Assert.assertEquals(flags.get(0),RED_FLAG);
        Assert.assertEquals(flags.get(1),WHITE_FLAG);
        Assert.assertEquals(flags.get(2),WHITE_FLAG);

    }
}
