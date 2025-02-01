package br.dev.hygino.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.dev.hygino.dto.ResponseConsoleDTO;
import br.dev.hygino.repositories.ConsoleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsoleService {

    private final ConsoleRepository repository;

    public List<ResponseConsoleDTO> buscarTodos() {
        return repository.buscarTodos().stream().map(ResponseConsoleDTO::new).toList();
    }
}
