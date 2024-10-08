package br.dev.hygino.manager.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.dev.hygino.manager.entities.Console;

public record ConsoleDTO(
		UUID id, String name, 
		String company, 
		LocalDate releaseDate,
		String imageUrl,
		LocalDateTime createAt, 
		LocalDateTime updateAt) {
	public ConsoleDTO(Console entity) {
		this(
				entity.getId(), 
				entity.getName(), 
				entity.getCompany(), 
				entity.getReleaseDate(), 
				entity.getImageUrl(),
				entity.getCreateAt(), 
				entity.getUpdateAt());
	}
}
