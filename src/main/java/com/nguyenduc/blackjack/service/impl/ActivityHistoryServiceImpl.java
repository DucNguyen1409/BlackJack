package com.nguyenduc.blackjack.service.impl;

import com.nguyenduc.blackjack.dto.ActivityHistoryDto;
import com.nguyenduc.blackjack.dto.HistoryRecordDto;
import com.nguyenduc.blackjack.exception.BlackJackResultNotValid;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;
import com.nguyenduc.blackjack.mapper.ActivityHistoryMapper;
import com.nguyenduc.blackjack.model.ActivityHistory;
import com.nguyenduc.blackjack.repository.ActivityHistoryRepository;
import com.nguyenduc.blackjack.service.ActivityHistoryService;
import com.nguyenduc.blackjack.service.BlackJackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityHistoryServiceImpl implements ActivityHistoryService {

    private final ActivityHistoryRepository activityHistoryRepository;
    private final BlackJackService blackJackService;
    private final ActivityHistoryMapper activityHistoryMapper;

    @Override
    public List<ActivityHistoryDto> findAll() throws ResourceNotFoundException {
        List<ActivityHistory> results = activityHistoryRepository.findAll();
        // empty check
        if (CollectionUtils.isEmpty(results)) {
            throw new ResourceNotFoundException("không có lịch sử nào ghi lại");
        }

        return results.stream()
                .map(activityHistoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityHistoryDto findById(String id) {
        ActivityHistory activityHistoryById = activityHistoryRepository.findById(id).orElseThrow();
        return activityHistoryMapper.toDto(activityHistoryById);
    }

    @Override
    public List<ActivityHistoryDto> findByGameId(String gameId) {
        List<ActivityHistory> activityHistoryByGameIdList = activityHistoryRepository.findByGameId(gameId);
        return activityHistoryByGameIdList.stream()
                .map(activityHistoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityHistoryDto createActivityHistory(HistoryRecordDto dto)
            throws BlackJackResultNotValid, ResourceNotFoundException {
        return activityHistoryMapper.toDto(blackJackService.calculateResult(dto));
    }

    @Override
    public ActivityHistoryDto updateActivityHistory(String id, ActivityHistoryDto dto) throws ResourceNotFoundException {
        // existed check
        ActivityHistory existsById = activityHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lịch sử này"));
        ActivityHistory entity = activityHistoryMapper.toEntity(dto);
        entity.setId(existsById.getId());

        // update history
        ActivityHistory result = activityHistoryRepository.save(entity);
        return activityHistoryMapper.toDto(result);
    }
}
