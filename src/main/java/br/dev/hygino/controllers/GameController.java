package br.dev.hygino.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.dtos.GameDTO;
import br.dev.hygino.dtos.InsertGameDTO;
import br.dev.hygino.services.GameService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<Page<GameDTO>> findAll(Pageable pageable) {
        Page<GameDTO> page = this.gameService.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    public ResponseEntity<GameDTO> insertGame(@Valid @RequestBody InsertGameDTO dto) {
        GameDTO res = gameService.insertGame(dto);
        return ResponseEntity.status(201).body(res);
    }
}
