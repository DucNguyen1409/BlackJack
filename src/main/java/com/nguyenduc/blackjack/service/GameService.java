package com.nguyenduc.blackjack.service;

import com.nguyenduc.blackjack.dto.GameDto;

import java.util.List;

public interface GameService {
    GameDto createNewGame(GameDto dto);
    GameDto updateGame(GameDto dto);
    GameDto getGameDetailsById(Long id);
    List<GameDto> getAllGame();
    void deleteGame(Long id);
    void updatePoint();
}
