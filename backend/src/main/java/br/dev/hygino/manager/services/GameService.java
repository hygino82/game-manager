package br.dev.hygino.manager.services;

import br.dev.hygino.manager.dtos.GameDTO;
import br.dev.hygino.manager.dtos.RequestGameDTO;
import br.dev.hygino.manager.entities.Game;
import br.dev.hygino.manager.exceptions.ResourceNotFoundException;
import br.dev.hygino.manager.repositories.ConsoleRepository;
import br.dev.hygino.manager.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final ConsoleRepository consoleRepository;

    public GameService(GameRepository gameRepository, ConsoleRepository consoleRepository) {
        this.gameRepository = gameRepository;
        this.consoleRepository = consoleRepository;
    }

    @Transactional
    public GameDTO insertGame(@Valid RequestGameDTO dto) {
        final var consoleEntity = consoleRepository.findConsoleById(dto.consoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Não existe console com o id: " + dto.consoleId()));
        Game gameEntity = new Game();
        gameEntity.setCreateAt(LocalDateTime.now());
        gameEntity.setConsole(consoleEntity);
        dtoToEntity(dto, gameEntity);

        return new GameDTO(gameRepository.save(gameEntity));
    }

    @Transactional(readOnly = true)
    public Page<GameDTO> findAllGames(Pageable pageable) {
        final var page = gameRepository.findAll(pageable);

        return page.map(GameDTO::new);
    }

    @Transactional(readOnly = true)
    public GameDTO findGameById(UUID id) {
        return gameRepository.findGameById(id)
                .map(GameDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe jogo com o id: " + id));
    }

    @Transactional(readOnly = true)
    public GameDTO updateGameById(UUID id, @Valid RequestGameDTO dto) {
        final var consoleEntity = consoleRepository.findConsoleById(dto.consoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Não existe console com o id: " + dto.consoleId()));
        try {
            Game gameEntity = gameRepository.getReferenceById(id);
            dtoToEntity(dto, gameEntity);
            gameEntity.setUpdateAt(LocalDateTime.now());
            gameEntity.setConsole(consoleEntity);

            return new GameDTO(gameRepository.save(gameEntity));
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Não existe jogo com o id: " + id);
        } catch (DataIntegrityViolationException ex) {
            throw new ResourceNotFoundException("Não existe console com o id: " + dto.consoleId());
        }
    }

    private void dtoToEntity(@Valid RequestGameDTO dto, Game entity) {
        entity.setName(dto.name());
        entity.setImageUrl(dto.imageUrl());
        entity.setReleaseDate(dto.releaseDate());
        entity.setPersonalCode(dto.personalCode());
    }

    public void removeGameById(UUID id) {
        final var gameEntity = gameRepository.getReferenceById(id);
        try {
            gameRepository.delete(gameEntity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Não existe jogo com o id: " + id);
        }
    }
}
