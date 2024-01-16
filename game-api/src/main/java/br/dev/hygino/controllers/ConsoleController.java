package br.dev.hygino.controllers;

import br.dev.hygino.dto.ConsoleDTO;
import br.dev.hygino.dto.ConsoleInsertDTO;
import br.dev.hygino.services.ConsoleService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
