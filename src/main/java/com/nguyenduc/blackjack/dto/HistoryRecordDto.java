package com.nguyenduc.blackjack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryRecordDto {
    private String gameId;
    private List<PlayerRecordDto> playerRecordDtos;
}
