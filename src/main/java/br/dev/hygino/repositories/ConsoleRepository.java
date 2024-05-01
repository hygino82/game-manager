package br.dev.hygino.repositories;

import br.dev.hygino.entities.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {

}
