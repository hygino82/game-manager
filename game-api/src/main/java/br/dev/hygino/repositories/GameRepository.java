package br.dev.hygino.repositories;

import br.dev.hygino.entities.Game;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, String> {
	@Query("""
			SELECT obj from Game obj
			WHERE obj.console.id = :id
			""")
	Page<Game> findByConsoleId(Pageable pageable, String id);
}
