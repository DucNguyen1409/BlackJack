package com.nguyenduc.blackjack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerHistoryDto {
    private int id;
    private String name;
    private int point;
    private BlackJackResult blackJackResult;
}
