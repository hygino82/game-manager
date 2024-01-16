package br.dev.hygino.services;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ConsoleService {
    ConsoleDTO insert(ConsoleInsertDTO dto);

    Page<ConsoleDTO> findAll(Pageable pageable);

    ResponseEntity<?> findById(String id);

    ResponseEntity<?> updateById(String id, ConsoleInsertDTO dto);

    void remove(String id);
}
