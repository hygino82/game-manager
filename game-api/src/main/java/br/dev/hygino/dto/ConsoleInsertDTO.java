package br.dev.hygino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ConsoleInsertDTO(@NotBlank @Size(max = 100, min = 3) String name, @NotNull Short releaseYear) {
}
