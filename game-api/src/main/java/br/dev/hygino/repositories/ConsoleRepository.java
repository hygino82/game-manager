package br.dev.hygino.repositories;

import br.dev.hygino.entities.Console;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsoleRepository extends JpaRepository<Console, String> {
}
