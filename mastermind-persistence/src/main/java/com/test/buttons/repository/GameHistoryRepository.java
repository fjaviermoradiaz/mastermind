package com.test.buttons.repository;

import com.test.buttons.model.GameHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface GameHistoryRepository extends MongoRepository<GameHistory, String> {

    List<GameHistory> findAllByGame(String game);

}
