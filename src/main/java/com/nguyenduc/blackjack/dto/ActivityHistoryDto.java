package com.nguyenduc.blackjack.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityHistoryDto {

    private String id;

    private String gameId;

//    @NotNull(message = "Lượt chơi không được trống")
    private int turnNumber;

    @NotNull(message = "Người chơi không được trống")
    private List<PlayerDto> players;

    private LocalDateTime createdDate;
}
