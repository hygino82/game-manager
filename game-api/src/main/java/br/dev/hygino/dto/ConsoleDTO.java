package br.dev.hygino.dto;

import java.time.Instant;

import br.dev.hygino.entities.Console;

public record ConsoleDTO(
        String id,
        String name,
        Short releaseYear,
        String imgUrl,
        Instant createdAt,
        Instant updatedAt
) {
    public ConsoleDTO(Console entity) {
        this(entity.getId(), entity.getName(), entity.getReleaseYear(), entity.getImgUrl(), entity.getCreatedAt(), entity.getUpdatedAt());
    }
}
