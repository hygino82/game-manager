package br.dev.hygino.manager.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.hygino.manager.dtos.ConsoleDTO;
import br.dev.hygino.manager.dtos.RequestConsoleDTO;
import br.dev.hygino.manager.entities.Console;
import br.dev.hygino.manager.repositories.ConsoleRepository;

@Service
public class ConsoleService {
	private final ConsoleRepository consoleRepository;

	public ConsoleService(ConsoleRepository consoleRepository) {
		this.consoleRepository = consoleRepository;
	}

	@Transactional
	public ConsoleDTO insert(RequestConsoleDTO dto) {
		Console entity = new Console();
		dtoToEntity(dto, entity);
		entity = consoleRepository.save(entity);

		return new ConsoleDTO(entity);
	}

	private void dtoToEntity(RequestConsoleDTO dto, Console entity) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			final LocalDate date = LocalDate.parse(dto.releaseDate(), formatter);
			entity.setReleaseDate(date);
		} catch (DateTimeParseException ex) {
			throw new IllegalArgumentException("A data está em formato inválido!");
		}

		entity.setName(dto.name());
		entity.setCompany(dto.company());
		entity.setImageUrl(dto.imageUrl());
	}

	@Transactional(readOnly = true)
	public List<ConsoleDTO> findAllConsoles() {
		return consoleRepository.findAll().stream().map(ConsoleDTO::new).toList();
	}
}
