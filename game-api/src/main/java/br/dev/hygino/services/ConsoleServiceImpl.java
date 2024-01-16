package br.dev.hygino.services;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.repositories.ConsoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class ConsoleServiceImpl implements ConsoleService {
    private final ConsoleRepository consoleRepository;

    public ConsoleServiceImpl(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    @Override
    @Transactional
    public ConsoleDTO insert(ConsoleInsertDTO dto) {
        Console entity = new Console(dto);
        entity = this.consoleRepository.saveAndFlush(entity);
        return new ConsoleDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ConsoleDTO> findAll(Pageable pageable) {
        Page<Console> page = this.consoleRepository.findAll(pageable);
        return page.map(ConsoleDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(String id) {
        var res = this.consoleRepository.findById(id);
        if (res.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ConsoleDTO(res.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe console com o id: " + id);
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateById(String id, ConsoleInsertDTO dto) {
        try {
            Console res = this.consoleRepository.getReferenceById(id);
            var entity = this.consoleRepository.save(copyDtoToEntity(dto, res));
            return ResponseEntity.status(HttpStatus.OK).body(new ConsoleDTO(entity));
        }/* catch (LazyInitializationException e) {
            return ResponseEntity.status(500).body("Ocorreu um erro interno!");
        } */ catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe console com o id: " + id);
        }
    }

    private Console copyDtoToEntity(ConsoleInsertDTO dto, Console entity) {
        entity.setName(dto.name());
        entity.setReleaseYear(dto.releaseYear());
        entity.setImgUrl(dto.imgUrl());
        entity.setUpdatedAt(Instant.now());
        return entity;
    }
}
