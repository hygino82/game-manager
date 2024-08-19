package br.dev.hygino.manager.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.hygino.manager.dtos.ConsoleDTO;
import br.dev.hygino.manager.dtos.RequestConsoleDTO;
import br.dev.hygino.manager.entities.Console;
import br.dev.hygino.manager.repositories.ConsoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

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

	@Transactional(readOnly = true)
	public ConsoleDTO findConsoleById(UUID id) {
		Console entity = consoleRepository.findConsoleById(id)
				.orElseThrow(() -> new IllegalArgumentException("Não existe console com o id: " + id));

		return new ConsoleDTO(entity);
	}

	@Transactional
	public ConsoleDTO updateConsoleById(UUID id, @Valid RequestConsoleDTO dto) {
		try {
			Console entity = consoleRepository.getReferenceById(id);
			dtoToEntity(dto, entity);
			return new ConsoleDTO(consoleRepository.save(entity));
		} catch (EntityNotFoundException ex) {
			throw new IllegalArgumentException("Não existe console com o id: " + id);
		}
	}

	public void removeConsoleById(UUID id) {
		try {
			consoleRepository.deleteById(id);
		} catch (DataIntegrityViolationException ex) {
			new IllegalArgumentException("Erro Console com jogos associados!");
		}
	}
}
