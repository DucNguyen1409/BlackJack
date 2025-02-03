package com.nguyenduc.blackjack.mapper;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.model.Game;
import com.nguyenduc.blackjack.model.SettingGame;
import com.nguyenduc.blackjack.util.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper {

    private final PlayerMapper playerMapper;
    private final SettingGameMapper settingGameMapper;

    public GameDto toDto(Game entity) {
        return GameDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .players(playerMapper.toDtos(entity.getPlayers()))
                .dealerId(entity.getDealerId())
                .settingGame(settingGameMapper.toDto(entity.getSettingGame()))
                .build();
    }

    public Game toEntity(GameDto dto) {
        return Game.builder()
                .name(defaultGameNameIfEmpty(dto.getName()))
                .players(playerMapper.toEntities(dto.getPlayers()))
                .dealerId(dto.getDealerId())
                .settingGame(settingGameMapper.toEntity(dto.getSettingGame()))
                .build();
    }

    private String defaultGameNameIfEmpty(String name) {
        return StringUtils.isEmpty(name) ? "Xì Dách " + DateTimeUtils.getNowWithFormat() : name;
    }
}
