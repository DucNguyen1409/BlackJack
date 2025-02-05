package com.nguyenduc.blackjack.model;

import com.nguyenduc.blackjack.constant.Constant;
import com.nguyenduc.blackjack.dto.BlackJackResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerHistory {
    private int id;
    private String name;
    private int point;
    private BlackJackResult blackJackResult;

    public PlayerHistory(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.point = Constant.INITIAL_POINT;
    }
}
