package br.dev.hygino.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.hygino.dto.ResponseConsoleDTO;
import br.dev.hygino.services.ConsoleService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/console")
@RequiredArgsConstructor
public class ConsoleController {

    private final ConsoleService service;

    @GetMapping
    public ResponseEntity<List<ResponseConsoleDTO>> buscarTodos() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

}
