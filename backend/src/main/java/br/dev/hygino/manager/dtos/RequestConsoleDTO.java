package br.dev.hygino.manager.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestConsoleDTO(
		@NotBlank String name, 
		@NotBlank String company, 
		@NotNull LocalDate releaseDate,
		@NotBlank String imageUrl) {
}
