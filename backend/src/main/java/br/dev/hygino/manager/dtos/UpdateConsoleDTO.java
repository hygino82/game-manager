package br.dev.hygino.manager.dtos;

import jakarta.validation.constraints.Size;

public record UpdateConsoleDTO(
        @Size(min = 3, max = 40) String name,
        @Size(min = 3, max = 40) String company,
        String releaseDate,
        String imageUrl) {
}
