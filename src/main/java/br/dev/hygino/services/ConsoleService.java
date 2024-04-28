package br.dev.hygino.services;

import br.dev.hygino.dtos.ConsoleDTO;
import br.dev.hygino.dtos.InsertConsoleDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.repositories.ConsoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ConsoleService {
    private final ConsoleRepository consoleRepository;

    public ConsoleService(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    @Transactional
    public ConsoleDTO insert(InsertConsoleDTO dto) {
        Console entity = new Console();

        entity.setCreatedAt(new Date());
        dtoToEntity(entity, dto);
        entity = consoleRepository.save(entity);

        return new ConsoleDTO(entity);
    }

    private void dtoToEntity(Console entity, InsertConsoleDTO dto) {
        entity.setName(dto.name());
        entity.setImageUrl(dto.imageUrl());
        entity.setReleaseYear(dto.releaseYear());
    }
}
