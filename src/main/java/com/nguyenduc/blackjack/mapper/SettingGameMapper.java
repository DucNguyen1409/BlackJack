package com.nguyenduc.blackjack.mapper;

import com.nguyenduc.blackjack.dto.SettingGameDto;
import com.nguyenduc.blackjack.model.SettingGame;
import org.springframework.stereotype.Component;

@Component
public class SettingGameMapper {
    public SettingGameDto toDto(SettingGame entity) {
        return SettingGameDto.builder()
                .pointTurn(entity.getPointTurn())
                .winPointsBlackJack(entity.getWinPointsBlackJack())
                .winPointsFiveCardCharlie(entity.getWinPointsFiveCardCharlie())
                .build();
    }

    public SettingGame toEntity(SettingGameDto dto) {
        return SettingGame.builder()
                .pointTurn(dto.getPointTurn())
                .winPointsBlackJack(dto.getWinPointsBlackJack())
                .winPointsFiveCardCharlie(dto.getWinPointsFiveCardCharlie())
                .build();
    }
}
