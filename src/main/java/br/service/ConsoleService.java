package br.service;

import br.model.Console;
import br.repository.ConsoleRepository;
import java.util.List;

public class ConsoleService {

    private ConsoleRepository repository = ConsoleRepository.getInstance();

    public List<Console> findAllConsoles() {
        return repository.getGamelist();
    }
}
