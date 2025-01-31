package com.nguyenduc.blackjack.mapper;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public GameDto toDto(Game entity) {
        return GameDto.builder()
                .nameOfGame(entity.getNameOfGame())
                .players(entity.getPlayers())
                .dealer(entity.getDealer())
                .pointTurn(entity.getPointTurn())
                .winPointsBlackJack(entity.getWinPointsBlackJack())
                .winPointsFiveCardCharlie(entity.getWinPointsFiveCardCharlie())
                .build();
    }

    public Game toEntity(GameDto dto) {
        return Game.builder()
                .nameOfGame(dto.getNameOfGame())
                .players(dto.getPlayers())
                .dealer(dto.getDealer())
                .pointTurn(dto.getPointTurn())
                .winPointsBlackJack(dto.getWinPointsBlackJack())
                .winPointsFiveCardCharlie(dto.getWinPointsFiveCardCharlie())
                .build();
    }
}
