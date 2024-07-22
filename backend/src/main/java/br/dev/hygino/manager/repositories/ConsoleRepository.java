package br.dev.hygino.manager.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dev.hygino.manager.entities.Console;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, UUID> {

}
