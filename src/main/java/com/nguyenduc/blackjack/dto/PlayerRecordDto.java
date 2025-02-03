package com.nguyenduc.blackjack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRecordDto {
    private int id;
    private BlackJackResult blackJack;
}
