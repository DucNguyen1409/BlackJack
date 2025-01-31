package com.nguyenduc.blackjack.dto;

import com.nguyenduc.blackjack.constaint.PlayersConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class GameDto {

    private String id;

    private String name;

    @PlayersConstraint
    private List<PlayerDto> players;

    @NotNull(message = "Cần chọn nhà cái")
    private int dealerIndex;

    @Min(value = 1, message = "Cần chọn điểm")
    private int pointTurn;

    @Min(value = 1, message = "Cần chọn điểm")
    private int winPointsBlackJack;

    @Min(value = 1, message = "Cần chọn điểm")
    private int winPointsFiveCardCharlie;

}
