package br.dev.hygino.manager.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;

import br.dev.hygino.manager.dtos.UpdateConsoleDTO;
import br.dev.hygino.manager.exceptions.DataBaseException;
import br.dev.hygino.manager.mapstruct.ConsoleMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.hygino.manager.dtos.ConsoleDTO;
import br.dev.hygino.manager.dtos.RequestConsoleDTO;
import br.dev.hygino.manager.entities.Console;
import br.dev.hygino.manager.exceptions.ResourceNotFoundException;
import br.dev.hygino.manager.repositories.ConsoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class ConsoleService {
	private final ConsoleRepository consoleRepository;
	private final ConsoleMapper consoleMapper;

	public ConsoleService(ConsoleRepository consoleRepository, ConsoleMapper consoleMapper) {
		this.consoleRepository = consoleRepository;
		this.consoleMapper = consoleMapper;
	}

	@Transactional
	public ConsoleDTO insert(RequestConsoleDTO dto) {
		Console entity = new Console();
		entity.setCreateAt(LocalDateTime.now());
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
	public Page<ConsoleDTO> findAllConsoles(Pageable pageable) {
		return consoleRepository.findAll(pageable).map(ConsoleDTO::new);
	}

	@Transactional(readOnly = true)
	public ConsoleDTO findConsoleById(UUID id) {
		Console entity = consoleRepository.findConsoleById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe console com o id: " + id));

		return new ConsoleDTO(entity);
	}

	@Transactional
	public ConsoleDTO updateConsoleById(UUID id, @Valid UpdateConsoleDTO dto) {
		try {
			Console entity = consoleRepository.getReferenceById(id);
			entity.setUpdateAt(LocalDateTime.now());
			consoleMapper.updateConsole(dto, entity);
			return new ConsoleDTO(consoleRepository.save(entity));
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException("Não existe console com o id: " + id);
		}
	}

	public void removeConsoleById(UUID id) {
		try {
			consoleRepository.deleteById(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DataBaseException("Erro Console com jogos associados!");
		}
	}

	@Transactional
	public ConsoleDTO updateImageUrlById(UUID id, String imageUrl) {
		try {
			Console entity = consoleRepository.getReferenceById(id);
			entity.setUpdateAt(LocalDateTime.now());
			entity.setImageUrl(imageUrl);
			return new ConsoleDTO(consoleRepository.save(entity));
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException("Não existe console com o id: " + id);
		}
	}

	@Transactional(readOnly = true)
	public List<ConsoleDTO> listAllConsoles() {
		List<Console> list = consoleRepository.findAll();
		return list.stream().map(consoleMapper::entityToDto).toList();
	}
}
