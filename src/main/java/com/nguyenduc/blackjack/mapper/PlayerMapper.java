package com.nguyenduc.blackjack.mapper;

import com.nguyenduc.blackjack.dto.PlayerDto;
import com.nguyenduc.blackjack.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerMapper {
    public List<PlayerDto> toDtos(List<Player> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    public List<Player> toEntities(List<PlayerDto> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    public PlayerDto toDto(Player entity) {
        return PlayerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public Player toEntity(PlayerDto dto) {
        return Player.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
