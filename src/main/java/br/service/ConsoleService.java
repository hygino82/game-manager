package br.service;

import br.model.Console;
import br.repository.ConsoleRepositoryPostGres;
import java.util.List;
import javax.inject.Inject;

public class ConsoleService {

    //private ModelMapper mapper = new ModelMapper();
    //private ConsoleRepository repository = ConsoleRepository.getInstance();
    private final ConsoleRepositoryPostGres dbRepository;

    @Inject
    public ConsoleService(ConsoleRepositoryPostGres dbRepository) {
        this.dbRepository = dbRepository;
    }

    public List<Console> findAllConsoles() {
        return dbRepository.getGamelist();
    }

    /* public Console insert(@NotNull RequestConsoleDTO dto) {
        Console entity = mapper.map(dto, Console.class);
        return repository.save(entity);
    }

    public Console updateConsole(long id, RequestConsoleDTO dto) {
        Optional<Console> res = repository.getGamelist().stream().filter(e -> e.getId() == id).findFirst();

        if (res.isEmpty()) {
            throw new ConsoleNotFoundException("Não existe Console com o id: " + id);
        }

        Console entity = res.get();
        dtoToEntity(dto, entity);

        return repository.save(entity);
    }

    private void dtoToEntity(RequestConsoleDTO dto, Console entity) {
        entity.setName(dto.getName());
        entity.setCompany(dto.getCompany());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setImageUrl(dto.getImageUrl());
    }

    public Console findConsoleById(long id) {
        Optional<Console> res = repository.getGamelist().stream().filter(e -> e.getId() == id).findFirst();

        if (res.isEmpty()) {
            throw new ConsoleNotFoundException("Não existe Console com o id: " + id);
        }

        return res.get();
    }

    public void removeConsoleById(long id) {
        repository.removeConsoleById(id);
    }*/
}
