package br.dev.hygino.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.hygino.dto.GameDTO;
import br.dev.hygino.dto.GameInsertDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.entities.Game;
import br.dev.hygino.repositories.ConsoleRepository;
import br.dev.hygino.repositories.GameRepository;
import jakarta.validation.Valid;

@Service
public class GameServiceImpl implements GameService {

	private final GameRepository gameRepository;
	private final ConsoleRepository consoleRepository;

	public GameServiceImpl(GameRepository gameRepository, ConsoleRepository consoleRepository) {
		this.gameRepository = gameRepository;
		this.consoleRepository = consoleRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GameDTO> findAll(Pageable pageable) {
		Page<Game> page = this.gameRepository.findAll(pageable);
		return page.map(game -> new GameDTO(game));
	}

	@Override
	@Transactional
	public ResponseEntity<?> insert(@Valid GameInsertDTO dto) {
		Console console = this.consoleRepository.findById(dto.consoleId())
				.orElseThrow(() -> new IllegalArgumentException("Não existe console com o id: " + dto.consoleId()));
		Game entity = new Game(dto, console);
		entity = this.gameRepository.save(entity);
		return ResponseEntity.status(201).body(new GameDTO(entity));
	}
}
