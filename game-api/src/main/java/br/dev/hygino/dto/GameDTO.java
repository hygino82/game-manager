package br.dev.hygino.dto;

import java.util.Date;
import java.util.UUID;

import br.dev.hygino.entities.Game;

public record GameDTO(
		UUID id, 
		String name, 
		Integer releaseYear, 
		String imageUrl, 
		String personalCode,
		String consoleName, 
		Date createdAt, 
		Date updatedAt) {
	public GameDTO(Game entity) {
		this(
				entity.getId(), 
				entity.getName(), 
				entity.getReleaseYear(), 
				entity.getImageUrl(), 
				entity.getPersonalCode(),
				entity.getConsole().getName(),
				entity.getCreateDate(), 
				entity.getUpdateDate()
				);
	}
}
