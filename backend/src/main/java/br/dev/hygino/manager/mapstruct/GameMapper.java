package br.dev.hygino.manager.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.dev.hygino.manager.dtos.GameDTO;
import br.dev.hygino.manager.dtos.RequestConsoleDTO;
import br.dev.hygino.manager.entities.Game;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GameMapper {

	void updateGame(RequestConsoleDTO dto, @MappingTarget Game entity);

	void entityToDto(Game entity, @MappingTarget GameDTO dto);
}
