package com.nguyenduc.blackjack.service.impl;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.mapper.GameMapper;
import com.nguyenduc.blackjack.model.Game;
import com.nguyenduc.blackjack.repository.GameRepository;
import com.nguyenduc.blackjack.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameMapper gameMapper;

    private final GameRepository gameRepository;

    @Override
    public GameDto createNewGame(GameDto dto) {
        Game savedGame = gameRepository.save(gameMapper.toEntity(dto));
        return gameMapper.toDto(savedGame);
    }

    @Override
    public GameDto updateGame(GameDto dto) {
        return null;
    }

    @Override
    public GameDto getGameDetailsById(Long id) {
        Game gameById = gameRepository.findById(id)
                .orElse(new Game());
        return gameMapper.toDto(gameById);
    }

    @Override
    public List<GameDto> getAllGame() {
        List<Game> results = gameRepository.findAll();
        // empty check
        if (CollectionUtils.isEmpty(results)) {
            throw new IllegalStateException("No game created!!!");
        }

        return results.stream()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.findById(id)
                .ifPresent(game -> gameRepository.deleteById(game.getId()));
    }

    @Override
    public void updatePoint() {
        //todo
    }

}
