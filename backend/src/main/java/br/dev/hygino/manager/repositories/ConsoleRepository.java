package br.dev.hygino.manager.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.dev.hygino.manager.entities.Console;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, UUID> {

	@Query("""
			SELECT obj FROM Console obj WHERE obj.id =?1
			""")
	Optional<Console> findConsoleById(UUID id);

}
