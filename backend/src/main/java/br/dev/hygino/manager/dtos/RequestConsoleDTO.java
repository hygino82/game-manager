package br.dev.hygino.manager.dtos;

import jakarta.validation.constraints.NotBlank;

public record RequestConsoleDTO(
		@NotBlank String name, 
		@NotBlank String company,
		@NotBlank String releaseDate,
		@NotBlank String imageUrl) {
}
