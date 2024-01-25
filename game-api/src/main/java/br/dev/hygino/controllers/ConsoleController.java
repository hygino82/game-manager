package br.dev.hygino.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;
import br.dev.hygino.services.ConsoleService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/console")
public class ConsoleController {
	private final ConsoleService consoleService;

	public ConsoleController(ConsoleService consoleService) {
		this.consoleService = consoleService;
	}

	@PostMapping
	public ResponseEntity<ConsoleDTO> insert(@RequestBody @Valid ConsoleInsertDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.consoleService.insert(dto));
	}

	@GetMapping
	public ResponseEntity<Page<ConsoleDTO>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(this.consoleService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		return this.consoleService.findById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable UUID id, @RequestBody @Valid ConsoleInsertDTO dto) {
		return this.consoleService.updateById(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable UUID id) {
		this.consoleService.remove(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
