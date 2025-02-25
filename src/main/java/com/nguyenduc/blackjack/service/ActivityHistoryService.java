package com.nguyenduc.blackjack.service;

import com.nguyenduc.blackjack.dto.ActivityHistoryDto;
import com.nguyenduc.blackjack.dto.HistoryRecordDto;
import com.nguyenduc.blackjack.exception.BlackJackResultNotValid;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;

import java.util.List;

public interface ActivityHistoryService {
    List<ActivityHistoryDto> findAll() throws ResourceNotFoundException;
    ActivityHistoryDto findById(String id);
    List<ActivityHistoryDto> findByGameId(String gameId);
    ActivityHistoryDto createActivityHistory(HistoryRecordDto dto) throws BlackJackResultNotValid, ResourceNotFoundException;
    ActivityHistoryDto updateActivityHistory(String id, ActivityHistoryDto dto) throws ResourceNotFoundException;
}
