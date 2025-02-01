package com.nguyenduc.blackjack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    @NotNull(message = "Trống vị trí người chơi")
    private int id;

    @NotBlank(message = "Tên người chơi không được trống")
    private String name;

    private int point = 0;
}
