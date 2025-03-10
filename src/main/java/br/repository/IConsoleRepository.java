package br.repository;

import br.model.Console;
import java.util.List;
import java.util.Optional;

public interface IConsoleRepository {

    List<Console> getGamelist();

    Console save(Console entity);

    Optional< Console> findById(long id);

    // void removeConsoleById(long id);
    //void updateConsole(long id, @NotNull RequestConsoleDTO dto);
}
