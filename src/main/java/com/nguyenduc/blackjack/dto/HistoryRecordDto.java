package com.nguyenduc.blackjack.dto;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "GameID không được trống")
    private String gameId;
    private List<PlayerRecordDto> playerRecordDtos;
}
