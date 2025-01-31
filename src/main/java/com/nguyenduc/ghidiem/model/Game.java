package com.nguyenduc.ghidiem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "game")
public class Game {
    @Id
    private long id;

    private String nameOfGame;

    private List<String> players;

    private String dealer;

    private int pointTurn;

    private int winPointsBlackJack;

    private int winPointsFiveCardCharlie;
}
