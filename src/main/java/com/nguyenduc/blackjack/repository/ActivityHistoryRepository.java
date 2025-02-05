package com.nguyenduc.blackjack.repository;

import com.nguyenduc.blackjack.model.ActivityHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ActivityHistoryRepository extends MongoRepository<ActivityHistory, String> {
    Optional<ActivityHistory> findByGameId(String gameId);
    Optional<ActivityHistory> findFirstByGameIdOrderByCreatedDateDesc(String gameId);
}
