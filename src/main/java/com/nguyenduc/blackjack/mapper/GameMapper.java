package com.nguyenduc.blackjack.mapper;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.model.Game;
import com.nguyenduc.blackjack.util.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper {

    private final PlayerMapper playerMapper;

    public GameDto toDto(Game entity) {
        return GameDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .players(playerMapper.toDtos(entity.getPlayers()))
                .dealerId(entity.getDealerId())
                .pointTurn(entity.getPointTurn())
                .winPointsBlackJack(entity.getWinPointsBlackJack())
                .winPointsFiveCardCharlie(entity.getWinPointsFiveCardCharlie())
                .build();
    }

    public Game toEntity(GameDto dto) {
        return Game.builder()
                .name(defaultGameNameIfEmpty(dto.getName()))
                .players(playerMapper.toEntities(dto.getPlayers()))
                .dealerId(dto.getDealerId())
                .pointTurn(dto.getPointTurn())
                .winPointsBlackJack(dto.getWinPointsBlackJack())
                .winPointsFiveCardCharlie(dto.getWinPointsFiveCardCharlie())
                .build();
    }

    private String defaultGameNameIfEmpty(String name) {
        return StringUtils.isEmpty(name) ? "Xì Dách " + DateTimeUtils.getNowWithFormat() : name;
    }
}
