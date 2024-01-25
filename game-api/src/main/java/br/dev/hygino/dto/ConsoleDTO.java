package br.dev.hygino.dto;

import java.util.Date;
import java.util.UUID;

import br.dev.hygino.entities.Console;

public record ConsoleDTO(UUID id, String name, Short releaseYear, String imgUrl, Date createdAt, Date updatedAt) {
	public ConsoleDTO(Console entity) {
		this(
				entity.getId(), 
				entity.getName(), 
				entity.getReleaseYear(), 
				entity.getImgUrl(), 
				entity.getCreatedAt(),
				entity.getUpdatedAt()
				);
	}
}
