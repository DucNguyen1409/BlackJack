package com.nguyenduc.blackjack.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum BlackJackResult {
    WIN,
    LOSE,
    DRAW,
    WIN_BLACKJACK,
    LOSE_BLACKJACK,
    WIN_FIVE_CARD,
    LOSE_FIVE_CARD;

    @JsonCreator
    public static BlackJackResult fromString(String value) {
        return BlackJackResult.valueOf(value.toUpperCase());
    }
}
