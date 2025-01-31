package com.nguyenduc.ghidiem.repository;

import com.nguyenduc.ghidiem.model.ActivityHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityHistoryRepository extends MongoRepository<ActivityHistory, Long> {
}
