package com.nguyenduc.blackjack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "game")
public class Game {

    @Id
    private String id;

    private String name;

    private List<Player> players;

    private int dealerIndex;

    private int pointTurn;

    private int winPointsBlackJack;

    private int winPointsFiveCardCharlie;
}
