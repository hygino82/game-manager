package br.dev.hygino.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.dto.GameDTO;
import br.dev.hygino.dto.GameInsertDTO;
import br.dev.hygino.services.GameService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

	private final GameService gameService;

	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping
	public ResponseEntity<Page<GameDTO>> findAll(Pageable pageable) {
		return ResponseEntity.status(200).body(this.gameService.findAll(pageable));
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody @Valid GameInsertDTO dto) {
		return this.gameService.insert(dto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		return this.gameService.findById(id);
	}

	@GetMapping("console/{id}")
	public ResponseEntity<Page<GameDTO>> findByConsoleId(Pageable pageable, @PathVariable String id) {
		return ResponseEntity.status(200).body(this.gameService.findByConsoleId(pageable, id));
	}

}
