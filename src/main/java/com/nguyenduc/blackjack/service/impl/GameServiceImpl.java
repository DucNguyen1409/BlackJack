package com.nguyenduc.blackjack.service.impl;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;
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
    public GameDto updateGame(GameDto dto) throws ResourceNotFoundException {
        // existed check
        Game existsById = gameRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy ván chơi"));
        Game entity = gameMapper.toEntity(dto);
        entity.setId(existsById.getId());

        // update game
        Game result = gameRepository.save(entity);
        return gameMapper.toDto(result);
    }

    @Override
    public GameDto getGameDetailsById(String id) {
        Game gameById = gameRepository.findById(id)
                .orElseThrow();
        return gameMapper.toDto(gameById);
    }

    @Override
    public List<GameDto> getAllGame() throws ResourceNotFoundException {
        List<Game> results = gameRepository.findAll();
        // empty check
        if (CollectionUtils.isEmpty(results)) {
            throw new ResourceNotFoundException("không có ván chơi nào");
        }

        return results.stream()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGame(String id) throws ResourceNotFoundException {
        Game result = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy ván chơi"));
        gameRepository.deleteById(result.getId());
    }

    @Override
    public void updatePoint() {
        //todo
    }

}
