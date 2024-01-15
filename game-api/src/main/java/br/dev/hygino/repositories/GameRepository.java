package br.dev.hygino.repositories;

import br.dev.hygino.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {
}
