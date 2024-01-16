package br.dev.hygino.services;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.repositories.ConsoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConsoleServiceImpl implements ConsoleService {
    private final ConsoleRepository consoleRepository;

    public ConsoleServiceImpl(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    @Override
    public ConsoleDTO insert(ConsoleInsertDTO dto) {
        Console entity = new Console(dto);
        entity = this.consoleRepository.saveAndFlush(entity);
        return new ConsoleDTO(entity);
    }

    @Override
    public Page<ConsoleDTO> findAll(Pageable pageable) {
        Page<Console> page = this.consoleRepository.findAll(pageable);
        return page.map(ConsoleDTO::new);
    }
}
