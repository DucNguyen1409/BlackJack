package com.nguyenduc.blackjack.repository;

import com.nguyenduc.blackjack.model.ActivityHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityHistoryRepository extends MongoRepository<ActivityHistory, Long> {
}
