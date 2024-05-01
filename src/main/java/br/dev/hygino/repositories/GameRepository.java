package br.dev.hygino.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.dev.hygino.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT obj FROM Game obj WHERE obj.id = :id")
    Optional<Game> findGame(Long id);

}
