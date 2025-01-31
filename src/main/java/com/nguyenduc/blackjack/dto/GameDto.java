package com.nguyenduc.blackjack.dto;

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

    private String nameOfGame;

    private List<String> players;

    private String dealer;

    private int pointTurn;

    private int winPointsBlackJack;

    private int winPointsFiveCardCharlie;

}
