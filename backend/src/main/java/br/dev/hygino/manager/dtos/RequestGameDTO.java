package br.dev.hygino.manager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record RequestGameDTO(
        @NotBlank @Size(min = 3, max = 40) String name,
        @NotNull LocalDate releaseDate,
        @NotBlank @Size(min = 3, max = 40) String personalCode,
        String imageUrl,
        @NotNull UUID consoleId
) {
}
