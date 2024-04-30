package br.dev.hygino.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.dtos.GameDTO;
import br.dev.hygino.dtos.InsertGameDTO;
import br.dev.hygino.services.GameService;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameDTO> insert(InsertGameDTO dto) {
        GameDTO res = gameService.insert(dto);
        return ResponseEntity.status(201).body(res);
    }
}
