package com.test.buttons.service;

import com.test.buttons.converter.GameHistoryConverter;
import com.test.buttons.dto.GameHistoryDTO;
import com.test.buttons.model.GameHistory;
import com.test.buttons.repository.GameHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameHistoryService implements IGameHistoryService {

    private GameHistoryRepository repository;
    private GameHistoryConverter converter;

    @Autowired
    public GameHistoryService(GameHistoryRepository repository, GameHistoryConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<GameHistoryDTO> getHistoryGame(String game) {
        List<GameHistory> list = repository.findAllByGame(game);
        return list
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }
}
