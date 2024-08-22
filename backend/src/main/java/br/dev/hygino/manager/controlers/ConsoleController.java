package br.dev.hygino.manager.controlers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.dev.hygino.manager.dtos.ConsoleDTO;
import br.dev.hygino.manager.dtos.RequestConsoleDTO;
import br.dev.hygino.manager.services.ConsoleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("api/v1/console")
public class ConsoleController {
	private final ConsoleService consoleService;

	public ConsoleController(ConsoleService consoleService) {
		this.consoleService = consoleService;
	}

	@PostMapping
	public ResponseEntity<ConsoleDTO> insert(@Valid @RequestBody RequestConsoleDTO dto) {
		final var res = consoleService.insert(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}

	@GetMapping
	public ResponseEntity<Page<ConsoleDTO>> findAllConsoles(Pageable pageable) {
		final Page<ConsoleDTO> page = consoleService.findAllConsoles(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConsoleDTO> findConsoleById(@PathVariable UUID id) {
		final ConsoleDTO res = consoleService.findConsoleById(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ConsoleDTO> updateConsoleById(@PathVariable UUID id,
			@Valid @RequestBody RequestConsoleDTO dto) {
		final ConsoleDTO res = consoleService.updateConsoleById(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeConsoleById(@PathVariable UUID id) {
		consoleService.removeConsoleById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ConsoleDTO> updateImageUrlById(
			@PathVariable UUID id,
			@RequestBody @NotBlank String imageUrl) {
		final ConsoleDTO res = consoleService.updateImageUrlById(id, imageUrl);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
}
