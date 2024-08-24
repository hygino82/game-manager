package br.dev.hygino.manager.repositories;

import br.dev.hygino.manager.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {

	@Query("""
			SELECT obj FROM Game obj WHERE obj.id =?1
			""")
	Optional<Game> findGameById(UUID id);
}
