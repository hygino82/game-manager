package br.dev.hygino.dtos;

import br.dev.hygino.entities.Console;

import java.util.Date;

public record ConsoleDTO(
        Long id,
        String name,
        String imgUrl,
        Integer releaseYear,
        Date createdAt,
        Date updateAt
) {
    public ConsoleDTO(Console obj) {
        this(
                obj.getId(),
                obj.getName(),
                obj.getImageUrl(),
                obj.getReleaseYear(),
                obj.getCreatedAt(),
                obj.getUpdateAt()
        );
    }
}
