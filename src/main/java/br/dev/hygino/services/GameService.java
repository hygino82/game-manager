package br.dev.hygino.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.hygino.dtos.GameDTO;
import br.dev.hygino.dtos.InsertGameDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.entities.Game;
import br.dev.hygino.repositories.ConsoleRepository;
import br.dev.hygino.repositories.GameRepository;
import jakarta.validation.Valid;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final ConsoleRepository consoleRepository;

    public GameService(GameRepository gameRepository, ConsoleRepository consoleRepository) {
        this.gameRepository = gameRepository;
        this.consoleRepository = consoleRepository;
    }

    /*
     * private Game copyDtoToEntity(Game entity, InsertGameDTO dto) {
     * entity.setImageUrl(dto.imageUrl());
     * entity.setName(dto.name());
     * entity.setReleaseYear(dto.releaseYear());
     * entity.setPersonalCode(dto.personalCode());
     * // entity.setConsole(console);
     * return entity;
     * }
     */

    @Transactional(readOnly = true)
    public Page<GameDTO> findAll(Pageable pageable) {
        Page<Game> page = gameRepository.findAll(pageable);
        return page.map(game -> new GameDTO(game));
    }

    @Transactional
    public GameDTO insertGame(@Valid InsertGameDTO dto) {
        Game gameEntity = new Game(dto);
        Console consoleEntity = consoleRepository.findById(dto.consoleId())
                .orElseThrow(() -> new IllegalArgumentException("Não existe Console com o Id: " + dto.consoleId()));
        gameEntity.setConsole(consoleEntity);
        gameEntity = gameRepository.save(gameEntity);
        return new GameDTO(gameEntity);
    }
}
