package com.nguyenduc.blackjack.controller;

import com.nguyenduc.blackjack.dto.GameDto;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;
import com.nguyenduc.blackjack.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGameDetailsById(@PathVariable(value = "id") String id) {
        GameDto result = gameService.getGameDetailsById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<GameDto>> getAllGame() throws ResourceNotFoundException {
        List<GameDto> results = gameService.getAllGame();
        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<GameDto> createGame(@Valid @RequestBody GameDto dto) {
        GameDto result = gameService.createNewGame(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
        gameService.deleteGame(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping
    public ResponseEntity<GameDto> updateGame(@Valid @RequestBody GameDto dto) throws ResourceNotFoundException {
        GameDto result = gameService.updateGame(dto);
        return ResponseEntity.ok(result);
    }

}
