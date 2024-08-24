package br.dev.hygino.manager.controllers;

import br.dev.hygino.manager.dtos.GameDTO;
import br.dev.hygino.manager.dtos.RequestGameDTO;
import br.dev.hygino.manager.services.GameService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/game")
public class GameController {
    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GameDTO> insertGame(@Valid RequestGameDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertGame(dto));
    }

    @GetMapping
    public ResponseEntity<Page<GameDTO>> findAllGames(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllGames(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> findGameById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findGameById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> updateGameById(@PathVariable UUID id, @Valid RequestGameDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateGameById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeGameById(@PathVariable UUID id) {
        service.removeGameById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
