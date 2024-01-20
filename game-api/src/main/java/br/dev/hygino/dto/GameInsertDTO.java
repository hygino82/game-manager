package br.dev.hygino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GameInsertDTO(
		@NotBlank @Size(max = 100, min = 3) String name, 
		Integer releaseYear, 
		String imageUrl,
		String personalCode, 
		@NotBlank String consoleId) {
}
