package com.nguyenduc.blackjack.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "player")
public class Player {

    @NotNull(message = "Trống vị trí người chơi")
    private int index;

    @NotBlank(message = "Tên người chơi không được trống")
    private String name;

    private int point;
}
