package br.repository;

import br.model.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ConsoleRepository {

    private ConsoleRepository() {
        gamelist = new ArrayList<>();
        gamelist.addAll(Arrays.asList(
                new Console(1L, "Atari 2600", "Atari", LocalDate.of(1977, 9, 11), "URL"),
                new Console(2L, "Mega Drive", "SEGA", LocalDate.of(1988, 10, 29), "URL"),
                new Console(3L, "Super Nintendo", "Nintendo", LocalDate.of(1990, 11, 21), "URL")
        ));
    }

    private static ConsoleRepository instance;

    public static ConsoleRepository getInstance() {
        if (instance == null) {
            instance = new ConsoleRepository();
        }
        return instance;
    }

    private final List<Console> gamelist;

    public List<Console> getGamelist() {
        return gamelist;
    }

    public Console save(Console entity) {
        if (entity.getId() == null) {
            entity.setId((long) (Math.random() * 1000));
        }
        gamelist.add(entity);
        return entity;
    }
}
