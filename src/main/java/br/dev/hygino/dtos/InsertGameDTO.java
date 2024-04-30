package br.dev.hygino.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InsertGameDTO(
        @NotBlank @Size(min = 3, max = 40) String name,
        String imageUrl,
        String personalCode,
        @NotNull Integer releaseYear,
        @NotNull Long consoleId

) {

}
