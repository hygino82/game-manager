package br.dev.hygino.services;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConsoleService {
    ConsoleDTO insert(ConsoleInsertDTO dto);

    Page<ConsoleDTO> findAll(Pageable pageable);
}
