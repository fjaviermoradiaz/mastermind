package com.test.buttons;

import com.test.buttons.converter.GameHistoryConverter;
import com.test.buttons.dto.GameHistoryDTO;
import com.test.buttons.enums.Colour;
import com.test.buttons.model.GameHistory;
import com.test.buttons.repository.GameHistoryRepository;
import com.test.buttons.service.GameHistoryService;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameHistoryServiceTest {

    @Mock
    private GameHistoryRepository repository;
    @InjectMocks
    private GameHistoryConverter converter = new GameHistoryConverter();

    private GameHistoryService service;
    private GameHistory gameHistory;
    private List<GameHistory> gameHistoryList;
    private String GAME_ID = "MASTERMINDID";

    @Before
    public void setUp() {
        service = new GameHistoryService(repository,converter);

        gameHistoryList = new ArrayList<>();

        gameHistory = new GameHistory();
        gameHistory.setId("1");
        gameHistory.setAttempt(new ArrayList<Colour>());
        gameHistory.setAttemptDate(new Date());
        gameHistory.setFlag(new ArrayList<String>());
        gameHistory.setGame(GAME_ID);

        gameHistoryList.add(gameHistory);


    }

    @Test
    public void getHistoryGame() {
        when(repository.findAllByGame(GAME_ID)).thenReturn(gameHistoryList);

        List<GameHistoryDTO> list = service.getHistoryGame(GAME_ID);

        Assert.assertNotNull(list);
        Assert.assertThat(list.get(0).getGame(), IsEqual.equalTo(GAME_ID));
    }
}
