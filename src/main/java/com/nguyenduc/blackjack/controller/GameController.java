package com.nguyenduc.blackjack.controller;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGameDetailsById(@PathVariable(value = "id") Long id) {
        GameDto result = gameService.getGameDetailsById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<GameDto>> getAllGame() {
        List<GameDto> results = gameService.getAllGame();
        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<GameDto> createGame(@RequestBody GameDto dto) {
        GameDto result = gameService.createNewGame(dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable(value = "id") Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.accepted().build();
    }
}
