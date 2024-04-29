package br.dev.hygino.controllers;

import br.dev.hygino.dtos.ConsoleDTO;
import br.dev.hygino.dtos.InsertConsoleDTO;
import br.dev.hygino.services.ConsoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PutMapping("/{id}")
    public ResponseEntity<ConsoleDTO> update(@PathVariable Long id, @RequestBody InsertConsoleDTO dto) {
        ConsoleDTO res = consoleService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping
    public ResponseEntity<Page<ConsoleDTO>> findAll(Pageable pageable) {
        Page<ConsoleDTO> page = consoleService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsoleDTO> findById(@PathVariable Long id) {
        ConsoleDTO res = consoleService.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        consoleService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
