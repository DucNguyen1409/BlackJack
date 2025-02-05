package com.nguyenduc.blackjack.mapper;

import com.nguyenduc.blackjack.dto.PlayerHistoryDto;
import com.nguyenduc.blackjack.model.PlayerHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerHistoryMapper {

    public List<PlayerHistoryDto> toDtos(List<PlayerHistory> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    public List<PlayerHistory> toEntities(List<PlayerHistoryDto> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    public PlayerHistoryDto toDto(PlayerHistory entity) {
        return PlayerHistoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .point(entity.getPoint())
                .blackJackResult(entity.getBlackJackResult())
                .build();
    }

    public PlayerHistory toEntity(PlayerHistoryDto dto) {
        return PlayerHistory.builder()
                .id(dto.getId())
                .name(dto.getName())
                .point(dto.getPoint())
                .blackJackResult(dto.getBlackJackResult())
                .build();
    }
}
