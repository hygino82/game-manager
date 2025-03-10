package br.repository;

import br.dto.RequestConsoleDTO;
import br.model.Console;
import java.util.List;
import javax.validation.constraints.NotNull;

public interface IConsoleRepository {

    List<Console> getGamelist();

   // Console save(Console entity);

   // void removeConsoleById(long id);

    //void updateConsole(long id, @NotNull RequestConsoleDTO dto);
}
