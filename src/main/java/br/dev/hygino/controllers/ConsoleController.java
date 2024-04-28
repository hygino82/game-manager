package br.dev.hygino.controllers;

import br.dev.hygino.dtos.ConsoleDTO;
import br.dev.hygino.dtos.InsertConsoleDTO;
import br.dev.hygino.services.ConsoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/console")
@CrossOrigin("*")
public class ConsoleController {
    private final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @PostMapping
    public ResponseEntity<ConsoleDTO> insert(@RequestBody InsertConsoleDTO dto) {
        ConsoleDTO res = consoleService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
