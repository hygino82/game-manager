package br.dev.hygino.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.dev.hygino.entities.Game;

public interface GameRepository extends JpaRepository<Game, UUID> {
	@Query("""
			SELECT obj from Game obj
			WHERE obj.console.id = :id
			""")
	Page<Game> findByConsoleId(Pageable pageable, UUID id);
}
