package br.dev.hygino.manager.controlers;

import java.util.List;
import java.util.UUID;

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

import br.dev.hygino.manager.dtos.ConsoleDTO;
import br.dev.hygino.manager.dtos.RequestConsoleDTO;
import br.dev.hygino.manager.services.ConsoleService;
import jakarta.validation.Valid;

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
	public ResponseEntity<List<ConsoleDTO>> findAllConsoles() {
		final List<ConsoleDTO> list = consoleService.findAllConsoles();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConsoleDTO> findConsoleById(@PathVariable UUID id) {
		final ConsoleDTO res = consoleService.findConsoleById(id);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ConsoleDTO> updateConsoleById(
			@PathVariable UUID id,
			@Valid @RequestBody RequestConsoleDTO dto) {
		final ConsoleDTO res = consoleService.updateConsoleById(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeConsoleById(@PathVariable UUID id){
		consoleService.removeConsoleById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
