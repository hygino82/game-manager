package br.dev.hygino.manager.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
		return ResponseEntity.status(HttpStatus.CREATED).body(consoleService.insert(dto));
	}
}
