package com.nguyenduc.blackjack.service;

import com.nguyenduc.blackjack.dto.HistoryRecordDto;
import com.nguyenduc.blackjack.exception.BlackJackResultNotValid;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;
import com.nguyenduc.blackjack.model.ActivityHistory;

public interface BlackJackService {
    ActivityHistory calculateResult(HistoryRecordDto historyRecordDto) throws ResourceNotFoundException, BlackJackResultNotValid;
}
