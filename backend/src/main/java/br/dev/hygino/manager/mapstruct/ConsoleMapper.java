package br.dev.hygino.manager.mapstruct;

import br.dev.hygino.manager.dtos.ConsoleDTO;
import br.dev.hygino.manager.dtos.UpdateConsoleDTO;
import br.dev.hygino.manager.entities.Console;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ConsoleMapper {

	void updateConsole(UpdateConsoleDTO dto, @MappingTarget Console entity);

	ConsoleDTO entityToDto(Console entity);
}
