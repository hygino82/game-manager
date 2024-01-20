package br.dev.hygino.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.hygino.dto.GameDTO;
import br.dev.hygino.dto.GameInsertDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.entities.Game;
import br.dev.hygino.repositories.ConsoleRepository;
import br.dev.hygino.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
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

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> findById(String id) {
		Optional<Game> gameOptional = this.gameRepository.findById(id);

		if (gameOptional.isPresent()) {
			return ResponseEntity.status(200).body(new GameDTO(gameOptional.get()));
		}

		return ResponseEntity.status(404).body("Não existe jogo com o id: " + id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<GameDTO> findByConsoleId(Pageable pageable, String id) {
		Page<Game> page = this.gameRepository.findByConsoleId(pageable, id);
		return page.map(game -> new GameDTO(game));
	}

	@Override
	@Transactional
	public ResponseEntity<?> update(String id, @Valid GameInsertDTO dto) {
		try {
			Game gameEntity = this.gameRepository.getReferenceById(id);
			Console consoleEntity = this.consoleRepository.findById(dto.consoleId())
					.orElseThrow(() -> new IllegalArgumentException("Não existe console com o id: " + dto.consoleId()));
			gameEntity = dtoToEntity(dto, gameEntity, consoleEntity);
			gameEntity = this.gameRepository.save(gameEntity);
			return ResponseEntity.status(200).body(new GameDTO(gameEntity));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Não é possível atualizar o jogo com o id: " + id);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(500)
					.body("Impossível atualizar, pois não existe console com o id: " + dto.consoleId());
		}
	}

	private Game dtoToEntity(@Valid GameInsertDTO dto, Game gameEntity, Console consoleEntity) {
		gameEntity.setName(dto.name());
		gameEntity.setReleaseYear(dto.releaseYear());
		gameEntity.setImageUrl(dto.imageUrl());
		gameEntity.setUpdateDate(new Date());
		gameEntity.setConsole(consoleEntity);
		gameEntity.setPersonalCode(dto.personalCode());
		return gameEntity;
	}

}
