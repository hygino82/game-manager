package br.dev.hygino.services;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;

public interface ConsoleService {
    ConsoleDTO insert(ConsoleInsertDTO dto);
}
