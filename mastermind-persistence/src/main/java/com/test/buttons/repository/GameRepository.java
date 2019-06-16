package com.test.buttons.repository;


import com.test.buttons.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface GameRepository extends MongoRepository<Game, String> {

    Optional<Game> findByIdAndResolved(String id, Boolean resolved);
}
