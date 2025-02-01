package br.dev.hygino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.dev.hygino.entities.Console;

public interface ConsoleRepository extends JpaRepository<Console, Long> {

    @Query("""
            select obj from Console obj
            """)
    List<Console> buscarTodos();
}
