package br.dev.hygino.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;

public interface ConsoleService {
    ConsoleDTO insert(ConsoleInsertDTO dto);

    Page<ConsoleDTO> findAll(Pageable pageable);

    ResponseEntity<?> findById(UUID id);

    ResponseEntity<?> updateById(UUID id, ConsoleInsertDTO dto);

    void remove(UUID id);
}
