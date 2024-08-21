package br.dev.hygino.manager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestConsoleDTO(
		@NotBlank @Size(min = 3, max = 40)String name, 
		@NotBlank @Size(min = 3, max = 40)String company,
		@NotBlank String releaseDate,
		String imageUrl) {
}
