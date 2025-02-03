package com.nguyenduc.blackjack.dto;

import com.nguyenduc.blackjack.constaint.PlayersConstraint;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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
@Valid
public class GameDto {

    private String id;

    private String name;

//    @Valid
    @PlayersConstraint
    private List<PlayerDto> players;

    @NotNull(message = "Cần chọn nhà cái")
    private int dealerId;

    private SettingGameDto settingGame;

}
