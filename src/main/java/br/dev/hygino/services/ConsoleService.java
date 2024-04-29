package br.dev.hygino.services;

import br.dev.hygino.dtos.ConsoleDTO;
import br.dev.hygino.dtos.InsertConsoleDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.repositories.ConsoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.time.Instant;
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

        entity.setCreateAt(new Date());
        dtoToEntity(entity, dto);
        entity = consoleRepository.save(entity);

        return new ConsoleDTO(entity);
    }

    @Transactional
    public ConsoleDTO update(Long id, InsertConsoleDTO dto) {
        try {
            Console entity = consoleRepository.getReferenceById(id);

            entity.setUpdateAt(new Date());
            dtoToEntity(entity, dto);
            entity = consoleRepository.save(entity);

            return new ConsoleDTO(entity);
        } catch (EntityNotFoundException enfe) {
            throw new IllegalArgumentException("Não existe console com o id: " + id);
        }
    }

    private void dtoToEntity(Console entity, InsertConsoleDTO dto) {
        entity.setName(dto.name());
        entity.setImageUrl(dto.imageUrl());
        entity.setReleaseYear(dto.releaseYear());
    }

    @Transactional(readOnly = true)
    public Page<ConsoleDTO> findAll(Pageable pageable) {
        Page<Console> page = consoleRepository.findAll(pageable);
        return page.map(ConsoleDTO::new);
    }

    @Transactional(readOnly = true)
    public ConsoleDTO findById(Long id) {
        Console entity = consoleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não existe Console com o Id: " + id));
        return new ConsoleDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void remove(Long id) {
        Console entity = consoleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não existe Console com o Id: " + id));
        consoleRepository.delete(entity);
    }
}
