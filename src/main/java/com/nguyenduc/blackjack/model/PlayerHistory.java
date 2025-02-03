package com.nguyenduc.blackjack.model;

import com.nguyenduc.blackjack.constant.Constant;
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

    public PlayerHistory(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.point = Constant.INITIAL_POINT;
    }
}
