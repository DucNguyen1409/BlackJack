package com.nguyenduc.blackjack.service;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;

import java.util.List;

public interface GameService {
    GameDto createNewGame(GameDto dto);
    GameDto updateGame(String id, GameDto dto) throws ResourceNotFoundException;
    GameDto findGameDetailsById(String id);
    List<GameDto> findAll() throws ResourceNotFoundException;
    void deleteGame(String id) throws ResourceNotFoundException;
}
