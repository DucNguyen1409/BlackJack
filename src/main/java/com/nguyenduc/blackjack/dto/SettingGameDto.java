package com.nguyenduc.blackjack.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SettingGameDto {
    @Min(value = 1, message = "Cần chọn điểm")
    private int pointTurn;

    @Min(value = 1, message = "Cần chọn điểm")
    private int winPointsBlackJack;

    @Min(value = 1, message = "Cần chọn điểm")
    private int winPointsFiveCardCharlie;

}
