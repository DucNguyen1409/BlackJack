package com.nguyenduc.blackjack.service;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;

import java.util.List;

public interface GameService {
    GameDto createNewGame(GameDto dto);
    GameDto updateGame(GameDto dto) throws ResourceNotFoundException;
    GameDto getGameDetailsById(String id);
    List<GameDto> getAllGame() throws ResourceNotFoundException;
    void deleteGame(String id) throws ResourceNotFoundException;
    void updatePoint();
}
