package com.nguyenduc.blackjack.controller;

import com.nguyenduc.blackjack.dto.ActivityHistoryDto;
import com.nguyenduc.blackjack.dto.HistoryRecordDto;
import com.nguyenduc.blackjack.exception.BlackJackResultNotValid;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;
import com.nguyenduc.blackjack.service.ActivityHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
@RequiredArgsConstructor
public class ActivityHistoryController {

    private final ActivityHistoryService activityHistoryService;

    @GetMapping
    public ResponseEntity<List<ActivityHistoryDto>> findAll() throws ResourceNotFoundException {
        return ResponseEntity.ok(activityHistoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityHistoryDto> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityHistoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ActivityHistoryDto> createHistory(@Valid @RequestBody HistoryRecordDto dto)
            throws BlackJackResultNotValid, ResourceNotFoundException {
        ActivityHistoryDto history = activityHistoryService.createActivityHistory(dto);
        return new ResponseEntity<>(history, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ActivityHistoryDto> updateHistory(@PathVariable("id") String id,
                                                            @Valid @RequestBody ActivityHistoryDto dto)
            throws ResourceNotFoundException {
        return ResponseEntity.ok(activityHistoryService.updateActivityHistory(id, dto));
    }
}
