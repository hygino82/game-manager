package br.repository;

import br.model.Console;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public final class ConsoleRepository {

    private ConsoleRepository() {
    }

    private static ConsoleRepository instance;

    public static ConsoleRepository getInstance() {
        if (instance == null) {
            instance = new ConsoleRepository();
        }
        return instance;
    }

    private final List<Console> gamelist = Arrays.asList(
            new Console(1L,
                    "Atari 2600",
                    "Atari",
                    LocalDate.of(1977, 9, 11),
                    "https://pt.wikipedia.org/wiki/Atari_2600#/media/Ficheiro:Atari-2600-Wood-4Sw-Set.png"),
            new Console(2L,
                    "Mega Drive",
                    "SEGA",
                    LocalDate.of(1988, 10, 29),
                    "https://pt.wikipedia.org/wiki/Mega_Drive#/media/Ficheiro:Sega-Mega-Drive-JP-Mk1-Console-Set.jpg"),
            new Console(3L,
                    "Super Nintendo",
                    "Nintendo",
                    LocalDate.of(1990, 11, 21),
                    "https://pt.wikipedia.org/wiki/Super_Nintendo_Entertainment_System#/media/Ficheiro:SNES-Mod1-Console-Set.jpg")
    );

    public List<Console> getGamelist() {
        return gamelist;
    }
}
