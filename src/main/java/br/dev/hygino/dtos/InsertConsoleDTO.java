package br.dev.hygino.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InsertConsoleDTO(
                               @NotBlank
                               @Size(min = 3, max = 40)
                               String name,

                               @NotBlank
                               String imageUrl,

                               @NotNull
                               Integer releaseYear
) {
}
