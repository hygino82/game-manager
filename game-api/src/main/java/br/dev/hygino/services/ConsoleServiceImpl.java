package br.dev.hygino.services;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;
import br.dev.hygino.entities.Console;
import br.dev.hygino.repositories.ConsoleRepository;
import br.dev.hygino.services.exceptions.DatabaseException;
import br.dev.hygino.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsoleServiceImpl implements ConsoleService {
	private final ConsoleRepository consoleRepository;

	public ConsoleServiceImpl(ConsoleRepository consoleRepository) {
		this.consoleRepository = consoleRepository;
	}

	@Override
	@Transactional
	public ConsoleDTO insert(ConsoleInsertDTO dto) {
		Console entity = new Console(dto);
		entity = this.consoleRepository.saveAndFlush(entity);
		return new ConsoleDTO(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ConsoleDTO> findAll(Pageable pageable) {
		Page<Console> page = this.consoleRepository.findAll(pageable);
		return page.map(ConsoleDTO::new);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> findById(String id) {
		var res = this.consoleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return ResponseEntity.status(HttpStatus.OK).body(new ConsoleDTO(res));
	}

	@Override
	@Transactional
	public ResponseEntity<?> updateById(String id, ConsoleInsertDTO dto) {
		try {
			Console entity = this.consoleRepository.getReferenceById(id);
			entity = this.consoleRepository.save(copyDtoToEntity(dto, entity));
			return ResponseEntity.status(HttpStatus.OK).body(new ConsoleDTO(entity));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}

	private Console copyDtoToEntity(ConsoleInsertDTO dto, Console entity) {
		entity.setName(dto.name());
		entity.setReleaseYear(dto.releaseYear());
		entity.setImgUrl(dto.imgUrl());
		entity.setUpdatedAt(Instant.now());
		return entity;
	}

	@Override
	public void remove(String id) {
		try {
			consoleRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

}
