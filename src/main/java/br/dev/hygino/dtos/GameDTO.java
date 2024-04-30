package br.dev.hygino.dtos;

import java.util.Date;

import br.dev.hygino.entities.Game;

public record GameDTO(
                Long id,
                String name,
                String imageUrl,
                String personalCode,
                Integer releaseYear,
                String consoleName,
                Date createAt,
                Date updateAt

) {
        public GameDTO(Game entity) {
                this(
                        entity.getId(),
                        entity.getName(),
                        entity.getImageUrl(),
                        entity.getPersonalCode(),
                        entity.getReleaseYear(),
                        entity.getConsole().getName(),
                        entity.getCreateAt(),
                        entity.getUpdateAt());
        }
}
