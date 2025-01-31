package com.nguyenduc.ghidiem.repository;

import com.nguyenduc.ghidiem.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, Long> {

}
