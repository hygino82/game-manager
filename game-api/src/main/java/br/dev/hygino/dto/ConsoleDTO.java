package br.dev.hygino.dto;

import br.dev.hygino.entities.Console;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public record ConsoleDTO(
        String id,
        String name,
        Short releaseYear,
        Instant createdAt,
        Instant updatedAt
) {
    public ConsoleDTO(Console entity) {
        this(entity.getId(), entity.getName(), entity.getReleaseYear(), entity.getCreatedAt(), entity.getUpdatedAt());
    }
}
