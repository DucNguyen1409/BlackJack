package com.nguyenduc.blackjack.mapper;

import com.nguyenduc.blackjack.dto.ActivityHistoryDto;
import com.nguyenduc.blackjack.model.ActivityHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivityHistoryMapper {

    private final PlayerMapper playerMapper;

    public ActivityHistoryDto toDto(ActivityHistory entity) {
        return ActivityHistoryDto.builder()
                .id(entity.getId())
                .turnNumber(entity.getTurnNumber())
//                .players(playerMapper.toDtos(entity.setPlayerHistories())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public ActivityHistory toEntity(ActivityHistoryDto dto) {
        return ActivityHistory.builder()
                .turnNumber(dto.getTurnNumber())
//                .players(playerMapper.toEntities(dto.getPlayers()))
                .createdDate(dto.getCreatedDate())
                .build();
    }
}
