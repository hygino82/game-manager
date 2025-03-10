package br.repository;

import br.model.Console;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;

public interface IConsoleRepository {

    List<Console> getGamelist();

    Console save(Console entity);

    Optional<Console> findById(long id);

    boolean removeConsoleById(long id);

    Console updateConsole(long id, @NotNull Console entity);
}
