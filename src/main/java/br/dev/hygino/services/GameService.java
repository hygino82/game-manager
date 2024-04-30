package br.dev.hygino.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.dev.hygino.dtos.GameDTO;
import br.dev.hygino.dtos.InsertGameDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.entities.Game;
import br.dev.hygino.repositories.ConsoleRepository;
import br.dev.hygino.repositories.GameRepository;
import jakarta.transaction.Transactional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final ConsoleRepository consoleRepository;

    public GameService(GameRepository gameRepository, ConsoleRepository consoleRepository) {
        this.gameRepository = gameRepository;
        this.consoleRepository = consoleRepository;
    }

    @Transactional
    public GameDTO insert(InsertGameDTO dto) {
        Game entity = new Game();
        entity.setCreateAt(new Date());

        Console console = consoleRepository.findById(dto.consoleId())
                .orElseThrow(() -> new IllegalArgumentException("Não existe console com o Id:" + dto.consoleId()));

        copyDtoToEntity(entity, dto, console);
        entity = gameRepository.save(entity);
        return new GameDTO(entity);

    }

    private void copyDtoToEntity(Game entity, InsertGameDTO dto, Console console) {
        entity.setImageUrl(dto.imageUrl());
        entity.setName(dto.name());
        entity.setReleaseYear(dto.releaseYear());
        entity.setPersonalCode(dto.personalCode());
        entity.setConsole(console);
    }
}
