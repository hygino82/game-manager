package br.dev.hygino.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.hygino.entities.Console;

public interface ConsoleRepository extends JpaRepository<Console, UUID> {
}
