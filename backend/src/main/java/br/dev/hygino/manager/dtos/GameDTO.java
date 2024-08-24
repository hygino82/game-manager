package br.dev.hygino.manager.dtos;

import br.dev.hygino.manager.entities.Game;

import java.time.LocalDate;
import java.util.UUID;

public record GameDTO(
        UUID id,
        String name,
        String personalCode,
        LocalDate releaseDate,
        String imageUrl,
        String consoleName
) {
    public GameDTO(Game obj) {
        this(
                obj.getId(),
                obj.getName(),
                obj.getPersonalCode(),
                obj.getReleaseDate(),
                obj.getImageUrl(),
                obj.getConsole().getName()
        );
    }
}
