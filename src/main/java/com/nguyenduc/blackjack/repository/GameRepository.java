package com.nguyenduc.blackjack.repository;

import com.nguyenduc.blackjack.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
    boolean existsByName(String name);
}
