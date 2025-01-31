package com.nguyenduc.ghidiem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "game_rule")
public class GameRule {
    @Id
    private long id;

    private int turnPoints;

    private int winPointsBlackJack;

    private int winPointsFiveCardCharlie;

}
