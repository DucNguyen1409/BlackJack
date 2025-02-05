package com.nguyenduc.blackjack.mapper;

import com.nguyenduc.blackjack.dto.ActivityHistoryDto;
import com.nguyenduc.blackjack.model.ActivityHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityHistoryMapper {

    private final PlayerHistoryMapper playerHistoryMapper;

    public ActivityHistoryDto toDto(ActivityHistory entity) {
        return ActivityHistoryDto.builder()
                .id(entity.getId())
                .gameId(entity.getGameId())
                .turnNumber(entity.getTurnNumber())
                .playerHistories(playerHistoryMapper.toDtos(entity.getPlayerHistories()))
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public ActivityHistory toEntity(ActivityHistoryDto dto) {
        return ActivityHistory.builder()
                .gameId(dto.getGameId())
                .turnNumber(dto.getTurnNumber())
                .playerHistories(playerHistoryMapper.toEntities(dto.getPlayerHistories()))
                .createdDate(dto.getCreatedDate())
                .build();
    }
}
